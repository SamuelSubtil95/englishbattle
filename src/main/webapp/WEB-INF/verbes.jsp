<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Liste des verbes</title>
</head>
<body style="background-color: ghostwhite">
	<a class="btn btn-outline-danger" style="margin-top:70px; margin-left:109px" href="index">Retour</a>
	<h1 style="text-align: center; padding-top:30px; padding-bottom:30px">Liste des verbes</h1>
		<div class="container">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Base verbale</th>
			      <th scope="col">Preterit</th>
			      <th scope="col">Participe passé</th>
			      <th scope="col">Traduction</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="verbe" items="${listeDeVerbes}">
				    <tr>
				      <th scope="row">${verbe.baseVerbale}</td>
				      <td>${verbe.preterit}</td>
				      <td>${verbe.participePasse}</td>
				      <td>${verbe.traduction}</td>
				      <td><a class="btn btn-outline-primary" href="verbe?ID=${verbe.id}">Modifier</a></td>
				    </tr>
			    </c:forEach>
			   </tbody>
			</table>
		</div>
</body>
</html>