package net.paxcel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {
	
	@Id @Column(name = "username") String username;
		@Column(name= "password") String password;
		@Column(name = "enabled") final Boolean enabled = true;
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Boolean getEnabled() {
			return enabled;
		}
		
		@Override
		public String toString()
		{
			return "[ username : "+this.username+" password : "+this.password+" enabled : "+this.enabled+" ]";
		}
}
