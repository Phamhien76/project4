<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024/01/01
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="login-box">
    <h2>Login</h2>
    <form>
        <div class="user-box">
            <input type="text" name="" required="">
            <label>Email</label>
        </div>
        <div class="user-box">
            <input type="password" name="" required="">
            <label>Password</label>
        </div>
        <c:if test="${not empty error}">
            <label style="color:red">${error}</label><br>
        </c:if>
        <a href="<%response.sendRedirect("/views/dashboard.jsp");%>">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            Submit
        </a>
    </form>
</div>
</body>
</html>
