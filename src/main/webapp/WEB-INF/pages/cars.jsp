<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CARS</title>
</head>
<body>
<table>
    <caption>Cars</caption>
    <tr>
        <th>№</th>
        <th>State Number</th>
        <th>UIN</th>
        <th>Park Name</th>
        <th colspan="2">action</th>
    </tr>
    <c:forEach var="car" items="${carsList}" varStatus="i">
        <tr>
            <td>${i.index + 1 + (page - 1) * 10}</td>
            <td>${car.state_number}</td>
            <td>${car.uin}</td>
            <td>${car.park_name}</td>
            <td><a href="<c:url value="/edit/${car.id}"/>">edit</a></td>
            <td><a href="<c:url value="/delete/${car.id}"/>">delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7">
            <a href="<c:url value="/add"/>">Add new car</a>
            <c:forEach begin="${1}" end="${pagesCount}" step="1" varStatus="i">
                <c:url value="/" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href="${url}">${i.index}</a>
            </c:forEach>
        </td>
    </tr>
</table>
</body>
</html>


