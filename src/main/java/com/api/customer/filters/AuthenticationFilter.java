package com.api.customer.filters;

import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_EMPTY;
import static com.api.customer.constants.SuccessMessage.SUCCESS_MESSAGE;
import static com.api.customer.constants.ErrorMessages.ERROR_MESSAGE_IS_INVALID;
import java.io.IOException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.customer.utils.TokenUtils;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Authentication Filter.
 * 
 * @author thutrang
 */
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private MessageSource messageSource;

    private static Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        String currentUrl = request.getRequestURI();
        if (currentUrl.endsWith("/user/login")) {
            logger.error(messageSource.getMessage(SUCCESS_MESSAGE, new Object[] { "Get accessToken" }, Locale.ENGLISH));
            filterChain.doFilter(request, response);
            return;
        }
        String authHeader = getFromRequest(request);
        if (authHeader == null) {
            logger.error(messageSource.getMessage(ERROR_MESSAGE_IS_EMPTY, null, Locale.ENGLISH));
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.getWriter().write("{\"code\":\"bad_credentials\",\"message\":\"Invalid Token.\"}");
            return;
        }
        try {
            if (authHeader != null) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(null, null,
                        null);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch (ExpiredJwtException ex) {
            logger.error(messageSource.getMessage(ERROR_MESSAGE_IS_INVALID, new Object[] { "Token" }, Locale.ENGLISH));
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");
            response.getWriter().write("{\"code\":\"bad_credentials\",\"message\":\"Invalid Token.\"}");
            return;
        }
        filterChain.doFilter(request, response);
    }

    private String getFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7, authHeader.length());
        }
        return null;
    }
}
