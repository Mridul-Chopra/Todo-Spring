package net.paxcel.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired DataSource dataSource;
	
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery(
			"select username, authority from authorities where username=?")
		.passwordEncoder(NoOpPasswordEncoder.getInstance()) ;
	}

 

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/img/**","/css/**","/js/**").permitAll()
				.antMatchers("/","/get","/delete","/add").hasRole("USER")
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/user", true)
				.failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")
				.permitAll()
				.and()
			.logout()
				.permitAll()
			.and()
				.csrf().disable();
		

		
	}

	
}
