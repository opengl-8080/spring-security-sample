package sample.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAccessDeniedHandler implements AccessDeniedHandler {
    
    private final String loginPage;
    private final String invalidAccessPage;
    private final String unauthorizedPage;

    public MyAccessDeniedHandler(String loginPage, String invalidAccessPage, String unauthorizedPage) {
        this.loginPage = loginPage;
        this.invalidAccessPage = invalidAccessPage;
        this.unauthorizedPage = unauthorizedPage;
    }

    @Override
    public void handle(HttpServletRequest req, HttpServletResponse resp, AccessDeniedException e) throws IOException, ServletException {
        if (resp.isCommitted()) {
            return;
        }
        
        if (e instanceof MissingCsrfTokenException) {
            DefaultRedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
            redirectStrategy.sendRedirect(req, resp, this.loginPage);
        } else if (e instanceof InvalidCsrfTokenException) {
            this.forward(req, resp, this.invalidAccessPage);
        } else {
            this.forward(req, resp, this.unauthorizedPage);
        }
    }
    
    private void forward(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
        dispatcher.forward(req, resp);
    }
}
