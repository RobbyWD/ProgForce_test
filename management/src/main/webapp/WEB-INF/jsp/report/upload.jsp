<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="resources/css/shift.css" rel="stylesheet">   
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/main.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="/WEB-INF/jsp/head-include.jsp" />
	<jsp:include page="/WEB-INF/jsp/menu.jsp" />
	<title>Upload</title>
</head>
<body>
	

<div class="neighborhood-guides">
	    <div class="container">
	    <h2>Shops created</h2>
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


	
	<div class="nav">
      	<div class="container">
        	<ul class="pull-left">
        		<li><a href="reports?view">Apply changes to the goods and services!</a></li>
        	</ul>
      	</div>
    </div>

</body>
</html>