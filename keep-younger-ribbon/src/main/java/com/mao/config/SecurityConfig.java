package com.mao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsUtils;

/**
 * @author mao by 15:29 2020/3/20
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll();
        http.httpBasic()
                .disable().authorizeRequests()
                .antMatchers("/**")
                .permitAll()
                .and()
                .cors()
                .and()
                .csrf().disable();
    }

}