package pl.coderslab.web.get.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

//Zadanie 2 - rozwiązywane z wykładowcą
//W projekcie stwórz servlet Get2, dostępny pod adresem /get2, który wyświetli listę przesłanych w zapytaniu (request) parametrów i ich wartość (niezależnie od liczby przesłanych parametrów). Wykorzystaj poniższy kod:
// Map<String, String[]> parameterMap = request.getParameterMap();
//
//Przykład:
//
//Dla adresu /get2?a=2&b=3&a=12

@WebServlet("/get2")
public class Get2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameters = req.getParameterMap();
        for(Map.Entry<String, String[]> e : parameters.entrySet()){
            resp.getWriter().println(String.format("%s : %s", e.getKey(), Arrays.toString(e.getValue())));
        }
        if(parameters.size() < 1) {
            resp.getWriter().println("Nie podano parametrów");
        }
    }
}
