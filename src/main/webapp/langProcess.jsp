<%@ page import="com.twinkieman.weblab.DatabaseErrors" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 022,22.10.2021
  Time: 19:38
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
                "UserTable", "en".equalsIgnoreCase(language) ? Locale.ENGLISH : Locale.getDefault());
        session.setAttribute("res",a);
        session.setAttribute("lang",language);%>
    <%@include file="index.jsp"%>
</body>
</html>
