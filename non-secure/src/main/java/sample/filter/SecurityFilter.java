package sample.filter;

import sample.servlet.LoginServlet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        if (this.permitAll(req)) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = req.getSession(true);
            Object loginUser = session.getAttribute(LoginServlet.SESSION_USER_KEY);

            if (loginUser == null) {
                HttpServletResponse resp = (HttpServletResponse) response;
                String contextPath = req.getContextPath();
                resp.sendRedirect(contextPath + "/login");
            } else {
                chain.doFilter(request, response);
            }
        }
    }
    
    private boolean permitAll(HttpServletRequest req) {
        String servletPath = req.getServletPath();
        return "/login".equals(servletPath) || servletPath.startsWith("/css");
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {

    }
}
