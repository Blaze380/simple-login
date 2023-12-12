package com.blazeland.simplelogin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsWebConfiguration implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**");
    }
    /**
     * CorsRegistry class, can make the application more secure by block or allow
     * specific CRUD methods, origins, and so on.
     */
}
