package com.example.fooddelivery;

import com.example.fooddelivery.exception.ExceptionInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// Main class
@SpringBootApplication
@EnableSwagger2
@Import(ExceptionInterceptor.class)
public class FooddeliveryApplication {

	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(FooddeliveryApplication.class, args);
	}

	/**
	 * Bean definition for Swagger documentation.
	 * @return
	 */
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.fooddelivery.controller")).build();
	}

}
