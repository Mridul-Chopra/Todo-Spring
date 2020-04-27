package net.paxcel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.paxcel.dao.AuthoritiesRepository;
import net.paxcel.dao.UserRepository;
import net.paxcel.model.AuthoritiesModel;
import net.paxcel.model.UserModel;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired AuthoritiesRepository authority;
	@Autowired UserRepository user;
	
	@Override
	public String signUp(UserModel user) {

		AuthoritiesModel authorites  = new AuthoritiesModel();
		authorites.setUsername(user.getUsername());
		
		this.user.save(user);
		this.authority.save(authorites);
		
		return "Sign Up Successful";
	}

}
