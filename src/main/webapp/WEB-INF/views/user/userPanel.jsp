<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Panel użytkownika</title>

    <style>table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 3px solid darkred;
        text-align: left;
        padding: 8px;
    }

    #info {
        font-size: smaller;
        color: red;
    }
    </style>

</head>
<body>
<table>
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
<a href="user/rest">Odpoczynek</a>
<a href="/logout">Wyloguj się</a>

<p id="info">*Czas trwania odpoczynku zależy od ilości brakującego zdrowia</p>

</body>
</html>
