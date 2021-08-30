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
<title>Liste des joueurs</title>
</head>
<body style="background-color: ghostwhite">
	<a class="btn btn-outline-danger" style="margin-top:70px; margin-left:109px" href="index">Retour</a>
	<h1 style="text-align: center; padding-top:30px; padding-bottom:30px">Liste des joueurs</h1>
		<div class="container">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Prénom</th>
			      <th scope="col">Nom</th>
			      <th scope="col">Ville</th>
			      <th scope="col">Niveau</th>
			      <th scope="col">Meilleur score</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="joueur" items="${joueurs}">
				    <tr>
				      <td>${joueur.prenom}</td>
				      <td>${joueur.nom}</td>
				      <td>${joueur.ville.nom}</td>
				      <td>${joueur.niveau.nom}</td>
				      <td>${joueur.meilleurScore}</td>
				    </tr>
			    </c:forEach>
			   </tbody>
			</table>
		</div>
</body>
</html>