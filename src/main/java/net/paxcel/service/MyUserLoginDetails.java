package net.paxcel.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserLoginDetails implements UserDetails {

	
	String username;
	String password;
	Boolean isAccountNonExpired;
	Boolean enabled;
	Boolean isCredentialsNonExpired;
	Boolean isAccountNonLocked;
	List<GrantedAuthority> authorityList;
	
	
	public MyUserLoginDetails(String username, String password , Boolean enabled)
	{
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		
		this.isAccountNonExpired = true;
		this.isCredentialsNonExpired = true;
		this.isAccountNonLocked = true;
		
		this.authorityList.add(new SimpleGrantedAuthority("USER"));
	}
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorityList;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {

		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {

		return enabled;
	}

}
