package com.api.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.customer.model.request.LoginRequest;
import com.api.customer.model.response.AuthResponse;
import com.api.customer.security.user.GoogleOAuth2UserInfo;
import com.api.customer.security.utils.TokenUtil;
import com.nimbusds.oauth2.sdk.TokenResponse;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtil tokenUtil;

    @GetMapping(value = "/login")
    public String gettoken(Model model, @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient auth2AuthorizedClient,
            @AuthenticationPrincipal OAuth2User user) {
        String name = user.getAttribute("name");
        String email = user.getAttribute("email");
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        OAuth2AccessToken accessToken = auth2AuthorizedClient.getAccessToken();
        String token = accessToken.getTokenValue();
        model.addAttribute("token", token);
        return "index";
    }

    @PostMapping("/log")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenUtil.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

}
