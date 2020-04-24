package net.paxcel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="todo")
@IdClass(TodoCompositeKey.class)
public class TodoModel {

	public TodoModel()
	{}
	
	public TodoModel(String username , String item , Boolean isDone)
	{
		this.username=username;
		this.item = item;
		this.isDone= isDone;
	}
	
	
	@Column(name = "username") @Id String username;
	@Column(name = "item") @Id String item;
	@Column(name = "isDone") Boolean isDone;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	
	@Override
	public String toString()
	{
		return "[ username : "+username+", item : "+item+",  isDone : "+isDone+" ]";
	}
}
