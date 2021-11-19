<%@ page import="com.twinkieman.weblab.models.User" %>
<%@ page import="com.twinkieman.weblab.models.Game" %>
<%@ page import="com.twinkieman.weblab.dao.GameDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 031,31.10.2021
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="ErrorManager.jsp"%>
<html>
<body>
  <%
    User newUser = new User();
    String name = request.getParameter("name");
    String login = request.getParameter("login");
    String password = request.getParameter("password");

    newUser.setName(name);
    newUser.setLogin(login);
    newUser.setPassword(password);

    List<Game> allGames = new GameDAOImpl().getAllGames();
    List<Game> userGames = new ArrayList<>();
    List<Integer> gameProgress = new ArrayList<>();
    for (Game game: allGames) {
      if (request.getParameter(String.valueOf(game.getId())) != null) userGames.add(game);
      //if (request.)
    }
  %>
</body>
</html>
