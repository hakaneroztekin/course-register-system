package com.codethecode.courseregistersystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/api/swagger-resources/**",
            "/api/swagger-resource/**",
            "/api/swagger-ui.html",
            "/api/swagger",
            "/api/v2/api-docs",
            "/api/webjars/**",
            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-resource/**",
            "/swagger-ui.html",
            "/swagger",
            "/v2/api-docs",
            "/webjars/**",
            // permit all methods
            "swagger/**",
            "/**",
            "/admin/**",
            "/student/**",
            "/teacher/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      //  http.authorizeRequests()
        //        .antMatchers(AUTH_WHITELIST).permitAll();
        http.authorizeRequests().antMatchers("/").permitAll();
        http.csrf().disable();
//                .antMatchers("/**/*").denyAll();
    }

//    @Override
//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {}


}