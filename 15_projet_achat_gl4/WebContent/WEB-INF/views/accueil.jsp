<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<title>accueil.jsp</title>

</head>
<body>

<header>
<div>
<h1> Site d'achat en ligne </h1>

</div>

<div>
Administrateur

</div>

</header>
<div style="margin-left: 100px; margin-right: 100px;" >
	<table cellspacing="0" cellpadding="6" border="1" width="50%">
		
			<tr style="background-color: lightgrey; font-weight: bold; font-size: 15px;">
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

</body>
</html>