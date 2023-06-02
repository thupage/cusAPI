package com.api.customer.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.ClientAuthorizationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.customer.utils.GoogleUtils;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private GoogleUtils googleUtils;

    @RequestMapping("/login-google")
    public String loginGoogle(HttpServletRequest request) throws ClientAuthorizationException, IOException {
        String code = request.getParameter("code");

        if (code == null || code.isEmpty()) {
            return "redirect:/login?google=error";
        }

        googleUtils.getToken(code);
        return "redirect:/user";
    }
}
