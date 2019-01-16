package com.example.avalon.security.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

@Slf4j
public class JsonUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    @Autowired
    private ObjectMapper objectMapper;

    public JsonUsernamePasswordAuthenticationFilter() {
        super(new AntPathRequestMatcher("api/admin/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String body = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        String username = null;
        String password = null;

        if (StringUtils.hasText(body)) {
            JsonNode root = objectMapper.readTree(body);
            username = root.get("username").asText();
            password = root.get("password").asText();
        }

        if (username == null) {
            username = "";
        }
        if (password==null) {
            password = "";
        }
        username = username.trim();

        log.debug("username:{}，password:{}", username, password);

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(username, password);

        //调用authenticationManager,会自动调用
        //usernamePasswordAuthenticationToken会交给默认的实现DaoAuthenticationProvider处理
        return this.getAuthenticationManager().authenticate(authenticationToken);
    }
}
