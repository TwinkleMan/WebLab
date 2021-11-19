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
        <form name="createUser" method="get" action="CreateUserEngine.jsp">
        <table align="center" border="0">
            <tr>
                <td><b><%=resourceBundle.getString("create.name")%>: </b></td>
                <td><b><input type="text" name="name" /></b></td>
            </tr>
            <tr>
                <td><b><%=resourceBundle.getString("create.login")%>: </b></td>
                <td><b><input type="text" name="login" /></b></td>
            </tr>
            <tr>
                <td><b><%=resourceBundle.getString("create.password")%>: </b></td>
                <td><b><input type="text" name="password" /></b></td>
            </tr>
            <tr>
                <td><b><%=resourceBundle.getString("choose.games")%>: </b></td>
                <td><b><%@include file="AddUser_gameList.jsp"%></b></td>
            </tr>
            <%--add dropdown menu of all games to choose--%>
        </table>
        <input type="submit" value="Submit" name="submit_user">
        </form>
    </div>
</body>
</html>
