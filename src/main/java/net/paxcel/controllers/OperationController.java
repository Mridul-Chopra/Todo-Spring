package net.paxcel.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.paxcel.service.OperationService;

@RestController
public class OperationController {

	@Autowired OperationService operation;
	
	
	@PostMapping("/delete" )
	public String delete(@RequestBody String payload ,HttpServletRequest request)
	{
		String username = (String) request.getSession().getAttribute("username");
		operation.delete(payload , username);
		return "Deleted";
	}
	
	@PostMapping("/add")
	public String add(@RequestBody String payload , HttpServletRequest request)
	{
		String username = (String) request.getSession().getAttribute("username");
		operation.addItem(username, payload);
		
		//		test.testAdd(1,"Mridul");
		
		return "add called";
	}
	
	@GetMapping("/get")
	public Map<String,Boolean> get(HttpServletRequest request)
	{
		String username = (String) request.getSession().getAttribute("username");
		return operation.getTodos(username);
	}
	

}
