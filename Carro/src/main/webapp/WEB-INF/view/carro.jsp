<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carro</title>
</head>
<body>
	<br />
	<div align="center">
		<h1>CARRO</h1>
	</div>
	<br />
	<div align = "center">
		<form action="carro" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="text" placeholder="#Placa" id="placa" name="placa"
					value='<c:out value ="${carro.placa }"></c:out>'>
				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Marca" id="marca" name="marca"
					value='<c:out value ="${carro.marca }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Modelo" id="modelo" name="modelo"
					value='<c:out value ="${carro.modelo }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="Cor" id="cor" name="cor"
					value='<c:out value ="${carro.cor }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" step="1" min="0" placeholder="Ano" id="ano" name="ano"
					value='<c:out value ="${carro.ano }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="TipoCombustivel" id="tipoCombustivel" name="tipoCombustivel"
					value='<c:out value ="${carro.tipoCombustivel }"></c:out>'>
				</td>
				</tr>
				<tr>
					<td colspan="4">
					<input type="number" step="1" min="0" placeholder="kmRodado" id="kmRodado" name="kmRodado"
					value='<c:out value ="${carro.kmRodado }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="TipoCambio" id="tipoCambio" name="tipoCambio"
					value='<c:out value ="${carro.tipoCambio }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" placeholder="Categoria" id="categoriaCodigo" name="categoriaCodigo"
					value='<c:out value ="${carro.categoria.codigo }"></c:out>'>
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
		<c:if test="${not empty carros }">
			<table border="1">
				<thead>
					<tr>
						<th>#placa</th>
						<th>marca</th>
						<th>modelo</th>
						<th>cor</th>
						<th>ano</th>
						<th>tipoCombustivel</th>
						<th>kmRodado</th>
						<th>tipoCambio</th>
						<th>categoriaCodigo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="carro" items="${carros }">
					<tr>
						<td><c:out value="${carro.placa }" /></td>
						<td><c:out value="${carro.marca }" /></td>
						<td><c:out value="${carro.modelo }" /></td>
						<td><c:out value="${carro.cor }" /></td>
						<td><c:out value="${carro.ano }" /></td>
						<td><c:out value="${carro.tipoCombustivel }" /></td>
						<td><c:out value="${carro.kmRodado }" /></td>
						<td><c:out value="${carro.tipoCambio }" /></td>
						<td><c:out value="${carro.categoria.codigo }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>