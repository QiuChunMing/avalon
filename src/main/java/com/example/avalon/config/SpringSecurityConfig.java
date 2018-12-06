package com.example.avalon.config;

import com.example.avalon.security.authentication.APIAuthenticationFailureHandler;
import com.example.avalon.security.authentication.APIAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private APIAuthenticationSuccessHandler apiAuthenticationSuccessHandler;

    @Autowired
    private APIAuthenticationFailureHandler apiAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/login").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/add").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(apiAuthenticationSuccessHandler)
                .failureHandler(apiAuthenticationFailureHandler);
        http.csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //inMemoryAuthentication 从内存中获取
        auth.inMemoryAuthentication().passwordEncoder(
                new BCryptPasswordEncoder()).withUser("root").password(new BCryptPasswordEncoder()
                .encode("root")).roles("ADMIN");

    }
}
