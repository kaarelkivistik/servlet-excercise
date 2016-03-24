<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cars</title>
</head>
<body>
    <h4>Cars</h4>

    <a href="s">servlet</a> | <a href="log">log</a><br/><br/>

    <table border="1" cellpadding="5">
        <thead>
            <tr>
                <th>id</th>
                <th>brand</th>
                <th>model</th>
                <th>year</th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.id}</td>
                <td>${car.brand}</td>
                <td>${car.model}</td>
                <td>${car.year}</td>
                <td><a href="carservice?id=${car.id}">description</a></td>
                <td><a href="s?id=${car.id}">edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>