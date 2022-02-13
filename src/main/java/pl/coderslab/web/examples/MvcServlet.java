package pl.coderslab.web.examples;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvcexample")
public class MvcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User("Pumba");
        req.setAttribute("user", user);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/mvcExample.jsp")
                .forward(req,resp);
    }
}
