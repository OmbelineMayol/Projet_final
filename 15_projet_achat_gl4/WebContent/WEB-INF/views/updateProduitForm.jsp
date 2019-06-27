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


</head>
<body>

	<div class="container-fluid"
		style="height: 100px; border-bottom: solid; border-bottom-color: grey; border-top: solid; border-top-color: grey; background-color: lightgrey; text-align: center; font-size: 20px; font-variant: small-caps; margin-top: 10px; margin-bottom: 20px;">
		<h1>
			<i>Store Shop - administrateur</i>
		</h1>


	</div>

	<h3>Modifier un produit</h3>

<div class="container">

		<form:form modelAttribute="produitUpdate"
			action="${pageContext.request.contextPath}/produit/update"
			method="post">

			<form:hidden path="idProduit" />
			
				<form:label path="designation">designation:</form:label>
				<form:input path="designation" />		
		
				<form:label path="description">description :</form:label>
				<form:input path="description" />
		
				<form:label path="prix">prix :</form:label>
				<form:input path="prix" />
				
				<form:label path="quantite">quantite :</form:label>
				<form:input path="quantite" />
				
				<form:label path="photo">photo :</form:label>
				<form:input path="photo" />
		
				<form:label path="selectionne">selectionne :</form:label>
				<form:input path="selectionne" />
		
				<input type="submit" value="Modifier" />
		
		</form:form>

</div>




</body>
</html>