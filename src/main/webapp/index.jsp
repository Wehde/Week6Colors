<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Colors - Home</title>
</head>
<body>
	<form action="menuServlet" method="post">
		Hex Color Code: <input type="text" name="color"> <br/>
		<input type="submit" value="Add Color" name="doThisToItem"> <br/>
		<input type="submit" value="View Similar Colors" name="doThisToItem"> <br/>
	</form>
	<form action="viewColorsServlet">
		<input type="submit" value="View All Colors">
	</form>
	<form action="viewNamesServlet">
		<input type="submit" value="View All Names"> <br/>
	</form>
	<p>${result}</p>
</body>
</html>