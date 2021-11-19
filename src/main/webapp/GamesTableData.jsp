<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.twinkieman.weblab.models.User" %>
<%@ page import="com.twinkieman.weblab.dao.UserDAOImpl" %>
<%@ page import="com.twinkieman.weblab.models.Game" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %><%--Author: Esin A., created 11.10.2021
    landing page: table data--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" errorPage="ErrorManager.jsp" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%request.setCharacterEncoding("utf-8");%>
    <title>List of games</title>
</head>
<body>
<table align="center" border='1'>
    <%ResourceBundle ress = ResourceBundle.getBundle("GameLibrary",
            "en".equalsIgnoreCase((String) session.getAttribute("lang")) ? Locale.ENGLISH : Locale.getDefault());%>

    <tr>
        <td><b><%=ress.getString("developer")%></b></td>
        <td><b><%=ress.getString("game.name")%></b></td>
        <td><b><%=ress.getString("completed")%></b></td>
    </tr>

    <%
        User user;
        Set<Game> ownedGames;
        List<Integer> progress = null;
        int i = 0;

        String login = (String) session.getAttribute("user");
        List<User> temp = new UserDAOImpl().searchByLogin(login);
        if (temp.size() != 0) {
            user = temp.get(0);
            request.setAttribute("curUser",user);
            ownedGames = user.getOwnedGames();
            progress = user.getGamesProgress();
            request.setAttribute("ownedGames", ownedGames);
        } else throw new IllegalArgumentException("There is no such user!");%>


    <c:forEach items="${ownedGames}" var="game">
        <tr>
            <td><c:out value="${game.company.name}"/></td>
            <td><c:out value="${game.name}"/></td>
            <td><%if (progress.get(i) == 0) {%><%=ress.getString("ans.no")%><%}%>
            <%if (progress.get(i) == 1) {%><%=ress.getString("ans.yes")%><%}%></td>
            <%i++;%>
        </tr>
    </c:forEach>

</table>
</body>
