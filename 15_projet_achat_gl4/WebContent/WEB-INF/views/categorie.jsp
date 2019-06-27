<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Categorie</title>
</head>
<body>

	<div align="center">
		<!-- titre -->
		<h1 style="background-color: lightgreen; color: darkgreen;">
			Liste Des Categories</h1>

		<!-- table  -->
		<table cellspacing="0" cellpadding="6" border="1" width="50%">

			<!-- lien pour ajouter une categorie  -->
			<tr>
				<td colspan="5" align="right">
					 <a style="background-color: lightblue; text-align:center;"
					href="${pageContext.request.contextPath}/categorieControllerBean/ajouterCategorie">
							Ajouter une Catégorie </a>
				</td>
			</tr>

			<tr style="background-color: gray; color: white;">
				<td>id_Categorie</td>
				<td>nomCategorie</td>
				<td>description</td>
				<td>Suppression</td>
				<td>Modification</td>
			</tr>
			<c:forEach items="${allCategorie}" var="cat">

				<tr style="background-color: lightyellow;">
					<td>${cat.idCategorie}</td>
					<td>${cat.nomCategorie}</td>
					<td>${cat.description}</td>
					
					<!-- colonne pour supprimer la categorie -->
					<td><a href="${pageContext.request.contextPath}/categorieControllerBean/delete/${cat.idCategorie}">Supprimer</a>
					</td>
					
					<!-- colonne pour modifier le categorie -->
					<td><a
						href="${pageContext.request.contextPath}/categorieControllerBean/modifierCategorie?categorieId=${cat.idCategorie}">Modifier</a>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<br/>
	<hr/>
	<br/>
	<div align="center">
		<!-- titre -->
		<h1 style="background-color: lightgreen; color: darkgreen;">
			Noms des Categories</h1>

		<!-- table  -->
		<table cellspacing="0" cellpadding="2" border="1" width="50%">
			<tr style="background-color: lightblue; color: black;">
				
				<td>Nom de la Categorie</td>
			</tr>
		<c:forEach items="${allCategorie}" var="cat">

				<tr style="background-color: lightbrown;text-align: center;">
					
					<td>${cat.nomCategorie}</td>
				</tr>		
		</c:forEach>

		</table>
	</div>
		
</body>
</html>