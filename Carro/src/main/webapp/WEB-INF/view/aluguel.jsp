<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aluguel</title>
</head>
<body>
	<br />
	<div align="center">
		<h1>ALUGUEL</h1>
	</div>
	<br />
	<div align = "center">
		<form action="aluguel" method="post">
			<table>
				<tr>
				<td colspan="3">
					<input type="number" step="1" min="0" placeholder="#Codigo" id="codigoAluguel" name="codigoAluguel"
					value='<c:out value ="${aluguel.codigoAluguel }"></c:out>'>
				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="date" placeholder="dataRetirada" id="dataRetirada" name="dataRetirada"
					value='<c:out value ="${aluguel.dataRetirada }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" placeholder="qtdDias" id="qtdDias" name="qtdDias"
					value='<c:out value ="${aluguel.qtdDias }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="number" placeholder="cpfLocatario" id="cpfLocatario" name="cpfLocatario"
					value='<c:out value ="${aluguel.locatario.cpf }"></c:out>'>
				</td>
				</tr>
				<tr>
				<td colspan="4">
					<input type="text" placeholder="placaCarro" id="placaCarro" name="cpfLoplacaCarrocatario"
					value='<c:out value ="${aluguel.carro.placa }"></c:out>'>
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
		<form action="aluguelrelatorio" method="post" target= "_blank">
			<table>
				<tr>
				<td colspan="3">
					<input type="number" step="1" min="0" placeholder="#Codigo" id="dataRetirada" name="dataRetirada">				</td>
				<td colspan="1">
					<input type="submit" id = "botao" name="botao" value="Buscar">
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
		<c:if test="${not empty alugueis }">
			<table border="1">
				<thead>
					<tr>
						<th>#codigoAluguel</th>
						<th>dataRetirada</th>
						<th>qtdDias</th>
						<th>cpfLocatario</th>
						<th>placaCarro</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="aluguel" items="${alugueis }">
					<tr>
						<td><c:out value="${aluguel.codigoAluguel }" /></td>
						<td><c:out value="${aluguel.dataRetirada }" /></td>
						<td><c:out value="${aluguel.qtdDias }" /></td>
						<td><c:out value="${aluguel.locatario.cpf }" /></td>
						<td><c:out value="${aluguel.carro.placa }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>