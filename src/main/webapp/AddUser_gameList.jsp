<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.List" %>
<%@ page import="com.twinkieman.weblab.models.Game" %>
<%@ page import="com.twinkieman.weblab.dao.GameDAOImpl" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 031,31.10.2021
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="ErrorManager.jsp" %>
<html>
<body>
    <%
        List<Game> games = new GameDAOImpl().getAllGames();
        request.setAttribute("games",games);
        String language = (String) session.getAttribute("lang");
        ResourceBundle res = ResourceBundle.getBundle(
                "GameLibrary", "en".equalsIgnoreCase(language) ? Locale.ENGLISH : Locale.getDefault());%>

    <div align="center">
        <table align="center" border='0'>
            <tr>
                <td><b><%=res.getString("developer")%></b></td>
                <td><b><%=res.getString("game.name")%></b></td>
                <td><b><%=res.getString("completed")%></b></td>
            </tr>
            <c:forEach items="${games}" var="game">
                <tr>
                    <td><c:out value="${game.company.name}"/></td>
                    <td><c:out value="${game.name}"/></td>
                    <td><input type="checkbox" id="${game.id}" value="owned"></td>
                    <td><input type="checkbox" id="${game.id}+completed" value="completed"></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
