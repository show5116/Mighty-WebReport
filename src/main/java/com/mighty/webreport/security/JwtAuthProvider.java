package com.mighty.webreport.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.security.Key;

@RequiredArgsConstructor
@Component
@PropertySource("classpath:/security.properties")
public class JwtAuthProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthProvider.class);

    @Value("${jwt.secretKey}")
    private String atSecretKey;

    @Value("${jwt.expireMs}")
    private int expireMs;

    private Key getSignKey(){
        return Keys.hmacShaKeyFor(atSecretKey.getBytes(StandardCharsets.UTF_8));
    }


    public String createToken(Authentication authentication){

        AccountContext accountContext = (AccountContext)authentication.getPrincipal();
        Date now = new Date();
        Date expire = new Date(now.getTime() + expireMs);

        return Jwts.builder()
                .setSubject(accountContext.getId())
                .setIssuedAt(new Date())
                .setExpiration(expire)
                .signWith(getSignKey())
                .compact();
    }

    public String getUserId(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

}
