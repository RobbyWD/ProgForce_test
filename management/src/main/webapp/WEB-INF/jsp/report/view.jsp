<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Upload status</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/shift.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
	<jsp:include page="/WEB-INF/jsp/head-include.jsp" />
	<jsp:include page="/WEB-INF/jsp/menu.jsp" />
</head>
<body>

<div class="neighborhood-guides">
	    <div class="container">
	    <h2>Upload status</h2>
	    </div>
 </div>

<div class="container">
	
	<table class="table">
		<tr>
			<th>Name</th><th>Description</th> <th>Category</th> <th>Price</th> <th>Status</th>
		 </tr>
		 <c:forEach var="item" items="${products}">
		 	<tr>
		 			
		 		<td>${item.name}</td> <td>${item.description}</td> <td>${item.category}</td> <td>${item.price}</td> <td>${item.status}</td>
		 	</tr>
		 </c:forEach>
	</table>
	
		
</div>



</body>
</html>