package com.api.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.customer.utils.TokenUtils;

/**
 * Login Controller.
 * 
 * @author thutrang
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private TokenUtils tokenUtils;

    @GetMapping(value = "/login")
    public ResponseEntity<?> authenticate(
            @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient auth2AuthorizedClient,
            @AuthenticationPrincipal OAuth2User user) {
        return ResponseEntity.ok(tokenUtils.gettoken(auth2AuthorizedClient, user));
    }
}
