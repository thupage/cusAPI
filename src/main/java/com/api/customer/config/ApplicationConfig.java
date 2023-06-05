package com.api.customer.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Application Config.
 * 
 * @author thutrang
 */
@Configuration
@ComponentScan("com.api.customer.repositories")
public class ApplicationConfig {

    /**
     * Create a MessageSource bean to read language documents.
     * 
     * @return The configured MessageSource object.
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/messages/messages","classpath:/application");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
