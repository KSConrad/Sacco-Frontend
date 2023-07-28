package org.pahappa.systems.kimanyisacco.models;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User{
    
	
		private long id;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="userId",nullable=false)
        public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		private String userName;
		private String password;

		

		@Column(name="userName",nullable=false,length=255)
        public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		

		@Column(name="password",nullable=false,length=255)
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

    


}