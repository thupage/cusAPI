package com.api.customer.utils;

import java.io.IOException;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.client.ClientAuthorizationException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GoogleUtils {

    @Autowired
    private Environment env;

    public String getToken(final String code) throws ClientAuthorizationException, IOException {
        String link = env.getProperty("spring.security.oauth2.client.registration.token-uri");

        final String response = Request.Post(link)
                .bodyForm(Form.form()
                        .add("client_id",
                                env.getProperty("spring.security.oauth2.client.registration.google.client-id"))
                        .add("client_secret",
                                env.getProperty("spring.security.oauth2.client.registration.google.client-secret"))
                        .add("redirect_uri", env.getProperty("google.redirect.uri")).add("code", code)
                        .add("grant_type", "authorization_code").build())
                .execute().returnContent().asString();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response).get("access_token");
        return node.textValue();
    }
}
