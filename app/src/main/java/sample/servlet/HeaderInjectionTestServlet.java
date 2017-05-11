package sample.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet("/header-injection")
public class HeaderInjectionTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.forward(req, resp);
    }
    
    private static final Pattern CR_OR_LF = Pattern.compile("\\r|\\n");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String headerName = req.getParameter("headerName");
        String headerValue = req.getParameter("headerValue");

        boolean removeLineSeparator = "true".equals(req.getParameter("removeLineSeparator"));
        if (removeLineSeparator) {
            headerName = CR_OR_LF.matcher(headerName).replaceAll("");
            headerValue = CR_OR_LF.matcher(headerValue).replaceAll("");
            System.out.println("headerName=" + headerName);
            System.out.println("headerValue=" + headerValue);
        }

        resp.setHeader(headerName, headerValue);

        this.forward(req, resp);
    }
    
    private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/header-injection.jsp");
        dispatcher.forward(req, resp);
    }
}
