<%@ page import="com.twinkieman.weblab.dao.UserDAOImpl" %>
<%@ page import="com.twinkieman.weblab.models.User" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 022,22.10.2021
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="ErrorManager.jsp" %>
<html>
<body>
    <%
        List<User> users = new UserDAOImpl().getAllUsers();
        request.setAttribute("users",users);
        int count = users.size();
        PrintWriter printWriter = response.getWriter();
        ResourceBundle res = (ResourceBundle) session.getAttribute("res");
    %>
    <%--add user--%>
    <table align="center" border='1'>
        <tr>
            <td><b><%=res.getString("username")%></b></td>
            <td><b><%=res.getString("login")%></b></td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.login}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
