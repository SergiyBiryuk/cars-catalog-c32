<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ChangeAdvert</title>
</head>
<body>


<h3>All your adverts</h3>
<ol>
    <c:forEach items="{requestScope.currentUserAdvertsList}" var="item">
        <li>${item}</li>
    </c:forEach>
</ol>

<h3>Select advert's number to change:</h3>

<form action="/getAllUserAdverts" method="get">
    <input type="number" name="advertNumber" placeholder="Advert Number">
    <button>Change</button>
</form>

<a href="/">Go to main page</a>

</body>
</html>
