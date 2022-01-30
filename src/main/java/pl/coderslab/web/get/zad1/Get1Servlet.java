package pl.coderslab.web.get.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Zadanie 1 - rozwiązywane z wykładowcą
//W projekcie stwórz servlet Get1, dostępny pod adresem /get1, który pobierze z adresu dwa parametry: start i end .
//Po uruchomieniu aplikacji na serwerze, w przeglądarce wyświetlą się wszystkie liczby od start do end. (dla uproszczenia załóżmy, że będziemy przesyłać tylko liczby całkowite). Jeżeli zmienne nie są przesłane, to strona ma wypisać informację BRAK.
//Przykładowy adres wywołania: http://localhost:8080/get1?start=1&end=12;

@WebServlet("/get1")
public class Get1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        String startStr = req.getParameter("start");
        String endStr = req.getParameter("end");

        try {
            int start = Integer.valueOf(startStr);
            int end = Integer.valueOf(endStr);
            for (int i=start; i<=end;i++){
                resp.getWriter().println(i);
            }
        } catch (NumberFormatException e) {
            resp.getWriter().println("Nieprawidłowe dane w requeście. Podaj liczby w parametrach start i end.");
            resp.getWriter().println(String.format("Podano: start=%s, end=%s", startStr, endStr));
        }
    }
}
