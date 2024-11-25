<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reparo</title>
</head>
<body>
	<br />
	<div align="center">
		<h1>REPARO</h1>
	</div>
	<br />
	<div align = "center">
		<form action="reparo" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="number" step="1" min="0" placeholder="#Codigo" id="codigoReparo" name="codigoReparo"
					value='<c:out value ="${reparo.codigoReparo }"></c:out>'>
				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="date"  placeholder="DiaEntrada" id="diaEntrada" name="diaEntrada"
					value='<c:out value ="${reparo.diaEntrada }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number"  placeholder="qtdDiasReparo" id="qtdDiasReparo" name="qtdDiasReparo"
					value='<c:out value ="${reparo.qtdDiasReparo }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text"  placeholder="descricao" id="descricao" name="descricao"
					value='<c:out value ="${reparo.descricao }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" step="1" min="0" placeholder="valorReparo" id="valorReparo" name="valorReparo"
					value='<c:out value ="${reparo.valorReparo }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="carroPlaca" id="carroPlaca" name="carroPlaca"
					value='<c:out value ="${reparo.carro.placa }"></c:out>'>
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
		<form action="reparorelatorio" method="post" target = "_blank">
			<table>
				<tr>
				<td colspan="3">
					<input type="date"  placeholder="DiaEntrada" id="diaEntrada" name="diaEntrada">				</td>
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
		<c:if test="${not empty reparos }">
			<table border="1">
				<thead>
					<tr>
						<th>#codigoReparo</th>
						<th>diaEntrada</th>
						<th>qtdDiasReparo</th>
						<th>descricao</th>
						<th>valorDiaria</th>
						<th>Placa do carro</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reparo" items="${reparos }">
					<tr>
						<td><c:out value="${reparo.codigoReparo }" /></td>
						<td><c:out value="${reparo.diaEntrada }" /></td>
						<td><c:out value="${reparo.qtdDiasReparo }" /></td>
						<td><c:out value="${reparo.descricao }" /></td>
						<td><c:out value="${reparo.valorReparo }" /></td>
						<td><c:out value="${reparo.carroPlaca }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>