package com.example.avalon.passwordencode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
public class Encode {
    @Test
    public void encode() {
        String password = "123";
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        log.debug(encodedPassword);
        log.debug(""+new BCryptPasswordEncoder().matches(password,encodedPassword));

    }
}
