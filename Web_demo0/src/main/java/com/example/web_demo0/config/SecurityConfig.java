package com.example.web_demo0.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN").and().withUser("mod").password("{noop}mod").roles("MODERATOR");
//    }

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().
                authorizeRequests()
                .antMatchers(HttpMethod.GET, "/rents/").hasAnyAuthority("ADMIN","LANDLORD", "TENANT")
                .antMatchers(HttpMethod.GET, "/rents/renter/").hasAnyAuthority("TENANT")
                .antMatchers(HttpMethod.POST, "/rents/renter/").hasAnyAuthority()
                .antMatchers(HttpMethod.POST, "/rents/").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/apartments/").hasAnyAuthority("ADMIN", "LANDLORD", "TENANT")
                .antMatchers(HttpMethod.POST, "/apartments/").hasAnyAuthority("LANDLORD")
                .antMatchers(HttpMethod.GET, "/apartments/owner/").hasAnyAuthority( "LANDLORD")
                .antMatchers(HttpMethod.POST, "/apartments/owner/**").hasAnyAuthority()
                .antMatchers(HttpMethod.GET, "/apartments/owner/**").hasAnyAuthority( "LANDLORD")
                .antMatchers(HttpMethod.GET, "/users/").hasAnyAuthority( "ADMIN","LANDLORD","TENANT")
                .antMatchers(HttpMethod.POST, "/users/").hasAnyAuthority( "MODERATOR")
                .and().csrf().disable().formLogin().disable();
    }
}
