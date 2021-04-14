<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<html>
<head>
    <title>Advert</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <form class="form-inline nav-item active">
                <a class="nav-link" href="/"> Home <span class="sr-only">(current)</span></a>
                <c:if test="${requestScope.checkIntrAdd}">
                    <button type="submit" formaction="/saveAdvert?id=${requestScope.id}" class="btn btn-outline-success" formmethod="post">Save advert for you list</button>
                </c:if>
                <c:if test="${requestScope.checkIntrRem}">
                    <button type="submit" formaction="/removeAdvert?id=${requestScope.id}" class="btn btn-outline-danger" formmethod="post">Remove advert with you list</button>
                </c:if>
                <c:if test="${requestScope.checkYouAdvert}">
                    <a href="/editAdvert?id=${requestScope.id}" class="btn btn-primary" >Edit advert</a>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                        Deleted advert
                    </button>
                </c:if>
            </form>
        </ul>
    </div>
</nav>

<dl class="row" >
    <dt class="col-sm-2 offset-sm-2"> Автомобиль ${requestScope.advert.markCar}  ${requestScope.advert.modelCar}</dt>
</dl>
<dl class="row" >
    <dt class="col-sm-2 offset-sm-1"> Имя владельца </dt>
    <dd class="col-sm-8">${requestScope.user.name}</dd>
    <dt class="col-sm-2 offset-sm-1"> Фамилия владельца </dt>
    <dd class="col-sm-8">${requestScope.user.lastName}</dd>
    <dt class="col-sm-2 offset-sm-1"> Телефон владельца </dt>
    <dd class="col-sm-8">${requestScope.user.phone}</dd>
    <dt class="col-sm-2 offset-sm-1"> Цвет автомобиля </dt>
    <dd class="col-sm-8">${requestScope.advert.colorCar}</dd>
    <dt class="col-sm-2 offset-sm-1"> Год выпуска автомобиля </dt>
    <dd class="col-sm-8">${requestScope.advert.yearCar}</dd>
    <dt class="col-sm-2 offset-sm-1"> Цена автомобиля </dt>
    <dd class="col-sm-8">${requestScope.advert.priceCar}</dd>
    <dt class="col-sm-2 offset-sm-1"> Дата регистрации </dt>
    <dd class="col-sm-8">${requestScope.advert.dateAdvert}</dd>
</dl>

<dl class="row offset-sm-1" >
    <div class="card w-50">
        <div class="card-header">
            Описание
        </div>
        <div class="card-body">
            <p class="card-text">
            <ul>
                ${requestScope.advert. specificationAdvert}
            </ul>
            </p>
        </div>
    </div>
</dl>

<c:if test="${sessionScope.checkAuth}">


    <dl class="row offset-sm-1" >
        <div class="card w-50">
            <div class="card-header">
                Сообщения
            </div>
            <div class="card-body">
                <p class="card-text">
                <ul>
                    <c:forEach items="${requestScope.advert.message}" var="item">
                        <li>${item.nameUser} ${item.date} ${item.body}</li>
                    </c:forEach>
                </ul>
                </p>
            </div>
        </div>
    </dl>

    <dl class="row offset-sm-1" >
        <div class="form-group  w-50">
            Коментировать
            <form name="addMessage" action="/MessageServlet?id=${requestScope.id}" method="post">
                <textarea class="form-control" name="addMessage" id="exampleFormControlTextarea1" rows="3"></textarea>
                <button>Submit</button>
            </form>
        </div>
    </dl>

</c:if>

</body>
</html>

