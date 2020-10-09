<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit League</title>
</head>
<body>
<form action = "editLeagueServlet" method="post">
<input type="hidden" name="id" value="${leagueToEdit.id }">
League Name: <input type="text" name="listName" value="${leagueToEdit.leagueName }"><br />

Start Date: <input type="text" name="month" placeholder="mm" size="4" value="${month}"> <input type="text" name="day" placeholder="dd" size="4" calue="${day}">, <input type="text" name="year" placeholder="yyyy" size="4" value="${year}">

Player Name: <input type = "text" name = "playerName" value="${leagueToEdit.player.playerName}"><br />

Available Items:<br />

<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allLeagues}" var="currentleague">
	<option value="${currentleague.id}">${currentleague.city} | ${currentleague.nickName}</option>
</c:forEach>
</select> 
<br />
<input type="submit" value="Edit League and Add Items">
</form>
<a href = "index.html">Go add new items instead</a>
</body>
</html>