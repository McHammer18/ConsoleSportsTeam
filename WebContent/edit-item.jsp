<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit My List</title>
</head>
<body>
<h2>Edit My Team List</h2>

<form action ="editItemServlet"method="post">
City: <input type ="text"name ="city"value="${itemToEdit.city}">
Team: <input type ="text"name ="team"value="${itemToEdit.nickName}">
Number of Players: <input type ="text"name ="numOfPlayers"value="${itemToEdit.numOfPlayers}">
<input type ="hidden"name ="id"value="${itemToEdit.id}">
<input type ="submit"value="Save Edited Item">
</form>
</body>
</html>