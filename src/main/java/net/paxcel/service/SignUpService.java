package net.paxcel.service;

import org.springframework.stereotype.Service;

import net.paxcel.model.UserModel;

@Service
public interface SignUpService {

	public String signUp(UserModel user);
}
