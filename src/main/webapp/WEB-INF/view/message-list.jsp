<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: k1netic
  Date: 04.04.2022
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message List</title>
</head>
<body>
<h1>Message List:</h1>
<ul>
    <c:forEach var="message" items="${messages}">
        <c:url var="viewUrl" value="/message/ + ${message.id}"/>
        <li>
            <a href="${viewUrl}">View</a>
            <br>
            Message from: ${message.from}
            <br>
            Message to: ${message.to}
            <br>
            Message: ${message.body}
            <br>
        </li>
    </c:forEach>
</ul>
<br>
<c:url var="createUrl" value="/message/create"/>

<a href="${createUrl}">CREATE</a>
</body>
</html>
