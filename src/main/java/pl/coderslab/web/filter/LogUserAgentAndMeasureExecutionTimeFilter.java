package pl.coderslab.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "LogUserAgentAndMeasureExecutionTimeFilter")
public class LogUserAgentAndMeasureExecutionTimeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String userAgent = ((HttpServletRequest) request).getHeader("User-Agent");
        System.out.println("User-Agent: " + userAgent);
        final long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        final long end = System.currentTimeMillis();
        System.out.println(String.format("Handling request took %sms", end - start));
    }
}
