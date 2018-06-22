<%@page import="entidades.Medico"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Atualizar Medico</title>
	</head>
		<% Medico m = (Medico)request.getAttribute("medico"); %>
	<body>
		<h1>Atualizar Medico</h1>
<%if(m != null) {%>
		<form action="AtualizarMedico" method="post">
			<input name="id" type="hidden" value="<%= m.getId() %>"/>
			<label>Login:&nbsp;&nbsp;</label> <input type="text" name="login" placeholder="Saci2018" value="<%= m.getLogin() %>" required/> <br/>
			<label>Senha:&nbsp;&nbsp;</label> <input type="password" name="password" value="<%= m.getSenha() %>"/> <br/>
			<br/><input type="submit" value="Atualizar"/>
		</form>
<%}else {%>
		<p>Ops! Um erro ocorreu.</p>
<%}%>
	</body>
</html>