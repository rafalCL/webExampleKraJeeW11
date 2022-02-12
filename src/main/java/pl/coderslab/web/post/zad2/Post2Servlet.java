package pl.coderslab.web.post.zad2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post2")
public class Post2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        final String acknowledgment = req.getParameter("acknowledgment");
        if (acknowledgment == null) {
            message = Censor.doCensor(message);
        }
        resp.getWriter().println(String.format(message));
    }
}
