package net.paxcel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/login")

public class LoginController {
	


	
@RequestMapping(method = RequestMethod.GET)
public String login(Model model,@RequestParam(value = "error", required = false) String message,@RequestParam(value = "logout", required = false) String logout)
{	
	
	
	
	
	// display message if wrong message sent
	if(message!=null)
	{
		model.addAttribute("message","Wrong username or password"); 
	}
	if(logout!=null)
	{
		model.addAttribute("message","Logout Successful"); 
	}
	return "login";
}


}
