package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ClubNautico2Application {

	public static void main(String[] args) {
		SpringApplication.run(ClubNautico2Application.class, args);
	}
	
	@Bean
	public WebMvcConfigurer Cors() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedOrigins("https://ruizgijon.ddns.net/").allowedMethods("GET","POST","PUT","DELETE","HEAD").allowCredentials(true);
			}
		};
	}
}
