<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>League Lists</title>
</head>
<body>
<form method = "post" action = "listnavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist" }>
<tr>
	<td><input type="radio" name="id" value="${currentleague.id}"></td>
	<td><h2>${currentleague.leagueName}</h2></td>
	<tr><td colspan="3">Start Date: ${currentleague.startDate}</td></tr>
	<tr><td colspan="3">Player: ${currentleague.player.playerName}</td></tr>
	<c:forEach var = "leageVal" items = "${currentleague.listOfItems}">
		<tr><td></td><td colspan="3">
			${leageVal.city}, ${leageVal.nickName}
			</td>
		</tr>
	</c:forEach>
</c:forEach>
</table>
<input type ="submit" value = "edit" name="doThisToList">
<input type = "submit" value = "delete" name="doThisToList">
<input type = "submit" value = "add" name = "doThisToList">
</form>
<a href="addItemsForListServlet">Create a new List</a>
<a href="index.html">Insert a new item</a>
</body>
</html>