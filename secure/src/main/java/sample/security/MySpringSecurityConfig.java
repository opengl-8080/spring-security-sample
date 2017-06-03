package sample.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@EnableWebSecurity
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {
    
    private static final String LOGIN_PAGE = "/login";
    private static final String DEFAULT_SUCCESS_PATH = "/home";
    private static final String INVALID_ACCESS_PAGE = "/WEB-INF/invalid-access.jsp";
    private static final String UNAUTHORIZED_PAGE = "/WEB-INF/unauthorized.jsp";
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(LOGIN_PAGE).permitAll()
                .antMatchers("/css/**/*.css").permitAll()
                .antMatchers("/admin.jsp").hasAuthority("admin")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage(LOGIN_PAGE)
                .defaultSuccessUrl(DEFAULT_SUCCESS_PATH, true)
                .and()
            .exceptionHandling()
                .accessDeniedHandler(this.accessDeniedHandler())
                .and()
            .csrf()
                .csrfTokenRepository(this.csrfTokenRepository());
    }
    
    private AccessDeniedHandler accessDeniedHandler() {
        return new MyAccessDeniedHandler(LOGIN_PAGE, INVALID_ACCESS_PAGE, UNAUTHORIZED_PAGE);
    }
    
    private CsrfTokenRepository csrfTokenRepository() {
        return new CookieCsrfTokenRepository();
    }
    
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("hoge").password("hoge").authorities("user").and()
                .withUser("admin").password("admin").authorities("admin");
    }
}
