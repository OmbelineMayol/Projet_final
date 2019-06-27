<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier Categorie</title>
</head>
<body>
	<div align="center">
		<h1 style="background-color: lightblue; color: orange">Modifier une Catégorie</h1>

		<table cellspacing="0" cellpadding="6" border="1" width="60%">

			<form:form modelAttribute="categorieUpCommand"
				action="${pageContext.request.contextPath}/categorieControllerBean/modifierCategorie"
				method="post">

				<tr>
					<td></td>
					<td><form:hidden path="idCategorie" /></td>
				</tr>

				<tr>
					<!-- label -->
					<td><form:label path="nomCategorie">Catégorie : </form:label></td>
					<!-- input -->
					<td><form:input path="nomCategorie" /></td>
				</tr>
				<tr>
					<!-- label -->
					<td><form:label path="description">Description :</form:label></td>
					<!-- input -->
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<!-- bouton -->
					<td colspan="2"><input type="submit" value="Modifier" /></td>
				</tr>

			</form:form>

		</table>

	</div>
</body>
</html>