public class Teacher extends User{

 

	private String cca;

	public Teacher(String username, String password, String role, String cca) {
		super(username, password, role);
		this.cca = cca;
	}


	public String getCca() {
		return cca;
	}

 

	public void setCca(String cca) {
		this.cca = cca;
	}
	//t//
}