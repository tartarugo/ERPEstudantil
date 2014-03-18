package br.com.thiagocortes.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.thiagocortes.entidades.Disciplina;
import br.com.thiagocortes.jdbc.DisciplinaDAO;


@WebServlet("/ControlerDisciplina.do")
public class ControlerDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControlerDisciplina() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Metodo GET");
		
		//Obter a lista
		DisciplinaDAO dao = new DisciplinaDAO();
		ArrayList<Disciplina> lista = (ArrayList<Disciplina>) dao.consultar();
		
		//engavetar no request
		request.setAttribute("lista", lista);
		
		//encaminhar para jsp		
		request.getRequestDispatcher("listar_disciplina.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recebendo dados da tela
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		int carga = Integer.parseInt(request.getParameter("carga"));
		
		//atribuindo dados recebidos ao objeto
		Disciplina disciplina = new Disciplina();
		disciplina.setNome(nome);
		disciplina.setDescricao(descricao);
		disciplina.setCargaHoraria(carga);
		
		//incluindo o objeto para a classe dao inserir no banco
		DisciplinaDAO dao = new DisciplinaDAO();
		dao.cadastrar(disciplina);
		
		//após inserir, o sistema exibirá os dados no navegador
		PrintWriter resposta = response.getWriter();
		resposta.println("Nome: "+nome);
		resposta.println("Descrição: "+descricao);
		resposta.println("Carga Horária: "+carga);
	}

}
