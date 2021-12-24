package com.example.web_demo0.config;

import com.example.web_demo0.model.enums.Role;
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
                .antMatchers(HttpMethod.GET, "/rents").hasAnyAuthority(Role.ADMIN.toString(),
                        Role.LANDLORD.toString(), Role.TENANT.toString())
                .antMatchers(HttpMethod.GET, "/rents/renter").hasAnyAuthority(Role.TENANT.toString())
                .antMatchers(HttpMethod.POST, "/rents/renter").hasAnyAuthority()
                .antMatchers(HttpMethod.POST, "/rents").hasAnyAuthority(Role.ADMIN.toString())
                .antMatchers(HttpMethod.GET, "/apartments").hasAnyAuthority(Role.ADMIN.toString(),
                        Role.LANDLORD.toString(), Role.TENANT.toString())
                .antMatchers(HttpMethod.POST, "/apartments").hasAnyAuthority(Role.LANDLORD.toString())
                .antMatchers(HttpMethod.GET, "/apartments/owner").hasAnyAuthority( Role.LANDLORD.toString())
                .antMatchers(HttpMethod.POST, "/apartments/owner/**").hasAnyAuthority()
                .antMatchers(HttpMethod.GET, "/apartments/owner/**").hasAnyAuthority( Role.LANDLORD.toString())
                .antMatchers(HttpMethod.GET, "/users").hasAnyAuthority( Role.ADMIN.toString(),
                        Role.LANDLORD.toString(),Role.TENANT.toString())
                .antMatchers(HttpMethod.POST, "/users").hasAnyAuthority( "MODERATOR")
                .and().csrf().disable().formLogin().disable();
    }
}
