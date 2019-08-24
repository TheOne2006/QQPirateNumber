<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>admin管理页面</title>
</head>
<body>
<table border="1">
    <tr style="color: rebeccapurple" bgcolor="#f5f5f5">
        <th>id</th>
        <th>login_id</th>
        <th>password</th>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="status">
        <tr style="background-color: ${status.count % 2 == 0?"#f5f5f5":"#d3d3d3"}">
            <td align="center">${user.id}</td>
            <td align="center">${user.login_id}</td>
            <td align="center">${user.password}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
