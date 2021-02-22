<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
body * {
margin-left:20px;}
tr, td {
outline: 1px solid grey;
padding: 4px 5px;
} 
thead {
font-size: 20px;
text-align: center;}
</style>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
</head>
<body>
	<h1>Products and Categories</h1>
	<p> 
		<a href="/products/new">New Product</a> | 
		<a href="/categories/new">New Category</a>
	</p>
	
	<h4>Products</h4>
	<table>
		<thead>
			<tr>
				<td> Name </td>
				<td> Description </td>
				<td> Price </td>
				<td> category COUNT </td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allProducts}" var="p">
			<tr>
				<td> <c:out value="${p.name}"/> </td>
				<td> <c:out value="${p.description}"/> </td>
				<td> <c:out value="${p.price}"/> </td>
				<td> <c:out value="${p.categories.size()} categories"/> </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p></p>
	
	<h4>Categories</h4>
	<table>
		<thead>
			<tr>
				<td> Categorty Name </td>
				<td> product COUNT </td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allCategories}" var="c">
			<tr>
				<td> <c:out value="${c.name}"/> </td>
				<td> <c:out value="${c.products.size()} categories"/> </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>