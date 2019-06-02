package pl.patryk.quiz.javaquiz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Autowired
    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, role FROM user WHERE username=?")
                .passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
           /* http
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    .antMatchers("/admin/index").permitAll()
                    .antMatchers("/api/**")
                    .hasAnyRole("ADMIN", "USER")
                    .antMatchers("/admin/**")
                    .hasRole("ADMIN")
                    .antMatchers("/login", "/js/**", "/css/**")
                    .permitAll()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/admin/questions", true)
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll();*/
        http
                .authorizeRequests()
                .antMatchers("/admin/index", "/image/**").permitAll()
                .anyRequest()
                .authenticated()
                .antMatchers("/api/**")
                .hasAnyRole("ADMIN", "USER")
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/login", "/js/**", "/css/**")
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/index", "/");
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}