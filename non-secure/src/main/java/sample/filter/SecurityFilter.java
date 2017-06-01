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
        
        if (this.satisfiesToReject(req)) {
            this.redirectToLoginPage(req, (HttpServletResponse) response);
            return;
        }
        
        chain.doFilter(request, response);
    }
    
    private boolean satisfiesToReject(HttpServletRequest request) {
        return !this.permitsRequestedPath(request) && !this.isLoggedIn(request);
    }
    
    private boolean permitsRequestedPath(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        return LoginServlet.LOGIN_PATH.equals(servletPath) || servletPath.startsWith("/css");
    }
    
    private boolean isLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        return session.getAttribute(LoginServlet.SESSION_USER_KEY) != null;
    }
    
    private void redirectToLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + LoginServlet.LOGIN_PATH);
    }
    
    @Override public void init(FilterConfig filterConfig) throws ServletException {}
    @Override public void destroy() {}
}
