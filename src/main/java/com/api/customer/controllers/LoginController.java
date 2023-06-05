package com.api.customer.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/management")
public class LoginController {

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
}
