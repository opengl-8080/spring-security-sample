package sample.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class NonSecureServletInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setInitParameter("backgroundColor", "#ffccd5");
    }

    @Override public void contextDestroyed(ServletContextEvent sce) {}
}
