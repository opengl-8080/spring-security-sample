package sample.servlet;

import sample.domain.User;
import sample.domain.UserRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(LoginServlet.LOGIN_PATH)
public class LoginServlet extends HttpServlet {
    public static final String LOGIN_PATH = "/login";
    public static final String SESSION_USER_KEY = "loginUser";
    
    private static final String LOGIN_SUCCESS_PATH = "/";
    private static final String LOGIN_FAILURE_PATH = LOGIN_PATH + "?error";
    
    @Inject
    private UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            User user = this.login(username, password);
            this.saveUserIntoSession(req, user);
            this.redirect(req, resp, LOGIN_SUCCESS_PATH);
        } catch (LoginFailureException e) {
            this.redirect(req, resp, LOGIN_FAILURE_PATH);
        }
    }
    
    private User login(String username, String password) throws LoginFailureException {
        return this.userRepository
                .find(username)
                .filter(u -> u.hasSamePassword(password))
                .orElseThrow(LoginFailureException::new);
    }
    
    private void saveUserIntoSession(HttpServletRequest req, User user) {
        HttpSession session = req.getSession(true);
        session.setAttribute(SESSION_USER_KEY, user);
    }
    
    private void redirect(HttpServletRequest req, HttpServletResponse resp, String path) throws IOException {
        resp.sendRedirect(req.getContextPath() + path);
    }
}
