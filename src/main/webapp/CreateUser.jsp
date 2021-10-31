<%@ page import="com.twinkieman.weblab.models.User" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 022,22.10.2021
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create user</title>
</head>
<body>
    <%
        User newUser = new User();
        String language = (String) session.getAttribute("lang");
        ResourceBundle resourceBundle = ResourceBundle.getBundle(
                "UserTable", "en".equalsIgnoreCase(language) ? Locale.ENGLISH : Locale.getDefault());
    %>

    <div align="center">
        <h1><%=resourceBundle.getString("create.title")%></h1>
        <br><br>
        <%=resourceBundle.getString("create.name")%>: <input type="text" name="name" />
        <br><br>
        <%=resourceBundle.getString("create.login")%>: <input type="text" name="login" />
        <br><br>
        <%=resourceBundle.getString("create.password")%>: <input type="text" name="password" />
        <%--add dropdown menu of all games to choose--%>
    </div>
</body>
</html>
