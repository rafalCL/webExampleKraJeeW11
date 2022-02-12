package pl.coderslab.web.session.zad2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session2")
public class Session2 extends HttpServlet {
    private static final String HTML_TEMPLATE = "<html>" +
            "<body>" +
            "<form method='post'>" +
            "Ocena: <input type='number' name='ocena'>" +
            "<input type='submit'>" +
            "</form>" +
            "Oceny: %s. avg=%s" +
            "</body>" +
            "</html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().println(String.format(HTML_TEMPLATE, "", ""));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String gradeStr = req.getParameter("ocena");
        Integer grade = Integer.valueOf(gradeStr);

        HttpSession session = req.getSession();
        List<Integer> grades = (List<Integer>) session.getAttribute("grades");

        if (grades == null) {
            grades = new ArrayList<>();
        }

        grades.add(grade);
        session.setAttribute("grades", grades);

        Double avg = null;

        if (grades.size() > 0) {
            int sum = 0;
            for (Integer i : grades) {
                sum += i;
            }
            avg = (1.0 * sum) / grades.size();
        }

        resp.getWriter().println(String.format(HTML_TEMPLATE, grades.toString(), avg));
    }
}
