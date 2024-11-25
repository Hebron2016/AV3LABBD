<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Devolucao</title>
</head>
<body>
	<br />
	<div align="center">
		<h1>DEVOLUCAO</h1>
	</div>
	<br />
	<div align = "center">
		<form action="devolucao" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="number" step="1" min="0" placeholder="#Codigo" id="codigoDevolucao" name="codigoDevolucao"
					value='<c:out value ="${devolucao.codigoDevolucao }"></c:out>'>
				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="date" placeholder="diaDevolucao" id="diaDevolucao" name="diaDevolucao"
					value='<c:out value ="${devolucao.diaDevolucao }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" step="1" min="0" placeholder="valorTotal" id="valorTotal" name="valorTotal"
					value='<c:out value ="${devolucao.valorTotal }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" step="1" min="0" placeholder="valorExtra" id="valorExtra" name="valorExtra"
					value='<c:out value ="${devolucao.valorExtra }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="codigoAluguel" id="codigoAluguel" name="codigoAluguel"
					value='<c:out value ="${devolucao.aluguel.codigoAluguel }"></c:out>'>
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
		<c:if test="${not empty devolucoes }">
			<table border="1">
				<thead>
					<tr>
						<th>#codigoDevolucao</th>
						<th>diaDevolucao</th>
						<th>valorTotal</th>
						<th>valorExtra</th>
						<th>codigoAluguel</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="devolucao" items="${devolucoes }">
					<tr>
						<td><c:out value="${devolucao.codigoDevolucao }" /></td>
						<td><c:out value="${devolucao.diaDevolucao }" /></td>
						<td><c:out value="${devolucao.valorTotal }" /></td>
						<td><c:out value="${devolucao.valorExtra }" /></td>
						<td><c:out value="${devolucao.aluguel.codigoAluguel }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>