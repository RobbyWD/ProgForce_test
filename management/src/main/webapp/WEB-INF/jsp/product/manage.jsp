<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	 <link href="resources/css/shift.css" rel="stylesheet">   
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/main.css">
	<jsp:include page="/WEB-INF/jsp/head-include.jsp" />
	 <jsp:include page="/WEB-INF/jsp/menu.jsp" />
<title>Product Management</title>
</head>
<body>
	
<div class="neighborhood-guides">
	    <div class="container">
	    <h2>Product Management</h2>
	    </div>
 </div>

	<div class="container">
	
	<table class="table">
		<tr>
			<th> ID </th ><th>Product name </th> <th> View </th> <th>Edit</th> <th> Delete </th>   
		 </tr>
		 <c:forEach var="item" items="${products}">
		 	<tr>
		 		<td>${item.id}</td><td>${item.name}</td>
		 		<td><a href="products/${item.id}">View</a></td>
		 		<td> <a href="products/${item.id}/edit">Edit</a></td>
		 		<td><a href="products/${item.id}/delete">Delete</a></td>
		 	</tr>
		 </c:forEach>
	</table>
	
	<a href="products?create">Create new product</a>
	
	</div>
</body>
</html>