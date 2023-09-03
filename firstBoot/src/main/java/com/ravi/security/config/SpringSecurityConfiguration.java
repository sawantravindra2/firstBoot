package com.ravi.security.config;

import com.ravi.security.repo.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class SpringSecurityConfiguration {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Value("${application.security.enable:false}")
    private boolean securityEnabled;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public CustomJwtAuthenticationFilter customJwtAuthenticationFilter() {
        return new CustomJwtAuthenticationFilter();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        if (securityEnabled) {
            logger.info(" *********  Security is enabled ******* " + securityEnabled);
            http.csrf().disable()
                    .exceptionHandling()
                    .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().headers().frameOptions().sameOrigin()
                    .and().authorizeRequests().requestMatchers("/helloadmin").hasRole("ADMIN")
                    .and().authorizeRequests((authorize) -> authorize.requestMatchers("/api/auth/**", "/h2/**" /*, "/async/**", "/actuator/**", "/api.github.com/users/"*/).permitAll().
                            anyRequest().authenticated()
                    );
            http.addFilterBefore(customJwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        } else {
            logger.info(" *********  Security is disabled ******* ");

        }
        return http.build();
    }

}
