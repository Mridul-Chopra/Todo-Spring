package net.paxcel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.paxcel.dao.TodoRepository;
import net.paxcel.model.TodoModel;

@Service
public class OperationsServiceImpl  implements OperationService{

	@Autowired
	TodoRepository db;
	
	
	@Override
	public void addItem(String username, String payload) {
		JSONObject data = new JSONObject(payload);
		String item = data.getString("item");
		Boolean isDone = data.getInt("status")==1?true:false;
		TodoModel todo = new TodoModel(username,item,isDone);
		System.out.println(todo.toString());
		db.save(todo);
		db.flush();
	}


	@Override
	public Map<String,Boolean> getTodos(String username) {
		
		List<TodoModel> data = db.findByUsername(username);
		Map<String,Boolean> todos = new HashMap<String,Boolean>();
		
		data.forEach( 
						(x)->{
								todos.put(x.getItem(),x.getIsDone());
							}
					);
		
		return todos;
	}


	@Override
	public void delete(String payload , String username) {
		
		JSONObject data = new JSONObject(payload);
		String item = data.getString("item");
		
		db.deleteItemByUsernameAndItem(username , item);
		
	}




}
