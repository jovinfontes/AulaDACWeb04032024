<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Lista de contatos</title>
</head>
<body>
	<!-- cria o DAO -->
	<jsp:useBean id="dao" class="com.estudo.aula04032024.dao.FuncionarioDao" />
	<table>
		<!-- percorre funcionários montando as linhas da tabela -->
		<c:forEach var="funcionario" items="${dao.all()}">
			<tr>
				<td>${funcionario.nomeCompleto}</td>
				<td>${funcionario.matricula}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>