package com.furkansahin.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
	info = @Info(
		title = "Accounts microservice REST API Documentation",
		description = "SahinBank Accounts microservices REST API Documentation",
		version = "v1.0",
		contact = @Contact(
			name = "Furkan Sahin",
			email = "furkann3371@gmail.com",
			url = "https://google.com"
		),
		license = @License(
			name = "Apache 2.0",
			url = "https://google.com"
		)
	),
	externalDocs = @ExternalDocumentation(
		description = "SahinBank Accounts microservice REST API Documentation",
		url = "https://google.com" 
	)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
