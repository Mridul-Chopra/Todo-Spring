package net.paxcel.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserController {

	@RequestMapping("/user")
	public String user(HttpServletRequest request)
	{
		String username="";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken))
		{
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			username = userDetail.getUsername();
			request.getSession().setAttribute("username", username);
		}
		
		return "redirect:/";
	}
	
}
