<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cars</title>

    <style>
        input, textarea {
            width: 100%;
        }
    </style>
</head>
<body>
    <h4>Cars</h4>

    <a href="s">servlet</a> | <a href="log">log</a><br/><br/>

    <c:if test="${hasErrors}">
        <h3 style="color: red">Please fix your input</h3>
    </c:if>

    <form method="POST">
        <table border="1" cellpadding="5">
            <thead>
            <tr>
                <th>name</th>
                <th>value</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>brand</td>
                <td><input type="text" name="brand" value="${car.brand}">${errors['brand']}</td>
            </tr>
            <tr>
                <td>model</td>
                <td><input type="text" name="model" value="${car.model}">${errors['model']}</td>
            </tr>
            <tr>
                <td>year</td>
                <td><input type="text" name="year" value="${car.year}">${errors['year']}</td>
            </tr>
            <tr>
                <td>review</td>
                <td><textarea name="review" id="" cols="30" rows="10" height="200">${car.review}</textarea>${errors['review']}</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit"></td>
            </tr>
            </tbody>
        </table>
    </form>

    <a href="s">Back to list</a>
</body>
</html>