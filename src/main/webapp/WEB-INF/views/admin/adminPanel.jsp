<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 09.11.19
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ page isELIgnored="false"%>--%>

<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <title>Panel Administratora</title>
</head>
<body>

<h1>Panel administratora</h1>
<table class="table table-striped">
    <tr>
        <th>
            <a href="admin/showUsers">Wyświetl użytkowników</a>
        </th>
        <th>
            <a href="admin/addMonster">Dodaj potworka</a>
        </th>
    </tr>
</table>

<h2><a href="/logout">Wyloguj się</a></h2>

</body>
</html>
