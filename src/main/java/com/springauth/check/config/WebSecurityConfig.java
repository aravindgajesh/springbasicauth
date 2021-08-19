package com.springauth.check.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("aravind").password("password").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("iniya").password("password2").roles("USER");
	}

//	BASIC AUTH - FOR ALL API
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
//	}

//	BASIC AUTH - FOR SPECIFIC URL
	// works for http://localhost:8080/rest/other/othergreeting
	// asks credential for http://localhost:8080/rest/auth/greeting
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests().antMatchers("/rest/auth/**").fullyAuthenticated().and().httpBasic();
//	}

//	BASIC AUTH - FOR ROLES
	// http://localhost:8080/rest/auth/greeting works with USER role user
	
	// http://localhost:8080/rest/other/othergreeting works with USER or ADMIN, but
	// authentcation with any username/pass is required
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/rest/auth/**").hasRole("USER").anyRequest().fullyAuthenticated().and()
				.httpBasic();
	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(web);
//	}

}
