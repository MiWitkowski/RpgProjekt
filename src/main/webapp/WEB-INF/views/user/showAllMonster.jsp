<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 30.10.19
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potwory i spółka</title>
<style>
    #link {padding-right: 30px;
    text-align: left;
        margin: 50px;
    }
</style>
</head>
<body>

<table>
    <tr>
        <th>Name</th>
        <th>Hp</th>
        <th>Experience</th>
        <th>Walka</th>
    </tr>
    ${monster.getName()}
    ${monster.getName()}
    <c:forEach var="monster" items="${monsters}">
        <tr>
            <td>${monster.getName()}</td>
            <td>${monster.getHp()}</td>
            <td>${monster.getExperience()}</td>
            <td><a href="fight/${monster.getId()}">Walcz</a></td>
        </tr>
    </c:forEach>


</table>
<div id="link"><a href="javascript:history.back()">Powrót</a>
</div>


<a href=""></a>


</body>
</html>
