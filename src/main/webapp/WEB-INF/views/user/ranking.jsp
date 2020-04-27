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
    <link rel="stylesheet" href="/resources/css/bootstrap.css">

    <style>
        .table {width: 80%;
        margin-right: auto;
        margin-left: auto;
        }
    </style>
</head>
<body>

<table class="table table-info table-striped table-bordered">
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
