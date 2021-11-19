<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.twinkieman.weblab.models.User" %>
<%@ page import="com.twinkieman.weblab.dao.UserDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.twinkieman.weblab.DatabaseErrors" %><%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 028,28.09.2021
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Game Library</title>
</head>
<body>
    <h1 align="center">Game library app</h1>

    <%
        ResourceBundle res;
        String language = request.getParameter("lang");
        if (language == null) {
            res = ResourceBundle.getBundle("GameLibrary");
        }
        else if ((!language.equalsIgnoreCase("en")) && (!language.equalsIgnoreCase("ru"))) {
            res = ResourceBundle.getBundle("GameLibrary");
        } else {
            res = ResourceBundle.getBundle("GameLibrary", "en".equalsIgnoreCase(request.getParameter("lang")) ? Locale.ENGLISH : Locale.getDefault());
        }
    %>

    <div align="center" title=<%=res.getString("langUser.select")%>>
        <form name="languageForm" method="get" action="LangUserSet">
            Language: <select name="lang">
            <option value="ru">Russian</option>
            <option value="en">English</option>
        </select>
            <%=res.getString("username")%>: <input name="user"/>
            <input type = "submit" value="Submit" name="submitGameLibrary"/>
        </form>
    </div>

    <p align="center">Users</p>
    <%
        List<User> users = null;
        try {
            users = new UserDAOImpl().getAllUsers();
        } catch (DatabaseErrors.EntityManagerFactoryError e) {
            e.printStackTrace();
        }
        request.setAttribute("users",users);
    %>
    <table align="center" border='1'>
        <tr>
            <td><b><%=res.getString("name")%></b></td>
            <td><b><%=res.getString("username")%></b></td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.login}"/></td>
            </tr>
        </c:forEach>
    </table>

    <% if (request.getParameter("submitGameLibrary") != null) {%>
        <p>To invoke the game library servlet click <a href="GameLibraryServlet">here</a></p>
    <%}%>
</body>
</html>
