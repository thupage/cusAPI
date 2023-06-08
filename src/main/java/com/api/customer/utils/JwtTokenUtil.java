package com.api.customer.utils;

import java.io.Serializable;
import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.api.customer.entities.UserEntity;
import com.api.customer.properties.AuthProperty;
import com.api.customer.repositories.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil implements Serializable {

    @Autowired
    private AuthProperty authProperty;

    @Autowired
    private UserRepository userRepository;

    public String getUsernameFromToken(String accesstoken) {
        return getClaimFromToken(accesstoken, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String accesstoken) {
        return getClaimFromToken(accesstoken, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String accesstoken, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(accesstoken);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(authProperty.getSecret());
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Boolean isTokenExpired(String accesstoken) {
        final Date expiration = getExpirationDateFromToken(accesstoken);
        return expiration.before(new Date());
    }

    public String generateToken(UserEntity user) {
        return doGenerateToken(user.getEmail());
    }

    private String doGenerateToken(String subject) {
        Claims claims = Jwts.claims().setSubject(subject);
        claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + authProperty.getExpired()))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Boolean validateToken(String accesstoken, UserDetails userDetails) {
        final String username = getUsernameFromToken(accesstoken);
        return (username.equals(userDetails.getUsername())
                && !isTokenExpired(accesstoken));
    }

    public String checkValidUsername(String email) {
        UserEntity userInfo = userRepository.findByEmail(email);
        String jwtResponse = generateToken(userInfo);
        return jwtResponse;
    }

}
