<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new League</title>
</head>
<body>
<form action = "createNewLeagueServlet" method="post">
	League Name: <input type = "text" name = "leagueName"><br />
	Start Date: <input type = "text" name = "monnth" placeholder="mm" size="4"> <input type = "text" name="day" placeholder="dd" size="4">, <input type="text" name="year" placeholder="yyyy" size="4">
	Player Name: <input type = "text" name = "playerName"><br />
	Available Items:<br />
	<select name="allItemsToAdd" multiple size="6">
		<c:forEach items="${requestScope.allLeagues}" var="currentleague">
			<option value = "${currenntleague.id }">${currentleague.city} | ${currentleague.nickName }</option>
		</c:forEach>
	</select>
	<br />
	<input type="submit" value="Create List and Add Items">
</form>
<a href="index.html">Go add new items instead</a>
</body>
</html>