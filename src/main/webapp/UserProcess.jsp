<%@ page import="com.twinkieman.weblab.DatabaseErrors" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="com.twinkieman.weblab.utils.EntityManagerUtil" %><%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 014,14.11.2021
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    String name = request.getParameter("user");
    if (name == null) {
        throw new IllegalArgumentException("User expected");
    }
    session.setAttribute("user",name);
%>
<%@include file="index.jsp"%>
</body>
</html>
