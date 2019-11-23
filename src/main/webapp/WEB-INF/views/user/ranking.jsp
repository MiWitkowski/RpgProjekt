<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 23.11.19
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ranking</title>
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
    </style>

</head>
<body>

<table>
    <tr>
        <th>Name</th>
        <th>Level</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.getUsername()}</td>
            <td>${user.getLvl()}</td>
        </tr>
    </c:forEach>


</table>


<a href="javascript:history.back()">Powrót</a>


</body>
</html>
