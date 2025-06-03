package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PostGres2Application implements  WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(PostGres2Application.class, args);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**")
	            .allowedOrigins("http://localhost:4200") // Specify the allowed origin (your frontend URL)
	            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Specify the allowed HTTP methods
	            .allowedHeaders("*") // Allow any headers
	            .allowCredentials(true) // Allows credentials such as cookies or HTTP authentication
	            .maxAge(3600); // Cache pre-flight response for 1 hour (in seconds)
	}


}
