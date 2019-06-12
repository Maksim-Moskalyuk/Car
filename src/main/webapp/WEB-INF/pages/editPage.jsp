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
<c:url value="/add" var="addUrl"/>
<c:url value="/edit" var="editUrl"/>
<form action="${empty car.state_number ? addUrl : editUrl}" name="car" method="POST">
    <c:choose>
        <c:when test="${!empty car.state_number}">
            <p>Edit car</p>
            <input type="hidden" name="id" value="${car.id}">
        </c:when>
        <c:otherwise>
            <p>Add new car</p>
        </c:otherwise>
    </c:choose>
    <p><input type="text" name="state_number" placeholder="state_number" value="${car.state_number}" maxlength="100" required>
    <p><input type="text" name="uin" placeholder="uin" value="${car.uin}" maxlength="100" required>
    <p><input type="text" name="park_name" placeholder="park_name" value="${car.park_name}" maxlength="100" required>
    <p>
        <c:set value="add" var="add"/>
        <c:set value="edit" var="edit"/>
        <input type="submit" value="${empty car.state_number ? add : edit}">
    </p>
    <p>${message}</p>
</form>
</body>
</html>
