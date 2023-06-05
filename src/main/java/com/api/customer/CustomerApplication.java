package com.api.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.api.customer.config.AppProperties;

/**
 * Customer Application.
 * 
 * @ComponentScan to scan and search for components in the "com.api.customer.*"
 *                package.
 * 
 * @author thutrang
 */
@SpringBootApplication
@ComponentScan("com.api.customer.*")
@EnableConfigurationProperties(AppProperties.class)
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
