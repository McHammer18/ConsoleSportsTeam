<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Team List</title>
</head>
<body>
<h2> My Team List</h2>
<form method = "post" action = "navigationServlet">
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
	<td><input type="radio"name="id"value="${currentitem.id}"></td>
	<td>${currentitem.city}</td>
	<td>${currentitem.nickName}</td>
	<td>${currentitem.numOfPlayers}</td>
</tr>
</c:forEach>
</table>
<br />
<input type="submit" value = "edit" name="doThisToItem">
<input type="submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name="doThisToItem">
</form>
</body>
</html>