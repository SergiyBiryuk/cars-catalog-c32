<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Account</title>
</head>
<body>
<h1>"${requestScope.currentUserName}'s account"</h1>
<ul>
    <c:forEach items="{requestScope.currentUser}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>

<a href="/changeUserData">Change User Data</a>
<a href="/showAllAdverts">Sort All Adverts</a>
<a href="/showMyAdverts">Change my Adverts</a>
<a href="/deleteAdvert">Delete Advert</a>
<a href="/changeCurrentAdvert">Change Advert</a>
<a href="/showAllAdverts">Sort All Adverts</a>

<a href="/deleteMyAcc">Delete your account</a>
<a href="/">Logout</a>


</body>
</html>
