
public class Student extends User{
	
	private int userId;
	
	public Student(String username, String password, String role, int userId) {
		super(username, password, role);
		this.userId = userId;
	}

	
	public int getUserId() {
		return userId;
	}

	
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
