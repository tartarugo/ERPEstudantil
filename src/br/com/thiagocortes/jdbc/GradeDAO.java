package br.com.thiagocortes.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.thiagocortes.entidades.Grade;


public class GradeDAO {

	private static Connection con = Conexao.getConection();
		
	public void cadastrar(Grade grade){
		String sql = "INSERT INTO grade(id_grade, curso_id_curso, disciplina_id_disciplina) VALUES (?,?,?)";
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, grade.getIdGrade());
			stm.setInt(2, grade.getCursoIdCurso());
			stm.setInt(3, grade.getDisciplinaIdDisciplina());		
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
	
	public void alterar(Grade grade){
		String sql = "UPDATE grade SET disciplina_id_disciplina=?, curso_id_curso=? WHERE id_grade = ?";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, grade.getCursoIdCurso());
			stm.setInt(2, grade.getDisciplinaIdDisciplina());
			stm.setInt(3, grade.getIdGrade());

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
	
	public void delete(Grade grade){
		String sql = "DELETE FROM grade WHERE id_grade = ?";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, grade.getIdGrade());
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
	
	public List<Grade> consultar(){
		
		Grade grade = new Grade();
		List<Grade> grades = new ArrayList<Grade>();
		String sql = "SELECT * FROM grade";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet resultado = stm.executeQuery();
			
			while(resultado.next()){
				grade.setIdGrade(resultado.getInt("id_grade"));
				grade.setCursoIdCurso(resultado.getInt("curso_id_curso"));
				grade.setDisciplinaIdDisciplina(resultado.getInt("disciplina_id_disciplina"));
				grades.add(grade);
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
		return grades;
	}
	
	public Grade buscarId(Grade grade){
		String sql = "SELECT * FROM grade WHERE id_grade = ?";
		
		try{
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setInt(1, grade.getIdGrade());
			ResultSet resultado = stm.executeQuery();
			if(resultado != null && resultado.next()){
				
				grade.setCursoIdCurso(resultado.getInt("curso_id_curso"));
				grade.setDisciplinaIdDisciplina(resultado.getInt("disciplina_id_disciplina"));
				
			}
			else{
				System.out.println("Grade não localizada");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return grade;
	}
}
