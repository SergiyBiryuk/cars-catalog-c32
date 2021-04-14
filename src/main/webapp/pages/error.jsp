
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<html>
<head>
    <title>Error</title>
    <img src="https://thumbs.dreamstime.com/b/не-найденная-страница-28300339.jpg"height="500" width="400">

</head>
<body>
<h3>${requestScope.message}</h3>


<div class="spinner-grow text-primary" role="status">
    <span class="sr-only">Loading...</span>
</div>


<a href="/" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Return HomePage</a>


<div class="spinner-grow text-primary" role="status">
    <span class="sr-only">Loading...</span>
</div>


</body>
</html>
