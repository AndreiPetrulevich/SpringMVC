<%--
  Created by IntelliJ IDEA.
  User: k1netic
  Date: 22.04.2022
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer List</title>
</head>
<body>
<h1>Manufacturer List:</h1>
<ul>
    <c:forEach var="pmanufacturer" items="${manufacturers}">
        <c:url var="viewUrl" value="/manufacturer/ + ${manufacturer.id}"/>
        <li>
            <a href="${viewUrl}">View</a>
            <br>
            Title: ${manufacturer.name}
        </li>
    </c:forEach>
</ul>
<br>
<c:url var="createUrl" value="/manufacturer/addManufacturer"/>

<a href="${createUrl}">CREATE</a>
</body>
</html>
