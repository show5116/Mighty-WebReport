package com.mighty.webreport.security;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Component
@PropertySource("classpath:security.properties")
public class JwtAuthProvider {

    @Value("${jwt.secretKey}")
    private String atSecretKey;

    @PostConstruct
    protected void init(){
        atSecretKey = Base64.getEncoder().encodeToString(atSecretKey.getBytes());
    }

    private final UserDetailsService userDetailsService;

    public String createToken(String userId){

        Date date = new Date();

        final JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject("accesstoken")
                .setExpiration(new Date(date.getTime() + (1000L * 60 * 60 * 12)))
                .claim("userId",userId)
                .signWith(SignatureAlgorithm.HS256,atSecretKey);

        return builder.compact();
    }

    public String getUserId(String token) {
        return Jwts.parser().setSigningKey(atSecretKey).parseClaimsJws(token).getBody().getSubject();
    }

    @SuppressWarnings("unchecked")
    public Authentication getAuthentication(String token){
        Claims claims = Jwts.parser().setSigningKey(atSecretKey).parseClaimsJws(token).getBody();

        String userId = claims.get("userId", String.class);

        AccountContext accountContext = new AccountContext();
        return new UsernamePasswordAuthenticationToken(accountContext,"",accountContext.getAuthorities());

    }

    public String resolveToken(HttpServletRequest request){
        return request.getHeader("accesstoken");
    }

    public boolean validateToken(String token){
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(atSecretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e){
            return false;
        }
    }
}
