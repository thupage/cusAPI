package com.api.customer.model.response;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Token Response.
 * 
 * @author thutrang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {
    private String name;
    private String email;
    private String accessToken;
    private Instant expiresAt;
    private Instant issuedAt;
}
