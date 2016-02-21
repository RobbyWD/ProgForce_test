<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <head>
    <link href="resources/css/shift.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/main.css">
    <jsp:include page="/WEB-INF/jsp/menu.jsp" />
    
  </head>

  <body>
    
   
    <div class="container">
    	<img src="resources/img/admin.jpg" width="100%"></img>
    </div>
    
    <div class="neighborhood-guides">
    <div class="container">
        <h4>ProgForce Test</h4>
      <div class="nav">
      	<div class="container">
        	<ul class="pull-left">
        		<li><a href="products?manage">Product Management</a></li>
        	</ul>
    	
        	<ul class="pull-right">
        		<li><a href="reports?upload">Virtual Shops and Multithreading</a></li>
        	</ul>
        	 <ul class="pull-left">
        	    <li><a href="categories?manage">Category Management</a></li>
        	  </ul>
      	</div>
    </div>

   </div>
 </div>
 
  </body>
</html>
