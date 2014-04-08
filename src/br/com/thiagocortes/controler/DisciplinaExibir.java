package br.com.thiagocortes.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.thiagocortes.entidades.Disciplina;
import br.com.thiagocortes.jdbc.DisciplinaDAO;

@WebServlet("/DisciplinaExibir")
public class DisciplinaExibir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisciplinaExibir() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DisciplinaDAO dao = new DisciplinaDAO();
		List<Disciplina> disciplinas = dao.consultar();
		
		request.setAttribute("lista", disciplinas);
		request.getRequestDispatcher("listar_disciplina.jsp").forward(request, response);
		/*
		String htmlSaida = "<html> <head><title>Lista de Disciplinas</title></head><body>" +
		"<table border='1px'><tr><th>ID</th><th>Nome</th><th>Descrição</th><th>Carga Horária</th></tr>";
		for(Disciplina disci : disciplinas){
			htmlSaida += "<tr><td>"+disci.getIdDisciplina()+"</td><td>"+disci.getNome()+
			"</td><td>"+disci.getDescricao()+"</td><td>"+disci.getCargaHoraria()+"</td></tr>";
		}
		htmlSaida +="</table></body></html>";
		PrintWriter saida = response.getWriter();
		saida.println(htmlSaida);*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
