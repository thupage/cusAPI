package com.api.customer.security.utils;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.api.customer.config.AppProperties;
import com.api.customer.properties.AuthProperty;
import com.api.customer.repositories.UserRepository;
import com.api.customer.security.user.UserPrincipal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenUtil {

    // @Autowired
    // private UserRepository userRepository;

    // @Autowired
    // private AuthProperty authProperty;

    // public String extractUserName(String token) {
    //     return extractClaim(token, Claims::getSubject);
    // }

    // public Date extractExpiration(String token) {
    //     return extractClaim(token, Claims::getExpiration);
    // }

    // public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    //     Claims claims = this.extractAllClaims(token);
    //     return claimsResolver.apply(claims);
    // }

    // private Claims extractAllClaims(String token) {
    //     Claims claims = Jwts
    //             .parserBuilder()
    //             .setSigningKey(getSignKey())
    //             .build()
    //             .parseClaimsJws(token)
    //             .getBody();
    //     return claims;
    // }

    // private Boolean isTokenExpired(String token) {
    //     return extractExpiration(token).before(new Date());
    // }

    // public Boolean validateToken(String token) {
    //     final String email = extractUserName(token);
    //     return (userRepository.existByEmail(email)) && !isTokenExpired(token);
    // }

    // public String generateToken(Authentication authentication) {
    //     Map<String, Object> claims = new HashMap<>();
    //     return createToken(claims, authentication);
    // }

    // private String createToken(Map<String, Object> claims, Authentication authentication) {
    //     UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
    //     return Jwts.builder()
    //             .setClaims(claims)
    //             .setSubject(Integer.toString(userPrincipal.getUserId()))
    //             .setIssuedAt(new Date(System.currentTimeMillis()))
    //             .setExpiration(new Date(System.currentTimeMillis() + authProperty.getExpired()))
    //             .signWith(getSignKey(), SignatureAlgorithm.HS256)
    //             .compact();
    // }

    // private Key getSignKey() {
    //     byte[] keyBytes = Decoders.BASE64.decode(authProperty.getSecret());
    //     return Keys.hmacShaKeyFor(keyBytes);
    // }

    private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);

    private AppProperties appProperties;

    public TokenUtil(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public String createToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + appProperties.getAuth().getTokenExpirationMsec());

        return Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getUserId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, appProperties.getAuth().getTokenSecret())
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(appProperties.getAuth().getTokenSecret())
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(appProperties.getAuth().getTokenSecret()).parseClaimsJws(authToken);
            return true;
        }
        catch (MalformedJwtException ex) {
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
