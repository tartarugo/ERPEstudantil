package br.com.thiagocortes.teste;

import java.util.List;

import br.com.thiagocortes.entidades.Disciplina;
import br.com.thiagocortes.jdbc.DisciplinaDAO;

public class TesteDAO {
	
	public static void main(String[] args) {
		
		//testCadastrar();
		//testConsultar();
		//testExcluir();
		buscarId();
	}
	
	public static void testCadastrar(){
		Disciplina disciplina = new Disciplina();
		disciplina.setNome("POE");
		disciplina.setDescricao("Programacao orientada a Eventos");
		disciplina.setCargaHoraria(60);
		
		DisciplinaDAO dao = new DisciplinaDAO();
		
		dao.cadastrar(disciplina);	
	}
	public static void testConsultar(){
		DisciplinaDAO dao = new DisciplinaDAO();
				
		List<Disciplina> disciplinas = dao.consultar();
		
		for(Disciplina dscp : disciplinas){
			System.out.println(dscp.getIdDisciplina());
			System.out.println(dscp.getNome());
			System.out.println(dscp.getDescricao());
			System.out.println(dscp.getCargaHoraria());
		}
	}
	public static void testExcluir(){
		Disciplina disciplina = new Disciplina();
		DisciplinaDAO dao = new DisciplinaDAO();
		
		disciplina.setIdDisciplina(2);
		dao.delete(disciplina);
		
	}
	public static void buscarId(){
		Disciplina disciplina = new Disciplina();
		DisciplinaDAO dao = new DisciplinaDAO();
		
		disciplina.setIdDisciplina(11);
		
		dao.buscarId(disciplina);
		
		if(dao.buscarId(disciplina) == null){
			System.out.println("Não localizado");
		}
		else{
			String nome = disciplina.getNome();
			String descricao = disciplina.getDescricao();
			int cargaHoraria = disciplina.getCargaHoraria();
			System.out.println("Nome: "+nome);
		}
				
	}
}
