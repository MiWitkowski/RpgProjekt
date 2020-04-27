<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 14.11.19
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="/resources/css/bootstrap.css">

    <title>Panel użytkownika</title>

    <style>
        .table {
            width: 30%;
        }
        #info {
            color: #FF2E43;
            font-size: small;
        }
    </style>
</head>
<body>
<table class="table table-secondary table-bordered table-striped">
    <tr>
        <th>Name</th>
        <th>Hp</th>
        <th>Experience</th>
        <th>Level</th>
    </tr>


    <tr>
        <td>${user.getUsername()}</td>
        <td>${user.getHp()}</td>
        <td>${user.getExperience()}</td>
        <td>${user.getLvl()}</td>
    </tr>
</table>

<a href="/user/showAllMonster">Walcz z potworami</a>
<a href="/user/rest">Odpoczynek</a>
<a href="/user/ranking">Ranking</a>
<a href="/logout">Wyloguj się</a>

<p id="info">*Czas trwania odpoczynku zależy od ilości brakującego zdrowia</p>

</body>
</html>
