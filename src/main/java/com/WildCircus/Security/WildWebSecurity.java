package com.WildCircus.Security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WildWebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/auth**").authenticated()
		//.antMatchers("/auth/admin**").hasAuthority()
		//.anyRequest().permitAll()
	.and()
		.exceptionHandling().accessDeniedPage("/errorAccessUnAuthorised")
	.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/auth").failureUrl("/error")
			.usernameParameter("username").passwordParameter("password")
			.and()
			.logout().invalidateHttpSession(true).logoutUrl("/logout")
			.logoutSuccessUrl("/login")
			.and()
			.csrf()
			.and()
			.sessionManagement().maximumSessions(1)
			.expiredUrl("/login");
}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
	    .withUser("user")
	        .password(encoder.encode("user"))
	        .roles("USER")
	        .and()
	    .withUser("admin")
	        .password(encoder.encode("Admin000_"))
	        .roles("ADMIN");
		
	}

}
