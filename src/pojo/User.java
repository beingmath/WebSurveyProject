package pojo;

public class User {
	public static final String SESSION_NAME="CurrentUser";
		private String name;
        private String pwd;
        private String role;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPwd() {
			return pwd;
		}
		public User(String name, String pwd, String role) {
			this.name = name;
			this.pwd = pwd;
			this.role = role;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
        
}
