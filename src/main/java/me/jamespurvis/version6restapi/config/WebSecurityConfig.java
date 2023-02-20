package me.jamespurvis.version6restapi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@Configuration
public class WebSecurityConfig {

    public String[] WHITELIST = {
            "/api/avatar/**",

    };
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, WHITELIST)
                .permitAll()
                .requestMatchers(HttpMethod.POST, WHITELIST)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        return http.build();
    }
}
