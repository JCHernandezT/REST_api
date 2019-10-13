package com.juan.rest.demo.demospringboot.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The configuration of Swagger mainly centers around the Docket bean. Swagger 2
 * is enabled through the @EnableSwagger2 annotation.
 * 
 * After the Docket bean is defined, its select() method returns an instance of
 * ApiSelectorBuilder, which provides a way to control the endpoints exposed by
 * Swagger.
 * 
 * Predicates for selection of RequestHandlers can be configured with the help
 * of RequestHandlerSelectors and PathSelectors. Using any() for both will make
 * documentation for your entire API available through Swagger.
 * 
 * This configuration is enough to integrate Swagger 2 into an existing Spring
 * Boot project. For other Spring projects, some additional tuning is required.
 * 
 * To verify that Springfox is working, you can visit the following URL in your
 * browser: http://localhost:8080/v2/api-docs
 * 
 * The result is a JSON response with a large number of key-value pairs, which
 * is not very human-readable. Fortunately, Swagger provides Swagger UI for this
 * purpose SEE POM for swagger-ui dependency.
 * 
 * Once swagger-ui dependency is added, you can test it in your browser by
 * visiting http://localhost:8080/your-app-root/swagger-ui.html in our case is
 * http://localhost:8080/swagger-ui.html
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	// @Bean
	// public Docket api() {
	// return new
	// Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
	// .paths(PathSelectors.any()).build();
	// }
	/**
	 * It is not always desirable to expose the documentation for your entire API.
	 * You can restrict Swagger’s response by passing parameters to the apis() and
	 * paths() methods of the Docket class.
	 * 
	 * As seen above, RequestHandlerSelectors allows using the any or none
	 * predicates, but can also be used to filter the API according to the base
	 * package, class annotation, and method annotations.
	 * 
	 * PathSelectors provides additional filtering with predicates which scan the
	 * request paths of your application. You can use any(), none(), regex(), or
	 * ant().
	 * 
	 * In the example below, we will instruct Swagger to include only controllers
	 * from a particular package, with specific paths, using the ant() predicate.
	 * 
	 */
	// @Bean
	// public Docket api() {
	// return new Docket(DocumentationType.SWAGGER_2).select()
	// .apis(RequestHandlerSelectors.basePackage("com.juan.rest.demo.demospringboot.controller"))
	// .paths(PathSelectors.ant("/aliens/*")).build();
	// }

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.juan.rest.demo.demospringboot.controller")).build()
				.apiInfo(apiInfo());
	}

	/**
	 * Swagger also provides some default values in its response which you can
	 * customize, such as “Api Documentation”, “Created by Contact Email”, “Apache
	 * 2.0”.
	 * 
	 * To change these values, you can use the apiInfo(ApiInfo apiInfo) method. The
	 * ApiInfo class that contains custom information about the API.
	 * 
	 */
	private ApiInfo apiInfo() {
		return new ApiInfo("My Aliens REST API", "This is an out of this world API.", "API TOS", "Terms of service",
				new Contact("Juan Camilo Hernández", "www.example.com", "maxdbjc@gmail.com"), "License of API",
				"API license URL", Collections.emptyList());
	}

}