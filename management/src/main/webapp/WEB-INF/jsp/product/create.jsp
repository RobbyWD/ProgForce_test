<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	 <link href="resources/css/shift.css" rel="stylesheet">   
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/main.css">
	<jsp:include page="/WEB-INF/jsp/head-include.jsp" />
	 <jsp:include page="/WEB-INF/jsp/menu.jsp" />
<title>Create Product</title>
</head>
<body>
	
<div class="neighborhood-guides">
	    <div class="container">
	    <h2>Create Product</h2>
	    </div>
 </div>

	<div class="container">

	<div class="form-group form">
	<form:form name="input"  method="post"
		modelAttribute="product" action="products">
		<div>
			<label>Name: </label>
			<form:input class="form-control" type="text" path="name" />
			<form:errors path="name" />
		</div>
		<div>
			<label>Description: </label>
			<form:textarea class="form-control" path="description" />
			<form:errors path="description" />
		</div>
		<div>
			<label>Price: </label>
			<form:textarea class="form-control" path="price" />
			<form:errors path="price" />
		</div>	
		
		<div>
		<label>Status: </label>
	      <form:select path="status">
	        <form:option value="">Select Status: </form:option>
	        		<c:forEach items="${statusEnum}" var="item">
	         <form:option value="${item}">${item}</form:option>
	        </c:forEach>
	      </form:select>	
		</div>

		<div>
			<label>Category:</label>
			<form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id">
			</form:select>
			<form:errors path="category" />
		</div>
		<div>
			<input class="form-control" type="submit" value="Submit">
		</div>
	</form:form>
	</div>
	</div>
</body>
</html>