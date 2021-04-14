<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Changing current Advert</title>
</head>
<body>
<h3>Change current Advert</h3>
<ul>
    <c:forEach items="{requestScope.currentAdvert}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>

<form action="/changeCurrentAdvert" method="post">
    <input type="text" name="newModel" placeholder="Change model">
    <input type="text" name="newColor" placeholder="Change color">
    <input type="text" name="newYear" placeholder="Change year">
    <input type="text" name="newPrice" placeholder="Change price">
    <input type="text" name="newDescription" placeholder="Change description">
    <button>Apply</button>
</form>

<a href="/">Go to main page</a>

</body>
</html>
