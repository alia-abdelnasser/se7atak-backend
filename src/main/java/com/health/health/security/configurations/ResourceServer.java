package com.health.health.security.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by qrdz4162 on 3/26/2017.
 */
//
@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/oauth/**",
                        "/mappings/**",
                        "/env/**",
                        "/health/**",
                        "/metrics/**",
                        "/trace/**",
                        "/dump/**",
                        "/beans/**",
                        "/info/**",
                        "/autoconfig/**",
                        "/configprops/**",
                        "/logfile/**",
                        "/jolokia/**")
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
