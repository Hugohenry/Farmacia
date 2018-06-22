<%@page import="entidades.Medico"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Listar Medico</title>
	</head>
	<body>
		<h1>Adicionar Medico</h1>
		<form action="AdicionarMedico" method="post">
			<label>Login:&nbsp;&nbsp;</label> <input type="text" name="login" placeholder="DrJulio" required/> <br/>
			<label>Senha:&nbsp;&nbsp;</label> <input type="password" name="password"/> <br/>
			<br/><input type="submit" value="Criar"/>
		</form>
	<% List<Medico> med = (ArrayList<Medico>)request.getAttribute("medicos"); 
if(med != null) { %>
		<h1>Lista de Medicos</h1>
		<table>
		<tr>
			<th>Login</th>
			<th>Senha</th>
			<th>Editar</th>
			<th>Remover</th>
		</tr>
	<%
	for( Medico m : med) { %>
			<tr>
				<td><%= m.getLogin() %></td>
				<td><%= m.getSenha() %></td>
				<td><a href=AtualizarMedico?id=<%= m.getId()%>>Editar</a></td>
				<td><a href=RemoverMedico?id=<%= m.getId()%>>Remover</a></td>
			</tr>
			
	<% }
}else {%>
			<p>Ops, um erro ocorreu!</p>
<%}%>
		</table>
	</body>
</html>