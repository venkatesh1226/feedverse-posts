// package com.feedverse.posts;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// // import
// org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
// import org.springframework.security.web.SecurityFilterChain;

// import java.io.IOException;

// import static org.springframework.security.config.Customizer.withDefaults;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
// private static final Logger logger =
// LoggerFactory.getLogger(SecurityConfig.class);

// @Bean
// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// http
// .authorizeHttpRequests(authorize -> authorize
// .anyRequest().authenticated())
// .oauth2ResourceServer(oauth2 -> oauth2.jwt())
// .cors().and() // If you need CORS, configure here
// .csrf().disable(); // Often disabled for API endpoints

// return http.build();
// }

// }