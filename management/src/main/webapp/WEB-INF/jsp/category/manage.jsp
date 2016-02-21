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
<title>Category Management</title>
</head>
<body>
	
<div class="neighborhood-guides">
	    <div class="container">
	    <h2>Category Management</h2>
	    </div>
 </div>

	<div class="container">
	
	<table class="table">
		<tr>
			<th>ID</th> <th>Category name</th> <th>View</th>  <th>Edit</th> <th>Delete</th>   
		 </tr>
		 <c:forEach var="item2" items="${categories}">
		 	<tr>
		 		<td>${item2.id}</td>
		 		<td>${item2.name}</td>
				<td> <a href="categories/${item2.id}">View</a> </td>
				<td><a href="categories/${item2.id}/edit">Edit</a> </td>
				 <td><a href="categories/${item2.id}/delete">Delete</a></td>
		 	</tr>
		 </c:forEach>
	</table>
	
	<a href="categories?create">Create new category</a>
	
	</div>
</body>
</html>