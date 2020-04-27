package net.paxcel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class AuthoritiesModel {

	@Id @Column(name = "username") String username;
		@Column(name = "authority") final String authority = "ROLE_USER";
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getAuthority() {
			return authority;
		}
	
		
}
