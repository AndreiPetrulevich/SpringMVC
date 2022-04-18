<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
%--
  Created by IntelliJ IDEA.
  User: k1netic
  Date: 05.04.2022
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h2>Title: ${product.title}</h2>
<h2>Price: ${product.cost}</h2>
<h2>Manufacture date: ${product.date}</h2>
<h2>Manufacturer: ${product.manufacturer}</h2>

<c:url var="deleteUrl" value="/product/delete">
    <c:param name="id" value="${product.id}"/>
</c:url>

<a href="${deleteUrl}">DELETE</a>

<br>

<c:url var="editUrl" value="/product/edit">
    <c:param name="id" value="${product.id}"/>
</c:url>

<a href="${editUrl}">EDIT</a>
</body>
</html>
