<!DOCTYPE html>
<html>
<head>
<title>English Battle</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<section style="height: 100vh; background-color: ghostwhite"
		class="container-fluid d-flex justify-content-center align-items-center">
		<div style="height: 80vh"
			class="col-md-8 flex-column d-flex justify-content-around align-items-center">
			<div
				class="class=col-md-8 flex-column d-flex justify-content-center align-items-center">
				<h1>Welcome to English Battle !</h1>
				<br>
				<h4 style="color: darkorange; font-style: italic">${message}</h4>
				<h4 style="color: green">${connected}</h4>
				<br>
				<section class=" col-md-8 col-8 col-xl-8">
					<form method="POST" action="connection">
						<div class="form-group">
							<label for="exampleInputEmail1">Email</label> <input type="email"
								name="EMAIL" class="form-control" id="EMAIL"
								aria-describedby="emailHelp">
						</div>
						<br>
						<div class="form-group">
							<label for="exampleInputPassword1">Mot de passe</label> <input
								type="password" class="form-control" id="MDP" name="MDP">
						</div>
						<br>
						<button style="text-align:center" type="submit" class="btn btn-primary">Connection</button>
					</form>
					<br>
			</div>
			<div style="width:100%"
				class="d-flex flex-column justify-content-center align-items-center ">
				<p style="text-align:center"><b>Vous n'avez pas encore de compte ?</b></p>
				<div style="width:28%" class="d-flex justify-content-between align-items-center">
					<a class="btn btn-outline-success" href="inscription">S'inscrire</a>
					<a class="btn btn-outline-success" href="inscriptiontele">S'inscrire avec image</a>
				</div>
				
			</div>
			<br>
	
			<div>
				<a class="btn btn-outline-secondary btn-sm" href="verbes">Voir la liste des ${nb} verbes</a>
			</div>
			<div>
				<a class="btn btn-outline-secondary btn-sm" href="joueurs">Voir la liste des ${nbJoueurs} joueurs</a>
			</div>
		</div>

	</section>
	<section style="height: 100vh; background-color: MintCream">
		<h2 style="text-align: center; padding-top: 25px">Hall of Fame</h2>
		<div
			class="container-fluid d-flex justify-content-center align-items-center">
			<div
				class="col-md-8 flex-column d-flex justify-content-center align-items-center">

			</div>
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
