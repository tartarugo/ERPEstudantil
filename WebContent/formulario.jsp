<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="estilos/css.css">
</head>
<body>
<div class="formulario">
	<fieldset>
	<legend>Cadastro de Disciplinas</legend>
		<form action="cadastrar" method="POST">
			<label>
				<span>Nome: </span>
				<input type="text" name="nome" id="nome">
			</label>
			<label>
				<span>Descrição: </span>
				<input type="text" name="descricao" id="descricao">
			</label>
			<label>
				<span>Carga Horária: </span>
				<input type="number" name="carga" id="carga">
			</label>
			
			<label>
				<input type="submit" value="Enviar">
				<button><a href="DisciplinaExibir" targer="_blak">Ver Disciplinas</a></button>
			</label>
		</form>
		<%
			DisciplinaDAO dao = new DisciplinaDAO();
			List<Disciplina> disciplinas = dao.consultar();
		%>
		<table>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Carga Horária</th>
			</tr>
			<tr>
				<td>${disciplina.idDisciplina}</td>
				<td>${disciplina.nome}</td>
				<td>${disciplina.descricao}</td>
				<td>${disciplina.cargaHoraria}</td>
			</tr>
		</table>		
	</fieldset>
	</div>
</body>
</html>