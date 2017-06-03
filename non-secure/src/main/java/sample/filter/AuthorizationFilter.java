package sample.filter;

import sample.domain.User;
import sample.servlet.LoginServlet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@WebFilter(value="/*", filterName="authorizationFilter")
public class AuthorizationFilter implements Filter {
    private static final Map<String, String> PATH_AUTHORITY_MAP;
    
    static {
        Map<String, String> map = new HashMap<>();
        
        map.put("/admin.jsp", "admin");
        
        PATH_AUTHORITY_MAP = Collections.unmodifiableMap(map);
    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        
        if (this.doesNotAccept(request)) {
            req.getRequestDispatcher("/WEB-INF/unauthorized.jsp").forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }
    
    private boolean doesNotAccept(HttpServletRequest request) {
        return this.needsToValidateAuthorization(request)
                && this.validatesLoginUserHasNoAuthority(request);
    }

    private boolean needsToValidateAuthorization(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return PATH_AUTHORITY_MAP.keySet().stream().anyMatch(uri::endsWith);
    }

    private boolean validatesLoginUserHasNoAuthority(HttpServletRequest request) {
        String requiredAuthority = this.getRequiredAuthority(request);
        User user = this.getLoginUser(request);
        return !user.hasAuthority(requiredAuthority);
    }
    
    private String getRequiredAuthority(HttpServletRequest request) {
        String uri = request.getRequestURI();
        
        return PATH_AUTHORITY_MAP.entrySet().stream()
                .filter(entry -> uri.endsWith(entry.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("required authority is not found."));
    }
    
    private User getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Object object = session.getAttribute(LoginServlet.SESSION_USER_KEY);
        
        if (object instanceof User) {
            return ((User) object);
        } else {
            throw new IllegalStateException("login user is not found.");
        }
    }

    @Override public void init(FilterConfig filterConfig) throws ServletException {}
    @Override public void destroy() {}
}
