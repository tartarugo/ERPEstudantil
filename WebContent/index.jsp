<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.thiagocortes.entidades.*" %>
<%@page import="br.com.thiagocortes.jdbc.*" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="estilos/css.css">
<title>ERP Estudantil</title>
</head>
<body>
	<div class="total">
		<div class="topo_total">
			<div class="topo">Topo</div>
		</div>
		
		<div class="menu_principal">
			<div class="menu">
				<ul>
					<li>Cadastros
						<ul>
							<a href="cadastrar?menu=aluno"><li>Cadastro de Alunos</li></a>
							<a href="index.jsp?menu=disciplina"><li>Cadastro de Disciplinas</li></a>
							<a href="index.jsp?menu=professor"><li>Cadastro de Professores</li></a>
						</ul>
					</li>
					<li>Financeiro
						<ul>
							<a href="index.jsp?menu=aluno"><li>Cadastro de Alunos</li></a>
							<li>Cadastro de Disciplinas</li>
							<li>Cadastro de Professores</li>
						</ul>
					</li>
					<li>RH</li>
					<li>Estoque</li>
				</ul>
			</div>
		</div>
		<div class="conteudo_total">
			<div class="conteudo">
		
			</div>
		
		</div>
		<div class="rodape">Rodapé</div>
	</div>
</body>
</html>