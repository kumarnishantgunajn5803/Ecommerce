package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@OpenAPIDefinition( 
	    servers = {
	       @Server(url = "/", description = "Default Server URL")
	    }
	)
 


@SpringBootApplication
 
 
public class EcomBakendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomBakendApplication.class, args);
	}

}
