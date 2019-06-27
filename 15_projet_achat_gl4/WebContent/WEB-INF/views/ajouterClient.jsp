<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter Client</title>
</head>
<body>

	<div align="center">
		<h1 style="background-color: lightblue; color: orange;">Ajout D'un Nouveau Client</h1>

		<table cellspacing="0" cellpadding="6" border="1" width="60%">

			<!-- 
				modelAttribute = perlet de lier le formulaire à l'objet de commande definit dans le controleur 
				action = url à appeler à la soumission du formulaire 
			 -->

			<form:form modelAttribute="clientCommand"
				action="${pageContext.request.contextPath}/client/ajouter"
				method="post">
				<tr>
					<!-- label -->
					<td><form:label path="nomClient">Nom : </form:label></td>
					<!-- input -->
					<td><form:input path="nomClient" /></td>
				</tr>
				<tr>
					<!-- label -->
					<td><form:label path="adresse">Adresse : </form:label></td>
					<!-- input -->
					<td><form:input path="adresse" /></td>
				</tr>
				<tr>
					<!-- label -->
					<td><form:label path="email">Email : </form:label></td>
					<!-- input -->
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<!-- label -->
					<td><form:label path="telephone">Téléphone : </form:label></td>
					<!-- input -->
					<td><form:input path="telephone" /></td>
				</tr>
				<tr>
					<!-- bouton -->
					<td colspan="2"><input type="submit" value="Ajouter" /></td>
				</tr>

			</form:form>

		</table>

	</div>

</body>
</html>