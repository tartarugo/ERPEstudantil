package br.com.thiagocortes.entidades;

public class Grade {
	
	private int idGrade; 
	private int cursoIdCurso;
	private int disciplinaIdDisciplina;
	Curso curso = new Curso();
	
	public int getIdGrade() {
		return idGrade;
	}
	public void setIdGrade(int idGrade) {
		this.idGrade = idGrade;
	}
	public int getCursoIdCurso() {
		return cursoIdCurso;
	}
	public void setCursoIdCurso(int cursoIdCurso) {
		this.cursoIdCurso = cursoIdCurso;
	}
	public int getDisciplinaIdDisciplina() {
		return disciplinaIdDisciplina;
	}
	public void setDisciplinaIdDisciplina(int disciplinaIdDisciplina) {
		this.disciplinaIdDisciplina = disciplinaIdDisciplina;
	}
	
}
