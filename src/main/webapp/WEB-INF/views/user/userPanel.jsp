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
        width: 50%;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
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


    <%--
    <c:forEach var="user" items="${user}">
--%>
        <tr>
            <td>${user.getUsername()}</td>
            <td>${user.getHp()}</td>
            <td>${user.getExperience()}</td>
            <td>${user.getLvl()}</td>
            <%--<td><a href="fight/${monster.getId()}">Walcz</a></td>--%>
        </tr>
<%--
    </c:forEach>
--%>
</table>


</body>
</html>
