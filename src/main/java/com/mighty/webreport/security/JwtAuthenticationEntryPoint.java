package com.mighty.webreport.security;

import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        String exception = (String)request.getAttribute("exception");

        //로그인 비밀번호 틀림
        if(exception == null) {
            setResponse(response, AuthCode.WRONG_PASSWORD);
        }
        //잘못된 타입의 토큰인 경우
        else if(exception.equals(AuthCode.WRONG_TYPE_TOKEN.getCode())) {
            setResponse(response, AuthCode.WRONG_TYPE_TOKEN);
        }
        //토큰 만료된 경우
        else if(exception.equals(AuthCode.EXPIRED_TOKEN.getCode())) {
            setResponse(response, AuthCode.EXPIRED_TOKEN);
        }
        //지원되지 않는 토큰인 경우
        else if(exception.equals(AuthCode.UNSUPPORTED_TOKEN.getCode())) {
            setResponse(response, AuthCode.UNSUPPORTED_TOKEN);
        }
        else {
            setResponse(response, AuthCode.ACCESS_DENIED);
        }
    }

    private void setResponse(HttpServletResponse response, AuthCode authCode) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("code",authCode.getCode());
        response.setHeader("message",authCode.getMessage());

    }
}
