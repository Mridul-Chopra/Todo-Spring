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
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//    UserDetailsService userDetailsService;
	
	
//	@Autowired DataSource datasource;
//	
//	
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	
//    	
//    	//        auth.userDetailsService(userDetailsService);
//    	
//    	auth.jdbcAuthentication()
//    		.dataSource(datasource)
//    		.usersByUsernameQuery("Select username,password,enabled from users where username = ?")
//    		.authoritiesByUsernameQuery("Select username,authority from authorities where username = ?");
//    }
	
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
				.permitAll()
				.and()
			.logout()
				.permitAll()
			.and()
				.csrf().disable();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("123")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
