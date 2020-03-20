package com.mao.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * web 安全配置
 * @author mao by 14:04 2020/3/18
 */
@Configuration
@EnableWebSecurity
public class KySecurityConfigurer extends WebSecurityConfigurerAdapter {

    private KyUserDetailService kyUserDetailService;

    @Autowired
    public void setKyUserDetailService(KyUserDetailService kyUserDetailService){
        this.kyUserDetailService = kyUserDetailService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**","/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest()
                .authenticated()
                .and().csrf().disable().cors();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(kyUserDetailService)
                .passwordEncoder(passwordEncoder());
    }
}