package 능력단위평가;

class User {

	private String username;
	private String password;
	private String name;
	private String email;

	public User(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;		
		
		 System.out.println("[사용자 정보]");
		 System.out.println("username: " + getUsername());
		 System.out.println("password: " + getPassword());
		 System.out.println("name: " + getName());
		 System.out.println("email: " + getEmail());
	}

	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	

}