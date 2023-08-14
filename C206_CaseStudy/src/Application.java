public class Application {
	private String studentName;
	private String studentCCA;
	private String status;
	
	public Application(String studentName, String studentCCA, String status) {
		this.studentName = studentName;
		this.studentCCA = studentCCA;
		this.status = status;
	}

	
	public String getStudentName() {
		return studentName;
	}
	
	public String getStudentCCA() {
		return studentCCA;
	}
	
	 public String getStatus() {
		 return status;
	 }
	 
	 public void setStatus(String status) {
		 this.status = status;
	 }
}

