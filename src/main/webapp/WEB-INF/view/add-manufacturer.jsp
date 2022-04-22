<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Title</title>
</head>
<body>
<%--@elvariable id="manufacturer" type=""--%>
<form:form action="addManufacturer" modelAttribute="manufacturer">
    <form:hidden path="id" value="${manufacturer.id}"/>
    Name: <form:input path="name"/>
</form:form>
</body>
</html>
