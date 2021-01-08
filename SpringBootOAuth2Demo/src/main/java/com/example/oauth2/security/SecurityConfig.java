package com.example.oauth2.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import static com.example.oauth2.security.SocialType.FACEBOOK;
import static com.example.oauth2.security.SocialType.GOOGLE;
import static com.example.oauth2.security.SocialType.KAKAO;
import static com.example.oauth2.security.SocialType.NAVER;

import com.example.service.CustomOAuth2UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws java.lang.Exception {
		http.authorizeRequests()
				.antMatchers("/", "/oauth2/**", "/login/**", "/webjars/**", "/images/**", "/console/**", "/favicon.ico/**")
				.permitAll().antMatchers("/facebook").hasAuthority(FACEBOOK.getRoleType()).antMatchers("/google")
				.hasAuthority(GOOGLE.getRoleType()).antMatchers("/kakao").hasAuthority(KAKAO.getRoleType())
				.antMatchers("/naver").hasAuthority(NAVER.getRoleType()).anyRequest().authenticated().and()
				.oauth2Login().userInfoEndpoint().userService(new CustomOAuth2UserService()).and()
				.defaultSuccessUrl("/loginSuccess").failureUrl("/loginFailure").and().exceptionHandling()
				.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
		http.logout().logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/login");
	}
}
