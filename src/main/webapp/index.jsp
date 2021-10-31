<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 022,22.10.2021
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"
         pageEncoding="UTF-8" errorPage="ErrorManager.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%request.setCharacterEncoding("utf-8");%>
    <title>List of users</title>
</head>
<body>

    <div align="center" title="Select language and enter username">
        <form name="languageIndex" method="get" action="langProcess.jsp">
            Language: <select name="lang">
            <option value="ru">Russian</option>
            <option value="en">English</option>
        </select>
            <input type = "submit" value="Submit" name="submit"/>
        </form>
    </div>

    <% if (request.getParameter("submit") != null) {%>
    <div align="center">
        <a href="CreateUser.jsp">Create user</a>
    </div>
    <%@include file="UsersTable.jsp"%>
    <%}%>

</body>
</html>
