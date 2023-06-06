package com.api.customer.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "app.token")
@Component
public class AuthProperty {
    private int expired;
    private String secret;
}
