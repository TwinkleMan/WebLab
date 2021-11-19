package com.twinkieman.weblab.servlets;

import com.twinkieman.weblab.models.Game;
import com.twinkieman.weblab.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

@WebServlet(name = "GameLibraryServlet", value = "/GameLibraryServlet")
public class GameLibraryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String user = (String) request.getSession().getAttribute("user");
        User currUser = (User) request.getSession().getAttribute("currUser");
        ResourceBundle res = (ResourceBundle) request.getSession().getAttribute("res");

        int count = 0;

        Set<Game> games = currUser.getOwnedGames();
        List<Integer> progress = currUser.getGamesProgress();

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>");
            out.println(res.getString("title"));
            out.println("</title></head>");
            out.println("<body>");
            out.println("<h1>");
            out.println("<p align='center'>"+res.getString("table.name") + " " + (user != null ? user : res.getString("default.username")) + "</h1></p>");
            out.println("<table align='center' border='1'>");
            out.println("<tr><td><b>");
            out.println(res.getString("developer") + "</b></td><td><b>");
            out.println(res.getString("game.name") + "</b></td><td><b>");
            out.println(res.getString("completed") + "</b></td></tr>");
            for (Game game: games) {
                out.print("<tr><td>"+ game.getCompany().getName() +"</td><td>"+ game.getName() +"</td><td>");
                if (progress.get(count) == 1) out.println(res.getString("ans.yes") + "</td></tr>");
                else if (progress.get(count) == 0) out.println(res.getString("ans.no") + "</td></tr>");
                count++;
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            count = 0;
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
