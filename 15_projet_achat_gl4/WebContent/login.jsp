<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>login.jsp (formulaire de connexion personalisée)</title>
</head>
<body>

	<!-- A la soumission du formulaire, on doit appeler une URL effectuant l'authentification
			>> attribut action de form
	 -->

	<!-- Cas d'echec d'authentifiaction : affichage des erreurs de connexions -->
	<c:if test="${not empty param.error }">
		<!-- echec d'authentification -->
		<font color="red;">
			Login error . <br/>
			
			<!-- Ici on récupère dans la session l'objet correspondant au message d'erreur -->
			Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</font>
	</c:if>
	
	<!-- Cas de déconnexion : Affichage d'un message à l'utilisateur -->
	<c:if test="${not empty param.logout_message }">
		<font color="red;">
			Vous êtes bien déconnecté.
		</font>
	
	</c:if>

	<!-- Construction de l'URL d'authentifiaction  -->
	<c:url value="login" var="loginUrl" />

	<!-- Le formualire -->
	<form action="${loginUrl}" method="post">

		<table>
			<tr>
				<td>Identifiant :</td>
				<!-- name : paramètre de requete car la methode est envoyé en post -->
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Mot de passe :</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>Identifiant :</td>
				<td><input type="submit" name="Connexion"></td>
			</tr>

		</table>
	</form>


	<!-- Cas de déconnexion : Affichage d'un message à l'utilisateur -->
	<c:if test="${not empty param.logout_message }">
		<font color="red;">
			<a href="${pageContext.request.contextPath}/messageList">Home page</a>
		</font>
	
	</c:if>

</body>
</html>