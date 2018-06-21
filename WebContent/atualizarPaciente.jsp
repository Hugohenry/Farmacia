<%@page import="entidades.Paciente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Atualizar Paciente</title>
	</head>
		<% Paciente p = (Paciente)request.getAttribute("paciente"); %>
	<body>
		<h1>Atualizar Paciente</h1>
<%if(p != null) {%>
		<form action="AtualizarPaciente" method="post">
			<input name="id" type="hidden" value="<%= p.getId() %>"/>
			<label>Login:&nbsp;&nbsp;</label> <input type="text" name="login" placeholder="Saci2018" value="<%= p.getLogin() %>" required/> <br/>
			<label>Senha:&nbsp;&nbsp;</label> <input type="password" name="password" value="<%= p.getSenha() %>"/> <br/>
			<label>Nome:&nbsp;&nbsp;</label> <input type="text" name="nome" placeholder="Saci" value="<%= p.getNome() %>" required/> <br/>
			<label>Sobremome:&nbsp;&nbsp;</label> <input type="text" name="sobrenome" placeholder="Pererê" value="<%= p.getSobrenome() %>" required/> <br/>
			<label>Idade:&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="number" name="idade" min="1" max="115" value="<%= p.getIdade() %>" required/><br/>
			<label>Sexo:</label><br/>
		 <%if(p.isSexo() == true) { %>
			<input type="radio" name="sexo" value="true" checked="checked" required/><label>Macho</label>
			<input type="radio" name="sexo" value="false"/><label>Fêmea</label><br/>
		<%}else {%>
			<input type="radio" name="sexo" value="true" required/><label>Macho</label>
			<input type="radio" name="sexo" value="false" checked="checked"/><label>Fêmea</label><br/>
			<%}%>
			<br/><input type="submit" value="Criar"/>
		</form>
<%}else {%>
		<p>Ops! Um erro ocorreu.</p>
<%}%>
	</body>
</html>