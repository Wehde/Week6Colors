<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Colors - Names</title>
</head>
<body>
	<form method="post" action="nameServlet">
	<table>
		<c:forEach items="${requestScope.listNames}" var="currentName">
			<tr>
				<td><input type="radio" name="name" value="${currentName.id}"></td>
				<td>${currentName.hexColor.hexColor}</td>
				<td>${currentName.hexColor.hexGray}</td>
				<td>${currentName.name}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="Delete" name="doThisToItem">
	<input type="submit" value="Add a Color" name="doThisToItem">
	<input type="submit" value="Add a Name" name="doThisToItem">
	</form>
	<form action="viewColorsServlet">
		<input type="submit" value="View All Colors">
	</form>
	<form action="viewNamesServlet">
		<input type="submit" value="View All Names"> <br/>
	</form>
	<p>${result }</p>
</body>
