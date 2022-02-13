package pl.coderslab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(urlPatterns ="/*", filterName = "SetUtf8Filter")
public class SetUtf8Filter implements Filter {
    private static final String ENCODING = "utf-8";
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Set encoding: " + ENCODING);
        request.setCharacterEncoding(ENCODING);
        chain.doFilter(request, response);
        response.setCharacterEncoding(ENCODING);
        response.setContentType("text/html");
    }
}
