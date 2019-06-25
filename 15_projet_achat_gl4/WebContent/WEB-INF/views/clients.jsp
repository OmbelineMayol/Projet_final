<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page Client</title>
</head>
<body>

	<!-- 
		données renvoyées par le controleur : 
		
			modele.addAttribute("allClients", listeClientsBdd);
	 -->

	<div align="center">
		<!-- titre -->
		<h1 style="background-color: lightgreen; color: darkgreen;">
			Liste Des Clients</h1>

		<!-- table  -->
		<table cellspacing="0" cellpadding="8" border="1" width="50%">

			<!-- lien pour ajouter un client (lien vers le formulaire) -->
			<tr>
				<td colspan="5" align="right">
					<!-- 
	 		    			envoi d'une requete http en GET (URL : /ajouterClient )
	 		    			=> invocation de la méthode setUpFormulaire() de ClientController  
	 		    		--> <a style="background-color: lightblue; text-align:center;"
					href="${pageContext.request.contextPath}/clientControllerBean/ajouterClient">
						Ajouter Un Client </a>
				</td>
			</tr>

			<tr style="background-color: gray; color: white;">
				<td>ID</td>
				<td>Nom</td>
				<td>Adresse</td>
				<td>Email</td>
				<td>Telephone</td>
				<td>Suppression</td>
				<td>Modification</td>
			</tr>

			<c:forEach items="${allClients}" var="cl">

				<tr style="background-color: lightyellow;">
					<td>${cl.idClient}</td>
					<td>${cl.nomClient}</td>
					<td>${cl.adresse}</td>
					<td>${cl.email}</td>
					<td>${cl.telephone}</td>

					<!-- colonne pour supprimer le client -->
					<!-- URL d'invocation : 
	 				      <-${pageContext.request.contextPath}->/clientControllerBean/delete/${idClient} 
	 				 -->
					<td><a
						href="${pageContext.request.contextPath}/clientControllerBean/delete/${cl.idClient}">Supprimer</a>
					</td>

<!-- 					colonne pour modifier le client -->
					<td><a
						href="${pageContext.request.contextPath}/clientControllerBean/modifierClient?clientId=${cl.idClient}">Modifier</a>
					</td>

				</tr>

			</c:forEach>

		</table>



	</div>

</body>
</html>