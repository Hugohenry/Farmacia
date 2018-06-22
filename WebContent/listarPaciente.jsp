<%@page import="entidades.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Listar Paciente</title>
	</head>
	<body>
		<h1>Adicionar Paciente</h1>
		<form action="AdicionarPaciente" method="post">
			<label>Login:&nbsp;&nbsp;</label> <input type="text" name="login" placeholder="Saci2018" required/> <br/>
			<label>Senha:&nbsp;&nbsp;</label> <input type="password" name="password"/> <br/>
			<label>Nome:&nbsp;&nbsp;</label> <input type="text" name="nome" placeholder="Saci" required/> <br/>
			<label>Sobremome:&nbsp;&nbsp;</label> <input type="text" name="sobrenome" placeholder="Pererê" required/> <br/>
			<label>Idade:&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="number" name="idade" min="1" max="115" required/><br/>
			<label>Sexo:</label><br/>
			<input type="radio" name="sexo" value="true" required/><label>Macho</label>
			<input type="radio" name="sexo" value="false"/><label>Fêmea</label><br/>
			<br/><input type="submit" value="Criar"/>
		</form>
	<% List<Paciente> pac = (ArrayList<Paciente>)request.getAttribute("pacientes"); 
if(pac != null) { %>
		<h1>Lista de Pacientes</h1>
		<table>
		<tr>
			<th>Login</th>
			<th>Senha</th>
			<th>Nome</th>
			<th>Sobrenome</th>
			<th>Idade</th>
			<th>Sexo</th>
			<th>Editar</th>
			<th>Remover</th>
		</tr>
	<%
	for( Paciente p : pac) { %>
			<tr>
				<td><%= p.getLogin() %></td>
				<td><%= p.getSenha() %></td>
				<td><%= p.getNome() %></td>
				<td><%= p.getSobrenome() %></td>
				<td><%= p.getIdade() %></td>
			<%if(p.isSexo() == true) {%>
				<td>Masculino</td>
			<%}else {%>
				<td>Feminino</td>
			<%}%>
				<td><a href=AtualizarPaciente?id=<%= p.getId()%>>Editar</a></td>
				<td><a href=RemoverPaciente?id=<%= p.getId()%>>Remover</a></td>
			</tr>
			
	<% }
}else {%>
			<p>Ops, um erro ocorreu!</p>
<%}%>
		</table>
	</body>
</html>