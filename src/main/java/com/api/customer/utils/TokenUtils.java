package com.api.customer.utils;

import java.time.Instant;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import com.api.customer.model.response.TokenResponse;

/**
 * Token Utils.
 * 
 * @author thutrang
 */
@Component
public class TokenUtils {

    public TokenResponse gettoken(OAuth2AuthorizedClient auth2AuthorizedClient, OAuth2User user) {
        String name = user.getAttribute("name");
        String email = user.getAttribute("email");
        OAuth2AccessToken accessToken = auth2AuthorizedClient.getAccessToken();
        String token = accessToken.getTokenValue();
        Instant expiresAt = accessToken.getExpiresAt();
        Instant issuedAt = accessToken.getIssuedAt();
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setName(name);
        tokenResponse.setEmail(email);
        tokenResponse.setAccessToken(token);
        tokenResponse.setIssuedAt(issuedAt);
        tokenResponse.setExpiresAt(expiresAt);
        return tokenResponse;
    }
}
