package pl.coderslab.web.cookie.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCookie")
public class Cookie1Del extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for (Cookie c : cookies) {
                if ("User".equals(c.getName())) {
                    c.setMaxAge(0);
                    c.setPath("/");
                    resp.addCookie(c);
                    resp.getWriter().println("Usunięto ciasteczko");
                    return;
                }
            }
        }
        resp.getWriter().println("Brak ciastaczka o nazwie User");
    }
}
