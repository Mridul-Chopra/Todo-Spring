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
		
//		db.flush();
//		db.save(todo);
		db.save(todo);
		
	}


	@Override
	public List<String> getTodos(String username) {
		
		List<TodoModel> data = db.findByUsername(username);
		List<String> todos = new ArrayList<String>();
		
		data.forEach( 
						(x)->{
								todos.add(x.getItem());
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
