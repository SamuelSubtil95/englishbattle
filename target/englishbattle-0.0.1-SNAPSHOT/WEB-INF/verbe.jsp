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
<title>Modifier un verbe : ${verbe.baseVerbale}</title>
</head>
<body>
	<section style="height: 100vh; background-color: ghostwhite"
		class="container-fluid d-flex justify-content-center align-items-center">
		<div style="height: 60vh"
			class="col-md-12 flex-column d-flex justify-content-around align-items-center">
	<h1>Modifier un verbe : ${verbe.baseVerbale}</h1>
	
			<form action="" method="post">
				<div class="row">
					<div class="col">
						<label for="baseverbale">Base verbale</label>
							<input type="text" name="BASEVERBALE" class="form-control" value="${verbe.baseVerbale}">
					</div>
					<div class="col">
						<label for="preterit">Preterit</label>
							<input type="text" name="PRETERIT" class="form-control" value="${verbe.preterit}">
					</div>
						<div class="col">
							<label for="ppasse">Participe passe</label>
							<input type="text" name="PPASSE" class="form-control" value="${verbe.participePasse}">
					</div>
						<div class="col">
							<label for="traduction">Traduction</label>
								<input type="text" name="TRADUCTION" class="form-control" value="${verbe.traduction}">
					</div>
					<br>
					<div style="padding-top:40px" class=" d-flex justify-content-center align-items-center">
						<button type="submit" class="btn btn-success">Valider</button>
					</div>
						
				</div>
			</form>
		</div>
	</section>

</body>
</html>