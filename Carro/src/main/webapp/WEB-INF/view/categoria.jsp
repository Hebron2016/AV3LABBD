<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categoria</title>
</head>
<body>
	<br />
	<div align="center">
		<h1>CATEGORIA</h1>
	</div>
	<br />
	<div align = "center">
		<form action="categoria" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="number" step="1" min="0" placeholder="#Codigo" id="codigoCategoria" name="codigoCategoria"
					value='<c:out value ="${categoria.codigoCategoria }"></c:out>'>
				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" step="1" min="0" placeholder="ValorDiaria" id="valorDiaria" name="valorDiaria"
					value='<c:out value ="${categoria.valorDiaria }"></c:out>'>
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
		<c:if test="${not empty categorias }">
			<table border="1">
				<thead>
					<tr>
						<th>#codigoCategoria</th>
						<th>valorDiaria</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="categoria" items="${categorias }">
					<tr>
						<td><c:out value="${categoria.codigoCategoria }" /></td>
						<td><c:out value="${categoria.valorDiaria }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>