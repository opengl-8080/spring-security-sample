package sample.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/csrf")
public class CsrfTestServlet extends HttpServlet {
    
    private static final List<String> values = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        synchronized (values) {
            req.setAttribute("values", new ArrayList<>(values));
        }

        this.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("value");
        
        synchronized (values) {
            values.add(value);
        }

        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/csrf");
    }
    
    private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/csrf.jsp");
        dispatcher.forward(req, resp);
    }
}
