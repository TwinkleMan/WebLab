package com.twinkieman.weblab.servlets;

import com.twinkieman.weblab.DatabaseErrors;
import com.twinkieman.weblab.dao.UserDAOImpl;
import com.twinkieman.weblab.models.Game;
import com.twinkieman.weblab.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

@WebServlet(name = "LangUserSet", value = "/LangUserSet")
public class LangUserSet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, DatabaseErrors.EntityManagerFactoryError {
        String language = request.getParameter("lang");
        String Username = request.getParameter("user");

        ResourceBundle res;
        if (language == null) {
            res = ResourceBundle.getBundle("GameLibrary");
        }
        else if ((!language.equalsIgnoreCase("en")) && (!language.equalsIgnoreCase("ru"))) {
            res = ResourceBundle.getBundle("GameLibrary");
        } else {
            res = ResourceBundle.getBundle("GameLibrary", "en".equalsIgnoreCase(request.getParameter("lang")) ? Locale.ENGLISH : Locale.getDefault());
        }

        request.getSession().setAttribute("res", res);
        request.getSession().setAttribute("lang", language);
        request.getSession().setAttribute("user", Username);

        User user;
        List<User> temp = new UserDAOImpl().searchByLogin(Username);
        if (temp.size() != 0) {
            user = temp.get(0);
            request.getSession().setAttribute("currUser", user);
        } else throw new IllegalArgumentException("There is no such user!");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>");
            out.println("Success!");
            out.println("</title></head>");
            out.println("<html>");
            out.println("<body>");
            out.println("<p align='center'>Successfully set '" + language + "' as language and selected '" + Username + "' as user." + "<br></p>");
            out.println("<p align='center'><a href=\"GameLibraryServlet\">To game list</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request,response);
        } catch (DatabaseErrors.EntityManagerFactoryError e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request,response);
        } catch (DatabaseErrors.EntityManagerFactoryError e) {
            e.printStackTrace();
        }
    }
}
