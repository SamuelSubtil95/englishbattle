<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Inscription à English Battle</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<section style="background-color: ghostwhite; height: 100vh"
		class="container-fluid d-flex justify-content-center align-items-center">
		<div
			class="col-md-8 flex-column d-flex justify-content-center align-items-center">
			<h1>Inscription à English Battle :</h1>
			<section class=" col-md-8 col-8 col-xl-8">
				<form method="POST" action="inscription">
					<div class="form-group">
						<label>Nom</label> <input type="text" name="NOM"
							class="form-control" id="NOM" required>
					</div>
					<div class="form-group">
						<label>Prenom</label> <input type="text" name="PRENOM"
							class="form-control" id="PRENOM" required>
					</div>
					</br>
					<div class="form-group">
						<label for="VILLE">Ville</label> <select
							class="
							form-select" aria-label="Default select example"
							name="VILLE" required>
							<option selected>Choisissez votre ville</option>
							<c:forEach var="ville" items="${villes}">
								<option value="${ville.id}">${ville.nom}</option>
							</c:forEach>
						</select>
					</div>
					</br>
					<div class="form-group">
						<label for="NIVEAU">Niveau de jeu</label> <select
							class="form-select" aria-label="Default select example"
							name="NIVEAU" required>
							<option selected>Choisissez votre niveau de difficulté</option>
							<c:forEach var="niveau" items="${niveaux}">
								<option value="${niveau.id}">${niveau.nom}</option>
							</c:forEach>
						</select>
					</div>
					</br>
					<div class="form-group">
						<label for="EMAIL">Email</label> <input type="email" name="EMAIL"
							class="form-control" id="EMAIL" aria-describedby="emailHelp"
							required>
					</div>
					<div class="form-group">
						<label>Mot de passe</label> <input type="password"
							class="form-control" id="MDP" name="MDP" required>
					</div>
					</br>
					<button type="submit" class="btn btn-primary">S'inscrire</button>
				</form>
				</br>
			</section>
		</div>

	</section>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>
