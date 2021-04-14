<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>


<html>
<head>
    <title>Title</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/advert?id=${requestScope.id}">Return<span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>


<dl class="row" >
    <dt class="col-sm-2 offset-sm-1"> Автомобиль </dt>
        <dl class="col-sm-3">
<c:if test="${!requestScope.choiceMarkModel}">
            ${requestScope.advert.markCar}  ${requestScope.advert.modelCar}
    </c:if>
<c:if test="${requestScope.choiceMark}">
    <form action="/editAdvert/editMarkModel?id=${requestScope.id}&editMark=yes" method="post">
    <select name="newMark">
    <c:forEach items="${requestScope.listMark}" var="list">
        <option value="${list}"> ${list} </option>
    </c:forEach>
    </select>
    <button class="btn btn-secondary btn-sm offset-sm-2">Enter</button>
    </form>
</c:if>
    <c:if test="${requestScope.choiceModel}">
        <form action="/editAdvert/editMarkModel?id=${requestScope.id}&newMark=${requestScope.newMark}" method="post">
            <select name="newModel">
                <c:forEach items="${requestScope.listModel}" var="list">
                    <option value="${list}">${requestScope.newMark} ${list} </option>
                </c:forEach>
            </select>
                <button type="submit" class="btn btn-secondary btn-sm offset-sm-2">Save</button>
        </form>
</c:if>
        </dl>
        <dl class="col-sm"-1>
    <c:if test="${!requestScope.choiceMarkModel}">
        <form method="post" action="/editAdvert/editMarkModel?id=${requestScope.id}&editMarkModel=yes">
            <button type="submit" class="btn btn-secondary">Edit</button>
        </form>
    </c:if>
    </dl>
</dl>


<dl class="row" >
    <dt class="col-sm-2 offset-sm-1"> Цвет автомобиля  </dt>
        <dl class="col-sm-3">
<c:if test="${!requestScope.choiceColor}">
            ${requestScope.advert.colorCar}
</c:if>
<c:if test="${requestScope.choiceColor}">
    <form action="/editAdvert/editColor?id=${requestScope.id}" method="post">
    <select name="newColor">
    <c:forEach items="${requestScope.colorList}" var="list">
        <option value="${list}"> ${list} </option>
    </c:forEach>
    </select>
    <button class="btn btn-secondary btn-sm offset-sm-2">Save</button>
    </form>
</c:if>
        </dl>
    <dl class="col-sm-1">
        <c:if test="${!requestScope.choiceColor}">
            <form method="post" action="/editAdvert/editColor?id=${requestScope.id}&editColor=yes">
                <button type="submit" class="btn btn-secondary">Edit</button>
            </form>
        </c:if>
    </dl>
</dl>
</dl>


<dl class="row" >
<dt class="col-sm-2 offset-sm-1"> Год выпуска автомобиля </dt>
        <dl class="col-sm-3">
<c:if test="${!requestScope.choiceYear}">
            ${requestScope.advert.yearCar}
</c:if>
<c:if test="${requestScope.choiceYear}">
            <form action="/editAdvert/editYear?id=${requestScope.id}" method="post">
                <select name="newYear">
                 <c:forEach items="${requestScope.listYear}" var="list">
                    <option value="${list}"> ${list} </option>
                </c:forEach>
                </select>
             <button class="btn btn-secondary btn-sm offset-sm-2">Save</button>
            </form>
</c:if>
        </dl>

        <dl class="col-sm-1">
            <c:if test="${!requestScope.choiceYear}">
                <form method="post" action="/editAdvert/editYear?id=${requestScope.id}&editYear=yes">
                    <button type="submit" class="btn btn-secondary">Edit</button>
                </form>
            </c:if>
        </dl>
    </dl>
</dl>


<dl class="row" >
    <dt class="col-sm-2 offset-sm-1"> Цена автомобиля </dt>
    <dl class="col-sm-3">
        <c:if test="${!requestScope.choicePrice}">
            ${requestScope.advert.priceCar}
        </c:if>
        <c:if test="${requestScope.choicePrice}">
            <form action="/editAdvert/editPrice?id=${requestScope.id}" method="post">

                    <input type="text" name="newPrice" value="${requestScope.advert.priceCar}">

                <button class="btn btn-secondary btn-sm offset-sm-2">Save</button>
            </form>
        </c:if>
    </dl>

    <dl class="col-sm-1">
        <c:if test="${!requestScope.choicePrice}">
            <form method="post" action="/editAdvert/editPrice?id=${requestScope.id}&editPrice=yes">
                <button type="submit" class="btn btn-secondary">Edit</button>
            </form>
        </c:if>
    </dl>
</dl>
</dl>

<c:if test="${!requestScope.choiceDescription}">
<dl class="row offset-sm-1" >
    <div class="card w-50">
        <div class="card-header">
            Описание
        </div>
        <div class="card-body">
            <p class="card-text">
            <ul>
                ${requestScope.advert.specificationAdvert}
            </ul>
            </p>
        </div>
    </div>
</dl>
<form method="post" action="/editAdvert/editDescription?id=${requestScope.id}&editDescription=yes">
    <button type="submit" class="btn btn-secondary offset-sm-1">Edit</button>
</form>
</c:if>
<c:if test="${requestScope.choiceDescription}">
<form method="post" action="/editAdvert/editDescription?id=${requestScope.id}&editDescription=yes">
<dl class="row offset-sm-1  w-50">
            <dt class="col-sm-2">  Описание </dt>
                <textarea class="form-control" name="specificationAdvert" id="exampleFormControlTextarea1" rows="3">
                    ${requestScope.advert.specificationAdvert}
                </textarea>
</dl>
    <button type="submit" class="btn btn-secondary offset-sm-1">Save</button>
</form>
</c:if>

</body>
</html>
