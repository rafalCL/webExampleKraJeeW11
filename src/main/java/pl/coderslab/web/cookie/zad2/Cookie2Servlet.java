package pl.coderslab.web.cookie.zad2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addToCookies")
public class Cookie2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        String value = req.getParameter("value");
        if (key == null || value == null) {
            resp.getWriter().println("Brak danych");
            return;
        }

        Cookie c = new Cookie(key, value);
        c.setPath("/");
        resp.addCookie(c);
        resp.getWriter().println(String.format("Dodano ciasteczko %s=%s", key, value));
    }
}
