package com.example.avalon.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UrlEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    @Autowired
    private ObjectMapper objectMapper;

    public UrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    /**
     * 发生AccessDeniedException后(即访问自身无权限访问的资源)已登录将会调用此方法，
     *
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

    }
}
