<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.8.1/css/all.css">

<spring:url value="/resources/css/bootstrap.css" var="bootstrapCss" />
<spring:url value="/resources/js/jquery-3.4.1.js" var="jqueryJs" />
<spring:url value="/resources/css/monstyle2.css" var="monstyle2" />
<spring:url value="/resources/js/npm.js" var="npmJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="bmJs" />
<spring:url value="/resources/js/bootstrap.js" var="bJs" />


<script src="${jqueryJs}"></script>
<script src="${npmJs}"></script>
<script src="${bmJs}"></script>
<script src="${bJs}"></script>
<link href="${monstyle2}" rel="stylesheet" />
<link href="${bootstrapCss}" rel="stylesheet" />

<title>accueil.jsp</title>

<style>
.btn-group .button {
	background-color: #5B8FBE; /* blue */
	border: 1px solid #405B8A;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	cursor: pointer;
	float: left;
}

.btn-group .button :not (:last-child){

border-right :none; /* Prevent double borders */

}
.btn-group .button:hover {
	background-color: #3E688E;
}

</style>
</head>


<body>
	<!-- Entête -->
	<div class="container-fluid"
		style="height: 100px; border-bottom: solid; border-bottom-color: grey; border-top: solid; border-top-color: grey; background-color: lightgrey; text-align: center; font-size: 20px; font-variant: small-caps; margin-top: 10px; margin-bottom: 20px;">
		<h1>
			<i>Store Shop - administrateur</i>
		</h1>

	</div>

	<div class="container" style="display: flex; margin-bottom: 40px;">

		<div class="btn-group" style="display: inline-block;">
			<!-- Bouton permettant d'afficher les produit en focntion de la catégorie -->
			<form action="<c:url value="/client/getAllClient"/>"
				style="margin-right: 5px;">
				<button type="submit" class="button">Gestion des clients</button>
			</form>
		</div>
		<div>
			<form action="<c:url value="/catergorie/getAllCategorie"/>">
				<button type="submit" class="button">Gestion des catégories</button>
			</form>
		</div>
		<div>
			<form action="<c:url value="/logout"/>">
				<button type="submit" class="button">Deconnection</button>
			</form>

		</div>

	</div>
	<!-- +++++++++++++++++++++++++  Gestion des produits ++++++++++++++++++++++++++ -->

	<div class="container">
	
		<!-- Bouton pour ajouter des produits -->
		<div style="margin-bottom: 20px;">
			<form action="<c:url value="/produit/form/ajouter"/>" style="margin-right: 5px;">

				<input type="submit" value="Ajouter un nouveau produit" />
			</form>
		</div>
		<h2 style="margin-bottom: 15px;">Liste des produits</h2>

		<!-- Table qui affiche l'ensemble des produits présents dans la table de données-->
		<table class="table table-striped">

			<tr>
				<th>Photo</th>
				<th>Catégorie</th>
				<th>Designation</th>
				<th>Prix</th>
				<th>Modifier</th>
				<th>Supprimer</th>
			</tr>

			<c:forEach items="${allProduit}" var="pdt">
				<tr>
					<td><img src="${pdt.photo}"
						style="width: 104px; height: 142px;"></td>
					<td>${pdt.categorie.nomCategorie}</td>
					<td>${pdt.designation}</td>
					<td>${pdt.prix}</td>


					<!-- 					colonne pour modifier le client -->
					<td><a href="${pageContext.request.contextPath}/produit/form/udpate?produitId=${pdt.idProduit}">Modifier</a>
					</td>
					<td><a href="${pageContext.request.contextPath}/produit/supprimer/${pdt.idProduit}">Supprimer</a>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>

	<!-- 		<script -->
	<!-- 		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" -->
	<!-- 		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" -->
	<!-- 		crossorigin="anonymous"></script> -->


</body>
</html>