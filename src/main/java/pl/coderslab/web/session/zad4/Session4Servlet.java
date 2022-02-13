package pl.coderslab.web.session.zad4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session4")
public class Session4Servlet extends HttpServlet {
    private static final String ROW_TEMPLATE = "<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        List<CartItem> cart = (List<CartItem>) req.getSession().getAttribute("cart");
        if (cart == null) {
            resp.getWriter().println("No data");
            return;
        }

        String html = "<html><body><table border='1'>";

        double sum = 0.;
        for (CartItem ci : cart) {
            double priceForItem = ci.price * ci.quantity;
            sum += priceForItem;
            html += String.format(ROW_TEMPLATE, ci.name, ci.quantity, ci.price, priceForItem);
        }
        html += String.format(ROW_TEMPLATE, "", "", "Suma:", sum);
        html += "</table></body></html>";

        resp.getWriter().println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String product = req.getParameter("product");
        final String quantityStr = req.getParameter("quantity");
        final String priceStr = req.getParameter("price");

        if (product == null || product.length() < 1) {
            resp.getWriter().println("Invalid product");
            return;
        }

        try {
            double quantity = Double.parseDouble(quantityStr);
            double price = Double.parseDouble(priceStr);

            final HttpSession session = req.getSession();

            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
            }

            cart.add(new CartItem(product, quantity, price));
            session.setAttribute("cart", cart);
            resp.getWriter().println("Product added");
        } catch (NumberFormatException e) {
            resp.getWriter().println("Invalid data");
        }
    }
}
