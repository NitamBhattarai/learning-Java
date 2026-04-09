<%@ page import="com.learinglog.learninglogproject.user.model.User" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 4/2/2026
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User userobj = (User) session.getAttribute("user");
    int id = 0;
    if(userobj!=null){
        id = userobj.getId();
    }

%>

<%
    String errorMsg = (String) request.getAttribute("error");
    if(errorMsg==null){
        errorMsg="";
    }
    String successMsg = (String) request.getAttribute("success");
    if(successMsg==null){
        successMsg = "";
    }
%>

<p style="color: red"><%= errorMsg%></p>
<p style="color: green"><%= successMsg%></p>


<form method="POST" action="">
    <label>Action: </label>
    <input type = "text" value = "add" name = "action">
    <br>
    <input type="text" value="<%id%>" name = "user_id"
    <br>
    <label>Name</label>: <input type="text"  name = "topic_name">
    <button>Add Topic  </button>
</form>
</body>
</html>
