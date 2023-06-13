package com.api.customer.model.response;

import java.time.Instant;

import lombok.Data;

/**
 * Token Response.
 * 
 * @author thutrang
 */
@Data
public class TokenResponse {
    private String name;
    private String email;
    private String accessToken;
    private Instant expiresAt;
    private Instant issuedAt;
}
