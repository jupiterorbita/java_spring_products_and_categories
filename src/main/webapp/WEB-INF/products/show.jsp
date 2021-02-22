<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
	<c:if test="${product.name != null }">
		
		product name:<h1><c:out value="${product.name}"/></h1>
	
		<p>Product's Categories:</p>
		<ul>
		<!-- this products has categories -->
			<c:forEach items="${thisProductCategories}" var="prodC">	
				<li> <c:out value="${prodC.name }"/>
				</li>
			</c:forEach>
		</ul>

		<!-- this products has NOT categories -->
		<form action="/products/${ product.id }" method="post">
			
			<label for="categoryId">Add Category</label>
			<select name="categoryId">
				<option disabled selected value="">Select category!</option>
				<c:forEach items="${ categoriesList }" var="cat">
					<option value="${ cat.id }">${ cat.name }</option>
				</c:forEach>
			</select>
			
			<input type="submit" value="Add" />
		</form>

	
	</c:if>
	
	<a href="/">back to main</a>	
</body>
</html>