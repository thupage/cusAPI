package com.api.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
}
