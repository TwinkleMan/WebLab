<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 019,19.11.2021
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Show results</title>
        <%
            Cookie[] cookies = request.getCookies();
            String backColor = "white";
            String fontColor = "black";
            if (cookies != null) {

                for (int i =0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("BackColor")) backColor = cookies[i].getValue();
                    else if (cookies[i].getName().equals("FontColor")) fontColor = cookies[i].getValue();
                }
            }
        %>
    </head>
    <body style="background-color:<%=backColor%>">
        <div style="color: <%=fontColor%>; text-align: center">
            <h1>Информация о cookie:</h1>
            <%
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=UTF-8");
                if (cookies != null) {
                    for (int i =0; i < cookies.length; i++) {
                        out.println("Имя Cookie: " + cookies[i].getName() + ", Значение: " + cookies[i].getValue() + "<br/>");
                    }
                }
            %>
            <h1>Информация о сессии:</h1>
            <%
                out.println("Количество посещений: " + session.getAttribute("VisitCount") + "<br />");
                out.println("Время последнего посещения: " + session.getAttribute("LastVisitTime") + "<br />");
            %>
            <br><br>
            <a href="index.jsp">Назад на главуню</a>
        </div>
    </body>
</html>
