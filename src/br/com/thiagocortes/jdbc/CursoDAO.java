package br.com.thiagocortes.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.thiagocortes.entidades.Curso;


public class CursoDAO {

	private static Connection con = Conexao.getConection();
		
	public void cadastrar(Curso curso){
		String sql = "INSERT INTO curso(nome_curso,descricao) VALUES (?,?)";
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, curso.getNomeCurso());
			stm.setString(2, curso.getDescricao());
			stm.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	public void alterar(Curso curso){
		String sql = "UPDATE curso SET nome_curso=?, descricao=? WHERE id_curso = ?";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, curso.getNomeCurso());
			stm.setString(2, curso.getDescricao());
			stm.setInt(4, curso.getIdCurso());

			stm.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	public void delete(Curso curso){
		String sql = "DELETE FROM curso WHERE id_curso = ?";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, curso.getIdCurso());
			stm.execute();
			System.out.println("Excluido com sucesso");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	public List<Curso> consultar(){
		
		Curso curso = new Curso();
		List<Curso> cursos = new ArrayList<Curso>();
		String sql = "SELECT * FROM curso";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet resultado = stm.executeQuery();
			
			while(resultado.next()){
				curso.setIdCurso(resultado.getInt("id_curso"));
				curso.setNomeCurso(resultado.getString("nome_curso"));
				curso.setDescricao(resultado.getString("descricao"));
				cursos.add(curso);
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
		return cursos;
	}
	
	public Curso buscarId(Curso curso){
		String sql = "SELECT * FROM curso WHERE id_curso = ?";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, curso.getIdCurso());
			ResultSet resultado = stm.executeQuery();
			if(resultado != null && resultado.next()){
				
				curso.setNomeCurso(resultado.getString("nome_curso"));
				curso.setDescricao(resultado.getString("descricao"));
				
			}
			else{
				System.out.println("Curso não localizada");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return curso;
	}
}
