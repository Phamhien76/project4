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
    <link href="<%=request.getContextPath()%>/resources/css/login.css" rel="stylesheet"/>
    <script src="https://use.typekit.net/rjb4unc.js"></script>
    <script>try{Typekit.load({ async: true });}catch(e){}</script>
</head>
<body>

<form action="<%=request.getContextPath()%>/userController/login" method="post" class="form form-login">
    <div class="login wrap">
        <input type="text" name="email" id="email" placeholder="Email" pattern="^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$"/>
        <input type="password" name="password" id="password" placeholder="Password" />
        <c:if test="${not empty error}">
            <label style="color:red">${error}</label><br>
        </c:if>
        <input type="button" value="Help!" />
        <input type="submit" value="Log in" />
    </div>
</form>
</body>
</html>
