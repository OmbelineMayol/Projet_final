<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  
}
</style>

</head>
<body>

	<div class="container-fluid"
		style="height: 100px; border-bottom: solid; border-bottom-color: grey; border-top: solid; border-top-color: grey; background-color: lightgrey; text-align: center; font-size: 20px; font-variant: small-caps; margin-top: 10px; margin-bottom: 20px;">
		<h1>
			<i>Store Shop - administrateur</i>
		</h1>


	</div>

	<h3  style="text-align: center">Ajouter un produit</h3>

<div class="container" style="border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;">

		<form:form modelAttribute="produitAj"
			action="${pageContext.request.contextPath}/produit/ajouter"
			method="post">

			
			
				<form:label path="designation" type="text" placeholder="Designation">Designation :</form:label>
				<form:input path="designation" />		
		
				<form:label path="description" type="text" placeholder="Description">Description :</form:label>
				<form:input path="description" />
		
				<form:label path="prix" type="text" placeholder="Prix">prix :</form:label>
				<form:input path="prix" />
				
				<form:label path="categorie.nomCategorie">Catégorie :</form:label>
				<form:select path="categorie.nomCategorie">					
					<form:options items="${nomsCategories}" />
				</form:select>
								
				<form:label path="photo" type="text" placeholder="Lien de la photo">photo :</form:label>
				<form:input path="photo" placeholder="Lien de la photo" />
		
				<input type="submit" value="Ajouter" />
		
		</form:form>

</div>




</body>
</html>