package com.example.avalon.security;

import com.example.avalon.web.APIResponse;
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
     * 发生AccessDeniedException后已登录将会调用此方法，即访问自身无权限访问的资源
     *
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(CONTENT_TYPE);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        apiResponse.setType(APIResponse.Type.SC_FORBIDDEN.getType());
        objectMapper.writeValue(response.getWriter(), apiResponse);
        super.commence(request, response, authException);
    }
}
