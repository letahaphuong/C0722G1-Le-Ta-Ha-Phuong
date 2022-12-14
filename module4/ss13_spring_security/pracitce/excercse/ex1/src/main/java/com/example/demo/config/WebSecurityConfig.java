package com.example.demo.config;

import com.example.demo.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import java.beans.PersistenceDelegate;
import java.util.prefs.PreferenceChangeEvent;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService userDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
        authorizeHttpRequests().antMatchers("/home").permitAll().and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/customer", true).permitAll()

//                .and().authorizeHttpRequests().antMatchers("/provinces","/customer").hasRole("ADMIN")
                .and().authorizeHttpRequests().antMatchers( "/customer").hasAnyRole("USER","ADMIN")
                .and().authorizeHttpRequests().antMatchers( "/provinces").hasRole("ADMIN")


                .and()
                .authorizeRequests()
                .anyRequest().authenticated();

        http.authorizeRequests().and().rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(1 * 24 * 60 * 60);

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return inMemoryTokenRepository;
    }

}
