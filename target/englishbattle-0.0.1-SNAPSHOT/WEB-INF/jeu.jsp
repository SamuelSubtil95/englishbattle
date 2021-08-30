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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="ISO-8859-1">
<title>Questions - English Battle</title>
</head>
<body>
	<a href="deconnection" style="position:absolute; margin-top: 40px; margin-left:40px" class="btn btn-outline-danger">Déconnection</a>
	<section style="background-color: ghostwhite ; height: 90vh" class="container-fluid d-flex justify-content-center align-items-center">
		<div style="height: 40vh" class="col-md-8 flex-column d-flex justify-content-around align-items-center">
			<h1>Bienvenue ${sessionScope.partie.joueur.prenom} ${sessionScope.partie.joueur.nom} !</h1>
			<h3>Meilleur score : - (${sessionScope.partie.joueur.nom})</h3>			
			<h4 style="color: darkorange">Il vous reste 60 seconde(s) pour
				répondre !</h4>
			<div style="width:100%">
				<form style="width:100%" action="jeu">
				<div style="width:100%" class="d-flex justify-content-around align-items-center">
				
					<h4>Verbe 1 : ${sessionScope.question.verbe.baseVerbale}
					<c:if test="${sessionScope.partie.joueur.niveau.nom eq 'Débutant'}"> (${sessionScope.question.verbe.traduction})</c:if></h4>
					
					
					
					<div class="form-group">
						<c:choose>						
       						<c:when test="${sessionScope.random>0.5 && sessionScope.partie.joueur.niveau.nom ne 'Confirmé'}"> 
       							<input type="text" name="PRETERIT" class="form-control form-control-lg" id="preterit" value="${sessionScope.question.verbe.preterit}"> 
       						</c:when>
       							
        				    <c:otherwise>
        				    	<input type="text" name="PRETERIT" class="form-control form-control-lg" id="preterit" placeholder="Prétérit" value="">
        				    </c:otherwise>        				    
    					</c:choose>		
					</div>
					
					<div class="form-group">
						<c:choose>						
       						<c:when test="${sessionScope.random<0.5 && sessionScope.partie.joueur.niveau.nom ne 'Confirmé'}"> 
       							<input type="text" name="PPASSE" class="form-control form-control-lg" id="preterit" value="${sessionScope.question.verbe.participePasse}"> 
       						</c:when>
       							
        				    <c:otherwise>
        				    	<input type="text" name="PPASSE" class="form-control form-control-lg" id="preterit" placeholder="Participe passé" value="">
        				    </c:otherwise>        				    
    					</c:choose>		
					</div>
					 
					<button type="submit" class="btn btn-success">Valider</button>
				</div>
				</form>
			</div>
		</div>
		
	</section>
</body>
</html>