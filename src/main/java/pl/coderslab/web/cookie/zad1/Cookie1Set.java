package pl.coderslab.web.cookie.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setCookie")
public class Cookie1Set extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("User", "CodersLab");
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        resp.addCookie(cookie);
        resp.getWriter().println("Ustawiono ciasteczko");
    }
}
