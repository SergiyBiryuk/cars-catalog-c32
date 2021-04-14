<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<html>
<head>
    <title>AddAdvert</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
<div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="/"> Home   <span class="sr-only">(current)</span></a>
        </li>
    </ul>
</div>
</nav>

<h2>Create a new advert</h2>

<c:if test="${!requestScope.checkModelCar}">
    <ul>
        <form action="/addAdvert" method="get">
            <li> Select mark car <select name="mark">
                <c:forEach items="${requestScope.listMark}" var="list">
                    <option value="${list}"> ${list} </option>
                </c:forEach>
            </select>
            </li>
            <button>Submit</button>
        </form>
    </ul>

</c:if>

<c:if test="${requestScope.checkModelCar}">
    <ul>

        <form action="/addAdvert" method="post">

            <li>Select model car <select name="model">
                <c:forEach items="${requestScope.listCar}" var="last">
                    <option value="${last}"> ${sessionScope.markSession} ${last} </option>
                </c:forEach>
            </select>
            </li>

            <li>Select color car <select name="color">
                <c:forEach items="${requestScope.colorList}" var="list">
                    <option value="${list}"> ${list} </option>
                </c:forEach>
            </select>
            </li>

            <li>Select production year <select name="year">
                <c:forEach items="${requestScope.listYear}" var="list">
                    <option value="${list}"> ${list} </option>
                </c:forEach>
            </select>
            </li>

    </ul>

    <p> Prise in BYN <input type="text" name="prise" placeholder="Prise"></p>


    <dl class="row offset-sm-1" >
        <div class="form-group  w-50">
            Описание
                <textarea class="form-control" name="specificationAdvert" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>
    </dl>

    <button>Submit</button>

    </form>
</c:if>
</form>
<b>${requestScope.checkAdvert}</b>
</body>
</html>
