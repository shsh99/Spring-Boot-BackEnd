<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--TODO: jstl 표현식 사용을 위한 import --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%-- bootstrap css cdn   --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<p>${list}</p>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">dno</th>
            <th scope="col">dname</th>
            <th scope="col">loc</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <%--                TODO: 반복문 --%>
            <c:forEach var="data" items="${list}">
                <td>${data}</td>
            </c:forEach>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>