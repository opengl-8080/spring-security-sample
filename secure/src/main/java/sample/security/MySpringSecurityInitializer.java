package sample.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class MySpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public MySpringSecurityInitializer() {
        super(MySpringSecurityConfig.class);
    }
}
