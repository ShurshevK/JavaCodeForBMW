package com.example.demo.SecurityConfig.security.jwt;

import java.util.*;
import java.util.stream.Collectors;

import com.auth0.jwt.JWT;
import com.example.demo.SecurityConfig.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

import static com.example.demo.SecurityConfig.domains.ERole.ROLE_ADMIN;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Value("${security.app.jwtSecret}")
    private String jwtSecret;

    @Value("${security.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${security.app.refreshExpirationDateInMs}")
    private int refreshExpirationDateInMs;


    public String generateToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        Map<String, Object> claims = new HashMap<>();



        List<String> roles = userPrincipal.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        if (roles.contains("ROLE_ADMIN")) {
            claims.put("isAdmin", true);
        }
        if (roles.contains("ROLE_USER")) {
            claims.put("isUser", true);
        }
        if (roles.contains("ROLE_MODERATOR")) {
            claims.put("isModerator", true);
        }



        return generateJwtToken(claims, userPrincipal.getUsername());
    }


    public String generateJwtToken(Map<String, Object> claims, String subject) {



        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

    }
    public String doGenerateRefreshToken(Map<String, Object> claims, String subject) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpirationDateInMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

    }



    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
