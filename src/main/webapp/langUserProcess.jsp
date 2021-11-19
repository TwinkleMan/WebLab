<%@ page import="com.twinkieman.weblab.DatabaseErrors" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="com.twinkieman.weblab.utils.EntityManagerUtil" %><%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 022,22.10.2021
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%
        String language = request.getParameter("lang");
        if (language == null) {
            throw new DatabaseErrors.EntityManagerFactoryError("Language not specified!");
        }

        ResourceBundle a = ResourceBundle.getBundle(
                "GameLibrary", "en".equalsIgnoreCase(language) ? Locale.ENGLISH : Locale.getDefault());
        session.setAttribute("res",a);

        String name = request.getParameter("user");
        if (name == null) {
            throw new IllegalArgumentException("User expected");
        }
        EntityManager em = EntityManagerUtil.getEntityManager();
        session.setAttribute("user",name);
    %>
    <%@include file="GamesTableData.jsp"%>
</body>
</html>
