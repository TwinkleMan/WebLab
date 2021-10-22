<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%--Author: Esin A., created 11.10.2021
    landing page: title--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"
    pageEncoding="UTF-8" errorPage="ErrorManager.jsp" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="com.twinkieman.weblab.utils.EntityManagerUtil" %>
<%@ page import="net.bytebuddy.implementation.ToStringMethod" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            request.setCharacterEncoding("utf-8");
            String language = request.getParameter("lang");

            if (language == null) {
                throw new IllegalArgumentException("Language expected");
            }
            if(!"en".equalsIgnoreCase(language) && !"ru".equalsIgnoreCase(language)) {
                throw new IllegalArgumentException("Language can only be en or ru");
            }
            response.setContentType("text/html;charset=UTF-8");
            ResourceBundle res = ResourceBundle.getBundle(
                    "GameLibrary", "en".equalsIgnoreCase(language) ? Locale.ENGLISH : Locale.getDefault());
            session.setAttribute("res",res);
        %>
        <title><%=res.getString("title")%></title>
    </head>
    <body>
        <%
            String name = request.getParameter("user");
            if (name == null) {
                throw new IllegalArgumentException("User expected");
            }
            EntityManager em = EntityManagerUtil.getEntityManager();
        %>
        <h1 align="center"><%=res.getString("table.name")%> <%=name%></h1>
        <%@include file="TableData.jsp"%>
    </body>
</html>
