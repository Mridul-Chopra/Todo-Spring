package net.paxcel.model;

import java.io.Serializable;
import java.util.Objects;

public class TodoCompositeKey implements Serializable {

	private String username;
	private String item;
	
	TodoCompositeKey()
	{
		
	}
	
	TodoCompositeKey(String username , String item)
	{
		this.username = username;
		this.item = item;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoCompositeKey key = (TodoCompositeKey) o;
        return username.equals(key.username) &&
                item.equals(key.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, item);
    }
}
