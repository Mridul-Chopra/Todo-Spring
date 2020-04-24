package net.paxcel.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import net.paxcel.model.TodoCompositeKey;
import net.paxcel.model.TodoModel;

@Repository
public interface TodoRepository extends CrudRepository<TodoModel,TodoCompositeKey>{
	
		public List<TodoModel> findByUsername(String username);
		
		@Transactional
		public void deleteItemByUsernameAndItem( String username , String item  );
}
