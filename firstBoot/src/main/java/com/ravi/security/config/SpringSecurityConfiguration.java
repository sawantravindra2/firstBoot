package com.ravi.security.config;

import com.ravi.security.repo.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Value("${application.security.disabled:false}")
    private boolean securityDisabled;

    @Autowired
    private CustomJwtAuthenticationFilter customJwtAuthenticationFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if (securityDisabled) {
            http.csrf().disable()
                    .authorizeRequests().antMatchers("/helloadmin").hasRole("ADMIN")
                    //.antMatchers("/api/h2/emp/create").hasRole( "ROLE_ADMIN")
                    //.antMatchers("/api/h2/emp/getall").hasAnyRole( "ROLE_ADMIN" , "ROLE_USER")
                    .antMatchers("/api/auth/**", "/h2/**" /*, "/async/**", "/actuator/**", "/api.github.com/users/"*/).permitAll().anyRequest().authenticated()
                    .and().headers().frameOptions().sameOrigin()
                    .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).
                    and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                    and().addFilterBefore(customJwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        } else {
            http.csrf().disable().authorizeRequests().anyRequest().permitAll();
        }

    }

}
