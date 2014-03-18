<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="br.com.thiagocortes.entidades.*" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Disciplinas</title>
</head>
<body>
<table border="1px">
	<tr>
		<th>Codigo</th>
		<th>Nome</th>
		<th>Descri��o</th>
		<th>Carga Hor�ria</th>
	</tr>
	
	<% 
	//scriptlet
		ArrayList<Disciplina> lista = (ArrayList<Disciplina>) request.getAttribute("lista");
	for (Disciplina disciplina : lista){ %>
	<tr>
		<td><%=(disciplina.getIdDisciplina()) %></td>
		<td><%=(disciplina.getNome()) %></td>
		<td><% out.print(disciplina.getDescricao()); %></td>
		<td><% out.print(disciplina.getCargaHoraria()); %></td>
	</tr>
	<% } %>

</table>

</body>
</html>