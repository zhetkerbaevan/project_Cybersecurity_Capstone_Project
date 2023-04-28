package com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.config;

import com.example.Cybersecurity_Capstone_Project_Zhetkerbaeva_Nazerke.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, proxyTargetClass = true)
public class SecConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UsersService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/404");

        http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "index.html").permitAll();
        http.formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("username_field")
                .passwordParameter("password_field")
                .loginProcessingUrl("/auth").permitAll()
                .failureUrl("/404")
                .defaultSuccessUrl("/");

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
    }

}
