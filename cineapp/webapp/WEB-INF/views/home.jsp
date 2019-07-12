<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a CineApp</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<%--
	<h1>Lista de Peliculas</h1>
	
	<ol>
		<c:forEach items="${peliculas}" var="pelicula">
			<li>${pelicula}</li>
		</c:forEach>
	</ol>
	 --%>

	<div class="card">
		<div class="card-header alert alert-primary" >Tabla de peliculas</div>
		<div class="card-body">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<!--header in html table-->
					<tr>
						<th>Id</th>
						<th>Título</th>
						<th>Duración</th>
						<th>Clasificación</th>
						<th>Género</th>
						<th>Imagen</th>
						<th>Fecha de Estreno</th>
						<th>Estado</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${peliculas}" var="pelicula">
						<tr>
							<td>${pelicula.id}</td>
							<td>${pelicula.titulo}</td>
							<td>${pelicula.duracion}min.</td>
							<td>${pelicula.clasificacion}</td>
							<td>${pelicula.genero}</td>
							<td>${pelicula.imagen}</td>
							<td>${pelicula.fechaEstreno}</td>
							<td>${pelicula.estado}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>