package com.visith.labappointmentsystem.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Add the origin(s) from which you want to allow requests
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Add the HTTP method(s) you want to allow
                .allowedHeaders("*"); // Add the header(s) you want to allow
    }
}
