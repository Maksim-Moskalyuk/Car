<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:choose>
        <c:when test="${empty car.state_number}">
            <title>Add</title>
        </c:when>
        <c:otherwise>
            <title>Edit</title>
        </c:otherwise>
    </c:choose>
</head>
<body>
<c:if test="${empty car.state_number}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty car.state_number}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty car.state_number}">
        <input type="hidden" name="id" value="${car.id}">
    </c:if>
    <label for="state_number">Number</label>
    <input type="text" name="state_number" id="state_number">

    <label for="uin">UIN</label>
    <input type="text" name="uin" id="uin">

    <label for="park_name">Park Name</label>
    <input type="text" name="park_name" id="park_name">

    <c:if test="${empty car.state_number}">
        <input type="submit" value="Add new car">
    </c:if>
    <c:if test="${!empty car.state_number}">
        <input type="submit" value="Edit car">
    </c:if>
</form>
</body>
</html>