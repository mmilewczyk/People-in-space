package com.agiklo.peopleinspaceapi.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("Mateusz")
                        .password("123")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/**").authenticated()
                .antMatchers(HttpMethod.DELETE,"/api/**").authenticated()
                .antMatchers("/console/**").authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()
                .csrf().disable();
    }

}

