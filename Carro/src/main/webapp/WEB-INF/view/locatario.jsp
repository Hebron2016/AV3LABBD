<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Locatario</title>
</head>
<body>
	<br />
	<div align="center">
		<h1>LOCATARIO</h1>
	</div>
	<br />
	<div align = "center">
		<form action="locatario" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="number" step="1" min="0" placeholder="#cpf" id="cpf" name="cpf"
					value='<c:out value ="${locatario.cpf }"></c:out>'>
				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Nome" id="nome" name="nome"
					value='<c:out value ="${locatario.nome }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" step="1" min="0" placeholder="numHabilitacao" id="numHabilitacao" name="numHabilitacao"
					value='<c:out value ="${locatario.numHabilitacao }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="dataNasc" id="dataNasc" name="dataNasc"
					value='<c:out value ="${locatario.dataNasc }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="endLogradouro" id="endLogradouro" name="endLogradouro"
					value='<c:out value ="${locatario.endLogradouro }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" step="1" min="0" placeholder="endNum" id="endNum" name="endNum"
					value='<c:out value ="${locatario.endNum }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="endCep" id="endCep" name="endCep"
					value='<c:out value ="${locatario.endCep }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="endCidade" id="endCidade" name="endCidade"
					value='<c:out value ="${locatario.endCidade }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id = "botao" name="botao" value="Inserir">
					</td>
					<td>
						<input type="submit" id = "botao" name="botao" value="Atualizar">
					</td>
					<td>
						<input type="submit" id = "botao" name="botao" value="Excluir">
					</td>
					<td>
						<input type="submit" id = "botao" name="botao" value="Listar">
					</td>
			</table>
		</form>
	</div>
	<div align = "center">
		<form action="locatariorelatorio" method="post" target = "_blank">
			<table>
				<tr>
				<td colspan="3">
					<input type="number" step="1" min="0" placeholder="#cpf" id="cpf" name="cpf">				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="Relatorio" value="Relatorio">
				</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	<div align="center">
		<c:if test="${not empty saida }">
			<c:out value="${saida }" />
		</c:if>
	</div>
		<div align="center">
		<c:if test="${not empty erro }">
			<c:out value="${erro }" />
		</c:if>
	</div>
		<div align="center">
		<c:if test="${not empty locatarios }">
			<table border="1">
				<thead>
					<tr>
						<th>#cpf</th>
						<th>Nome</th>
						<th>numHabilitacao</th>
						<th>dataNasc</th>
						<th>endLogradouro</th>
						<th>endNum</th>
						<th>endCep</th>
						<th>endCidade</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="locatario" items="${locatarios }">
					<tr>
						<td><c:out value="${locatario.cpf }" /></td>
						<td><c:out value="${locatario.nome }" /></td>
						<td><c:out value="${locatario.numhabilitacao }" /></td>
						<td><c:out value="${locatario.dataNasc }" /></td>
						<td><c:out value="${locatario.endLogradouro }" /></td>
						<td><c:out value="${locatario.endNum }" /></td>
						<td><c:out value="${locatario.endCep }" /></td>
						<td><c:out value="${locatario.endCidade }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>