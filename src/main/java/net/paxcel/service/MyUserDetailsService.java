package net.paxcel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.paxcel.dao.UserLoginRepository;
import net.paxcel.model.UserLoginModel;

public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired UserLoginRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserLoginModel> user  = userRepository.findByUsername(username);
		
		user.orElseThrow(()->new UsernameNotFoundException("not found : "+username) );
		
		//return user.map(MyUserLoginDetails::new).get();
		
		return null;
		
	}

}
