<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

</head>
<body>
	<!-- Entête -->


	<div class="container-fluid"
		style="height: 100px; border-bottom: solid; border-bottom-color: grey; border-top: solid; border-top-color: grey; background-color: lightgrey; text-align: center; font-size: 20px; font-variant: small-caps; margin-top: 10px;">


		<h1>
			<i>Store Shop </i>
		</h1>
	</div>

	<!-- Barre de menu -->
	<div class="container-fluid"
		style="margin-top: 20px; margin-bottom: 30px;">

		<div style="text-align: left;">
			<a href='<c:url value="/accueilAdm"/>'>Se connecter en tant
				qu'administrateur</a>
		</div>

	</div>



	<!-- Bouton permettant d'afficher les produit en focntion de la catégorie -->

	<div style="margin-bottom: 20px; display: flex; flex-wrap: nowrap;"
		class="container">
		<div>
			<form:form
				action="${pageContext.request.contextPath}/produit/byCategorie"
				method="post" modelAttribute="categorie">

				<!-- Liste déroulante -->
				<form:label path="nomCategorie">Rechercher par catégorie :</form:label>

				<form:select path="nomCategorie">
					<%-- 					<form:option value="srth" /> --%>
					<form:options items="${nomsCategories}" />
				</form:select>


				<!-- Bouton de sélection -->
				<input type="submit" value="Recherher" />

			</form:form>

		</div>

		<!-- Bouton permettant la recherche de tous  -->

		<div>
			<form action="<c:url value="/welcome"/>" style="margin-right: 5px;">

				<input type="submit" value="Tous les produits" />
			</form>
		</div>
	</div>

	<!-- Table qui affiche l'ensemble des produits présents dans la table de données-->

	<div class="container">
		<h2 style="margin-bottom: 20px; text-align: center;">Liste des
			Produits</h2>
		<table class="table table-striped">

			<tr>

				<th>Photo</th>
				<th>Catégorie</th>
				<th>Designation</th>
				<th>Description</th>
				<th>Prix</th>


			</tr>


			<c:forEach items="${allProduit}" var="pdt">
				<tr>
					<td><img src="${pdt.photo}" style="width: 150px; height: auto;" /></td>
					<td > ${pdt.categorie.nomCategorie}</td>
					<td>${pdt.designation}</td>
					<td>${pdt.description}</td>
					<td>${pdt.prix}</td>

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