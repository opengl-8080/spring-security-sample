package sample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@EnableWebSecurity
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {
    
    private static final String LOGIN_PAGE = "/login";
    private static final String INVALID_ACCESS_PAGE = "/WEB-INF/invalid-access.html";
    private static final String UNAUTHORIZED_PAGE = "/WEB-INF/unauthorized.html";
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(LOGIN_PAGE).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .exceptionHandling().accessDeniedHandler(this.accessDeniedHandler());
    }
    
    private AccessDeniedHandler accessDeniedHandler() {
        return new MyAccessDeniedHandler(LOGIN_PAGE, INVALID_ACCESS_PAGE, UNAUTHORIZED_PAGE);
    }
    
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("hoge").password("hoge").roles();
    }
}
