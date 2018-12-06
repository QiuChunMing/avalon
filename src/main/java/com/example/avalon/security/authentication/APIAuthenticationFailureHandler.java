package com.example.avalon.security.authentication;

import com.example.avalon.web.APIResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("APIAuthenticationFailureHandler")
public class APIAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
   @Autowired
   private ObjectMapper objectMapper;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(300);
        apiResponse.setType(APIResponse.Type.SC_FORBIDDEN.getType());
        apiResponse.setMessage("用户名或密码错误");
        objectMapper.writeValue(response.getWriter(),apiResponse);
    }
}
