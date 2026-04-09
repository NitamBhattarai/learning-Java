<%@ page import="com.learinglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 3/29/2026
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User userObj = (User) session.getAttribute("user");
%>

<h1>User name: <%=
userObj.getName()
%> </>h1>
</body>
</html>
