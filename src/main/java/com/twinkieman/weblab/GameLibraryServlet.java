package com.twinkieman.weblab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GameLibraryServlet", value = "/GameLibraryServlet")
public class GameLibraryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String user = request.getParameter("user");
        response.setContentType("text/html;charset=UTF-8");         // Задание типа содержимого для ответа (в том числе кодировки)
        PrintWriter out = response.getWriter();

        try {
            out.println("<html>");
            out.println("<head><title>Список игр</title></head>");
            out.println("<body>");
            out.println("<h1>Библиотека игрока " + (user != null ? user: "без имени") + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td><b>Разработчик</b></td><td><b>Название игры</b></td><td><b>Пройдена</b></td></tr>");
            out.println("<tr><td>CD PROJECT RED</td><td>Ведьмак 3</td><td>Да</td></tr>");
            out.println("<tr><td>Valve</td><td>Dota 2</td><td>Да</td></tr>");
            out.println("<tr><td>Gearbox software</td><td>Borderlands 2</td><td>Нет</td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void destroy() {
    }
}
