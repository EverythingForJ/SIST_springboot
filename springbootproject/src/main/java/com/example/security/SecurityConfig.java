package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MemberService memberService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("security config...");
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/member/**").authenticated();
		
		http.formLogin().permitAll().defaultSuccessUrl("/welcome", true);
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		http.logout().permitAll().logoutUrl("/logout").invalidateHttpSession(true)
		.logoutSuccessUrl("/");
		
		http.userDetailsService(this.memberService);
		http.csrf().disable();
	}
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
