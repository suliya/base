package bean;

public class User {
	   private  String username;
	   private  String password;
	   private  String index;
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(String username, String password, String index) {
			super();
			this.username = username;
			this.password = password;
			this.index = index;
		}
		
		
		public User(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
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
		public String getIndex() {
			return index;
		}
		public void setIndex(String index) {
			this.index = index;
		}
		
		   
   
   
}