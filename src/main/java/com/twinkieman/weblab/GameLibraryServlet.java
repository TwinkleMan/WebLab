package com.twinkieman.weblab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "GameLibraryServlet", value = "/GameLibraryServlet")
public class GameLibraryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String user = request.getParameter("user");
        String language = request.getParameter("lang");
        if (language == null) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "Ожидался параметр lang");
            return;
        }
        if(!"en".equalsIgnoreCase(language) && !"ru".equalsIgnoreCase(language)) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, "Параметр lang может принимать значения en или ru");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");         // Задание типа содержимого для ответа (в том числе кодировки)
        ResourceBundle res = ResourceBundle.getBundle(
                "GameLibrary", "en".equalsIgnoreCase(language) ? Locale.ENGLISH : Locale.getDefault());

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>");
            out.println(res.getString("title"));
            out.println("</title></head>");
            out.println("<body>");
            out.println("<h1>");
            out.println(res.getString("table.name") + " " + (user != null ? user : res.getString("default.username")) + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td><b>");
            out.println(res.getString("developer") + "</b></td><td><b>");
            out.println(res.getString("game.name") + "</b></td><td><b>");
            out.println(res.getString("completed") + "</b></td></tr>");
            out.println("<tr><td>CD PROJECT RED</td><td>The witcher 3</td><td>" + res.getString("ans.yes") + "</td></tr>");
            out.println("<tr><td>Valve</td><td>Dota 2</td><td>" + res.getString("ans.yes") + "</td></tr>");
            out.println("<tr><td>Gearbox software</td><td>Borderlands 2</td><td>" + res.getString("ans.no") + "</td></tr>");
            out.println("<tr><td>HotFoodGames</td><td>Drunken samurai</td><td>" + res.getString("ans.no") + "</td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        processRequest(req, resp);
    }

    @Override
    public void destroy() {
    }
}
