<%--Author: Esin A., created 11.10.2021
    landing page: title--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"
    pageEncoding="UTF-8" errorPage="ErrorManager.jsp" %>
<%@ page import="java.util.ResourceBundle" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%request.setCharacterEncoding("utf-8");%>
        <title>Game list</title>
    </head>
    <body>
        <div align="center" title="Select language and enter username">
            <form name="languageForm" method="get" action="langUserProcess.jsp">
                Language: <select name="lang">
                <option value="ru">Russian</option>
                <option value="en">English</option>
            </select>
                Username: <input name="user"/>
                <input type = "submit" value="Submit" name="submitGameLibrary"/>
            </form>
        </div>

        <% if (request.getParameter("submitGameLibrary") != null) {
        ResourceBundle res = (ResourceBundle) session.getAttribute("res");%>
        <h1 align="center"><%=res.getString("table.name")%> <%=session.getAttribute("user")%></h1>
        <%@include file="GamesTableData.jsp"%>
        <%}%>
    </body>
</html>
