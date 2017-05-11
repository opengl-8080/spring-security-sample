package sample.servlet;

import sample.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public static final String SESSION_USER_KEY = "loginUser";
    private static final Map<String, User> userMap;
    
    static {
        Map<String, User> map = new HashMap<>();
        map.put("hoge", new User("hoge", "hoge"));
        
        userMap = Collections.unmodifiableMap(map);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        boolean failed = true;
        if (userMap.containsKey(username) && userMap.get(username).hasSamePassword(password)) {
            HttpSession session = req.getSession(true);
            session.setAttribute(SESSION_USER_KEY, userMap.get(username));
            failed = false;
        }

        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + (failed ? "/login?error" : "/"));
    }
}
