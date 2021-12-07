<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 028,28.09.2021
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cookie test</title>
</head>
<body>
    <div style = "text-align:center;">
        <h1>Введите данные</h1>
        <form style="text-align: match-parent" method = "POST" action = "index.jsp">
            Имя: <input type = "text" name = "user" required><br /> <br />
            Цвет фона: <input type = "text" name = "BackColor" required> <br /> <br />
            Цвет шрифта: <input type = "text" name = "FontColor" required> <br /><br />
            <input type = "submit" name = "submit" value = "Submit">
        </form>
    </div>

    <%
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime currTime = LocalDateTime.now();

        if (request.getParameter("submit") != null) {
            String username = request.getParameter("user");
            String backgroundColor = request.getParameter("BackColor");
            String fontColor = request.getParameter("FontColor");

            Cookie usernameCookie = new Cookie("user", username);
            Cookie backgroundCookie = new Cookie("BackColor", backgroundColor);
            Cookie fontCookie = new Cookie("FontColor", fontColor);

            response.addCookie(usernameCookie);
            response.addCookie(backgroundCookie);
            response.addCookie(fontCookie);

            if (request.getSession(true).getAttribute("VisitCount") != null) {
                int count = Integer.parseInt(request.getSession().getAttribute("VisitCount").toString());
                request.getSession().setAttribute("VisitCount", ++count);
            } else  {
                request.getSession().setAttribute("VisitCount", 1);
            }

            request.getSession().setAttribute("LastVisitTime", currTime);

            response.sendRedirect("lab.jsp");
        }
    %>

</body>
</html>
