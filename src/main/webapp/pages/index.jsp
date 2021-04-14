<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
<html>
<head>
    <h1>Hello ${sessionScope.currentUser.name}!
        It's Cars Catalog ver.1</h1>

    <c:if test="${!sessionScope.checkAuth}">
        <a href="/reg">Registration |</a>
        <a href="/auth">Authorisation |</a>
    </c:if>

       <style>
           body { background: url("https://images5.alphacoders.com/393/393646.jpg")  }
        </style>

    <c:if test="${sessionScope.checkAuth}">
        <a href="/addAdvert">Add Advert |</a>
        <a href="/pers">Personal Account |</a>
        <a href="/logout">Logout |</a>
        <c:if test="${sessionScope.currentAdmin && sessionScope.checkAuth}">
            <a href="/listAllUsers">Show all users |</a>
            <a href="/deleteUsers">Delete user |</a>
            <a href="/addUser">Add new user |</a>
            <a href="/changeUserData">Change user's data |</a>
            <a href="/showAllAdverts">Show all adverts |</a>
            <a href="/changeAdverts">Change adverts |</a>
            <a href="/deleteAdverts">Delete adverts |</a>
            <a href="/delete comments">Delete comments |</a>
            <a href="/deleteMyAcc">Delete my account |</a>
            <a href="/index">Go to main page |</a>
            <a href="/logout">Logout |</a>
        </c:if>
    </c:if>


    <c:if test="${!requestScope.hadChosen}">
        <form action="" method="get">

            <select name="mark">
                <option selected disabled hidden>Choose Mark</option>
                <option style="color:gray" value="anyMark">Any mark</option>
                <c:forEach items="${requestScope.AllAdvertMarks}" var="var">
                    <option value="${var}"> ${var} </option>
                </c:forEach>
            </select>
            <select name="sort">
                <option selected disabled hidden>Sort</option>
                <option style="color: gray" value="none">None</option>
                <option value="ascPrice">Ascending price</option>
                <option value="descPrice">Descending price</option>
                <option value="ascYear">Ascending year</option>
                <option value="descYear">Descending year</option>
            </select>


            <li><input type="radio" name="color" value="anyColor" checked/>Any Color</li>
            <c:forEach items="${requestScope.colorList}" var="item">
                <li><input type="radio" name="color" value="${item}" checked/>${item}</li>
            </c:forEach>
            <button>Submit</button>
            <a href="/">Clear</a>
        </form>

    </c:if>

    <c:if test="${requestScope.hadChosen}">
        <form action="" method="post">
            <select name="mark">
                <option value="${requestScope.mark}">${requestScope.mark}</option>
            </select>
            <select name="model">
                <option style="color:gray" value="anyModel" selected>Any model</option>
                <c:forEach items="${requestScope.modelByMark}" var="model">
                    <option value="${model}">${model}</option>
                </c:forEach>
            </select>
            <select name="postSort">
                <option selected disabled hidden>Sort</option>
                <option style="color: gray" value="none">None</option>
                <option value="ascPrice">Ascending price</option>
                <option value="descPrice">Descending price</option>
                <option value="ascYear">Ascending year</option>
                <option value="descYear">Descending year</option>
            </select>


            <li><input type="radio" name="postColor" value="anyColor" checked/>Any Color</li>
            <c:forEach items="${requestScope.colorList}" var="item">
               <li><input type="radio" name="postColor" value="${item}" checked/>${item}</li>
            </c:forEach>

            <button>Submit</button>
            <a href="/">Clear</a>

        </form>
        ${requestScope.message}
    </c:if>

    <div class="container">
        <div class="row row-cols-3">
            <c:forEach items="${requestScope.advertList}" var="last">
                <div class="col">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">${last.markCar} ${last.modelCar}</h5>
                            <p class="card-text">${last}</p>
                            <a href="/advert?id=${last.id}">Go somewhere</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

</head>
<body>

<p>Today: <c:out value="<%=new java.util.Date()%>"/></p>

</body>

</html>