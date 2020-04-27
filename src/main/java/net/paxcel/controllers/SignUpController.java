package net.paxcel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import net.paxcel.model.UserModel;
import net.paxcel.service.SignUpService;

@Controller
public class SignUpController {
	
	@Autowired SignUpService signUp;
	
	@GetMapping("/signup")
	public String signUp()
	{
		return "signup";
	}

	@PostMapping("/signup")
	public @ResponseBody String signUpAction(UserModel  user)
	{
		signUp.signUp(user);
		return "Sign Up Successful";
		
	}
}
