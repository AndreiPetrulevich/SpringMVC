<%--
  Created by IntelliJ IDEA.
  User: k1netic
  Date: 22.04.2022
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer</title>
</head>
<body>
    <h2>Manufacturer: ${manufacturer.name}</h2>
    <h2>Products: ${manufacturer.products}</h2>

    <c:url var="deleteUrl" value="/manufacturer/delete">
        <c:param name="id" value="${manufacturer.id}"/>
    </c:url>

    <a href="${deleteUrl}">DELETE</a>

    <br>

    <c:url var="editUrl" value="/manufacturer/edit">
        <c:param name="id" value="${manufacturer.id}"/>
    </c:url>

    <a href="${editUrl}">EDIT</a>

</body>
</html>
