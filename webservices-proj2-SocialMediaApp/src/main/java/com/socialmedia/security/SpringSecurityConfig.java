package com.socialmedia.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(t ->t.anyRequest().authenticated());
		http.httpBasic(org.springframework.security.config.Customizer.withDefaults());
		http.csrf().disable();
		return http.build();
		
	}

}
