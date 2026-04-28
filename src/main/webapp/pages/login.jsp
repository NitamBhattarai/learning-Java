<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 3/22/2026
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" src ="../static/css/style.css">
</head>
<body>


<p style="color: red" >${error}</p>
<p style="color: green" >${success}</p>

<form action="login" method="post">
    <label>Email</label>
    <input type="text" name="email">
    <label>Password</label>
    <input type="text" name="password">
    <button>Login</button>
</form>
</body>
</html>