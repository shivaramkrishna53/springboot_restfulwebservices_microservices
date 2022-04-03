//package com.app.surveyquestorine.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
////	@Override
////	public void configure(AuthenticationManagerBuilder auth) throws Exception
////	{
////		auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance()).withUser("shiva").password("shiva1234").roles("user","admin").and().withUser("ram").password("ram1234").roles("user");
////		
////	}
////	
////	@Override
////	public void configure(HttpSecurity httpsec) throws Exception
////	{
////		 httpsec.httpBasic().and().authorizeRequests().antMatchers("/survey/**")
////	        .hasRole("user").antMatchers("/users/**").hasRole("user").antMatchers("/**").hasRole("admin");
////	}
////	
//	
//	 @Override
//	    protected void configure(AuthenticationManagerBuilder auth)
//	            throws Exception {
//	        auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance()).withUser("user1").password("secret1")
//	                .roles("USER").and().withUser("admin1").password("secret1")
//	                .roles("ADMIN");
//	    }
//
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http.httpBasic().and().authorizeRequests().antMatchers("/survey/**")
//	        .hasRole("USER").antMatchers("/users/**").hasRole("USER")
//	                .antMatchers("/**").hasRole("ADMIN").and().csrf().disable()
//	                .headers().frameOptions().disable();
//	    }
//	
//	
//	
//
//}
