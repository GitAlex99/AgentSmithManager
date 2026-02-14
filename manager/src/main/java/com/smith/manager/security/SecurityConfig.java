    package com.smith.manager.security;
/*
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.Customizer;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.web.SecurityFilterChain;

       @Configuration
       @EnableWebSecurity
       public class SecurityConfig {

           private static final String ISSUER = "https://dev-t3aad5tt8o4dhzde.us.auth0.com/";

           @Bean
           SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
               http
                       .authorizeHttpRequests(auth -> auth
                               .requestMatchers("/public/**").permitAll()
                               .anyRequest().authenticated()
                       )
                       .oauth2Login(Customizer.withDefaults());
               return http.build();
           }
       }
*/