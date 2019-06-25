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

<link href="${bootstrapCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>


<title>accueil.jsp</title>

</head>
<body>
	<!-- Entête -->

	<header>
	<div id=header
		style="height: 100px; border-bottom: solid; border-bottom-color: grey; border-top: solid; border-top-color: grey; background-color: lightgrey; text-align: center; font-size: 20px; font-variant: small-caps;">

		<h1>
			<i>Store Shop </i>
		</h1>
	</div>

	</header>

	<!-- Bouton permettant d'afficher les produit en focntion de la catégorie -->
	<div style="margin-top: 50px;"></div>

	<!-- Table qui affiche l'ensemble des produits présents dans la table de données-->

	<div style="margin-left: 100px; margin-right: 100px;">
		<table class="table table-striped">

			<tr>

				<td>Photo</td>
				<td>Catégorie</td>
				<td>Designation</td>
				<td>Prix</td>

			</tr>


			<c:forEach items="${allProduit}" var="pdt">
				<tr>
					<td>${pdt.photo}</td>
					<td>${pdt.categorie.nomCategorie}</td>
					<td>${pdt.designation}</td>
					<td>${pdt.prix}</td>

				</tr>

			</c:forEach>

		</table>
	</div>

<!-- 	<script -->
<!-- 	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" -->
<!-- 	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" -->
<!-- 	crossorigin="anonymous"></script> -->


</body>
</html>