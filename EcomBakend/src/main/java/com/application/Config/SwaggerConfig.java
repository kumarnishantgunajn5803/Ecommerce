package com.application.Config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

 
public class SwaggerConfig {
	public static final String Authorization_Header ="Authorization";

	 private ApiKey apiKeys() {
		 return new ApiKey("JWT", Authorization_Header, "header");
	 }
	 
	 private List<SecurityContext> securityContexts(){
		 return Arrays.asList(SecurityContext.builder().securityReferences(securityReferences()).build());
	 }
	 private List<SecurityReference> securityReferences(){
		 AuthorizationScope scope = new AuthorizationScope("global", "accessEvrything");
		 return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] {scope} ));
	 }
   
 
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
		         .securityContexts(securityContexts())
		         .securitySchemes(Arrays.asList(apiKeys()))
				.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getInfo() {
	 
		return new ApiInfo("Ecommerce Backend Application", null, null, null, null, null, null);
	}
}
