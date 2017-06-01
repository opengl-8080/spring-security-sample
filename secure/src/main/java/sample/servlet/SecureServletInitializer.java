package sample.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SecureServletInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setInitParameter("backgroundColor", "#ccf1ff");
    }

    @Override public void contextDestroyed(ServletContextEvent sce) {}
}
