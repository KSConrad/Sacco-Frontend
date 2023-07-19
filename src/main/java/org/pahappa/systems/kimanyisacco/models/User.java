package org.pahappa.systems.kimanyisacco.models;

public class User{
    
        private String userName;
        public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		private String password;
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

    public void display(){
        System.out.println(userName + password);
    }


}