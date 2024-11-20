package com.ems.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	DataSource dataSource;
	@Override
	protected void configure(HttpSecurity http)throws Exception
	{
		http
		.authorizeRequests()
		.antMatchers("/delete**")
		.hasAnyRole("MANAGER")
		.anyRequest()
		//.permitAll()
		.authenticated()
		.and()
		//.httpBasic()
		.formLogin()
		.and()
		.exceptionHandling().accessDeniedPage("/WEB-INF/views/denied.jsp")
		.and()
		.csrf().disable();
		http
		.sessionManagement()
		.maximumSessions(1);
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)throws Exception
	{
		builder.inMemoryAuthentication()
		.withUser("durga").password(encoder.encode("durga@123")).roles("MANAGER")
		.and()
		.withUser("avinash").password(encoder.encode("avinash@123")).roles("USER");
		
//		builder.jdbcAuthentication()
//		.dataSource(dataSource)
//		.usersByUsernameQuery("select username,password,enabled from users where username=?")
//		.authoritiesByUsernameQuery("select username,authority from authorities where username=?")
//		.passwordEncoder(encoder);
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}