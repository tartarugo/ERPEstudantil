package br.com.thiagocortes.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.thiagocortes.entidades.Disciplina;

public class DisciplinaDAO {
	
	private static Connection con = Conexao.getConection();
		
	public void cadastrar(Disciplina disciplina){
		String sql = "INSERT INTO disciplinas(nome,descricao,carga_horaria) VALUES (?,?,?)";
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, disciplina.getNome());
			stm.setString(2, disciplina.getDescricao());
			stm.setInt(3, disciplina.getCargaHoraria());
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
	
	public void alterar(Disciplina disciplina){
		String sql = "UPDATE disciplinas SET nome=?, descricao=?, carga_horaria=? WHERE id = ?";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, disciplina.getNome());
			stm.setString(2, disciplina.getDescricao());
			stm.setInt(3, disciplina.getCargaHoraria());
			stm.setInt(4, disciplina.getIdDisciplina());

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
	
	public void delete(Disciplina disciplina){
		String sql = "DELETE FROM disciplinas WHERE id = ?";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, disciplina.getIdDisciplina());
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
	
	public List<Disciplina> consultar(){
		
		Disciplina disciplina = new Disciplina();
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		String sql = "SELECT * FROM disciplinas";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet resultado = stm.executeQuery();
			
			while(resultado.next()){
				disciplina.setIdDisciplina(resultado.getInt("id"));
				disciplina.setNome(resultado.getString("nome"));
				disciplina.setDescricao(resultado.getString("descricao"));
				disciplina.setCargaHoraria(resultado.getInt("carga_horaria"));
				disciplinas.add(disciplina);
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
		return disciplinas;
	}
	
	public Disciplina buscarId(Disciplina disciplina){
		String sql = "SELECT * FROM disciplinas WHERE id = ?";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, disciplina.getIdDisciplina());
			ResultSet resultado = stm.executeQuery();
			if(resultado != null && resultado.next()){
				
				disciplina.setNome(resultado.getString("nome"));
				disciplina.setCargaHoraria(resultado.getInt("carga_horaria"));
				disciplina.setDescricao(resultado.getString("descricao"));
				
			}
			else{
				System.out.println("Disciplina não localizada");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return disciplina;
	}
}
