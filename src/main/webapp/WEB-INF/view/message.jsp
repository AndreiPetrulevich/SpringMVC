<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: k1netic
  Date: 01.04.2022
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<h2> Message from: ${message.from}</h2>
<h2> Message to: ${message.to}</h2>
<h2> Message body: ${message.body}</h2>

<c:url var="deleteUrl" value="/message/delete">
    <c:param name="id" value="${message.id}"/>
</c:url>

<a href="${deleteUrl}">DELETE</a>

<br>

<c:url var="editUrl" value="/message/edit">
    <c:param name="id" value="${message.id}"/>
</c:url>

<a href="${editUrl}">EDIT</a>
</body>
</html>
