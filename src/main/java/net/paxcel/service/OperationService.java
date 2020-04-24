package net.paxcel.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface OperationService {
	
	public void addItem(String username , String payload);
	public List<String> getTodos(String username);
	public void delete(String payload , String username);

}
