<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 09.11.19
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 4px solid blue;
        text-align: left;
        padding: 8px;
    }
    </style>
</head>
<body>

<table>
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Status konta</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getUsername()}</td>
            <td>${user.getEnabled()}</td>
            <td><a href="delete/${user.getId()}">Usuń</a></td>
            <td><a href="ban/${user.getId()}">Zbanuj/Odbanuj</a></td>


        </tr>
    </c:forEach>
</table>
<a href="javascript:history.back()">Powrót</a>


</body>
</html>
