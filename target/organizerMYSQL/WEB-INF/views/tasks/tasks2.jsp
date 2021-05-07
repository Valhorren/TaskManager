<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<
<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 06.05.2021
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
    </tr>
</table>
<c:forEach var="task" items="${tasks}">
    <tr>
        <td>${task.name}</td>
        <td>${task.description}</td>
    </tr>
</c:forEach>
</body>
</html>
