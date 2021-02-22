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
<title>CAtegory Page</title>
</head>
<body>
	<c:if test="${category.name != null }">
		
		category name:<h1><c:out value="${category.name}"/></h1>
	
		<p>Categories a product is in:</p>
		<ul>
		<!-- this products has categories -->
			<c:forEach items="${thisCategoriesHasProducts}" var="c">	
				<li> <c:out value="${c.name }"/>
				</li>
			</c:forEach>
		</ul>

		<!-- this products has NOT categories -->
		<form action="/categories/${ category.id }" method="post">
			
			<label for="productId">Add Product</label>
			<select name="productId">
				<option disabled selected value="">select product!</option>
				<c:forEach items="${ productsList }" var="p">
					<option value="${ p.id }">${ p.name }</option>
				</c:forEach>
			</select>
			
			<input type="submit" value="Add" />
		</form>

	
	</c:if>
	
	<a href="/">back to main</a>	
</body>
</html>