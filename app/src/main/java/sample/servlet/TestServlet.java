package sample.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("session.class=" + session.getClass());
        String sessionId = session.getId();
        System.out.println("sessionId=" + sessionId);
        String changeSessionId = req.changeSessionId();
        System.out.println("changeSessionId="  + changeSessionId);
    }
}
