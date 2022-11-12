<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Colors - Edit</title>
</head>
<body>
	<form action="editColorServlet" method="post">
	Old Color Code: <input type="text" name="oldColor" value="${colorToEdit.getHexColor()}" readonly><br />
	New Color Code: <input type="text" name="newColor"><br />
	<input type="submit" value="Save Color">
	</form>
</body>
</html>