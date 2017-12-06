package com.cgi.ferme.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	  @Autowired
	   private AccessDeniedHandler accessDeniedHandler;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.csrf().disable()
        .authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/console/**").permitAll()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/js/**").permitAll()
				.antMatchers("/admin/**").hasAnyRole("ADMIN")
				.antMatchers("/user/**").hasAnyRole("USER")
				.antMatchers("/offline.manifest").permitAll()
				
				.anyRequest().authenticated()
        .and()
        .formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
        .logout()
				.permitAll()
				.and()
        .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
		 
	http.headers().frameOptions().disable();
}
		

	// create two users, admin and user
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("12345").roles("USER")
                .and()
                .withUser("admin").password("12345").roles("ADMIN");
    }	
	
   
}
