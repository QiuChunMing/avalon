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


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/seller/login").permitAll()
                .antMatchers("/seller/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/seller/login")
                .loginProcessingUrl("/authentication/form")
                .defaultSuccessUrl("/seller/order/list")
                .and()
        ;
        http.csrf().disable();
        //同源策略
        http.headers().frameOptions().sameOrigin();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //inMemoryAuthentication 从内存中获取
        auth.inMemoryAuthentication().passwordEncoder(
                new BCryptPasswordEncoder()).withUser("root").password(new BCryptPasswordEncoder()
                .encode("root")).roles("ADMIN");
    }
}
