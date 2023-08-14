import java.util.ArrayList;

public class C206_CaseStudy {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ArrayLists here
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Application> appList = new ArrayList<Application>();

 
		ccaList.add(new CCA("NPCC",
				"NPCC is a fulfilling and enriching co-curricular activity which allows cadets to learn and grow significantly in personal competencies and leadership.",
				"Must have discipline!"));
		ccaList.add(new CCA("Basketball",
				"The Basketball CCA aims to provide students with the opportunity to hone basic basketball skills, which includes various ball handling and shooting techniques. ",
				"Must have good leadership!"));

		userList.add(new User("admin", "adminpass", "Admin"));
		userList.add(new User("teacher", "teacherpass", "Teacher"));
		userList.add(new User("student", "studentpass", "Student"));
		
		appList.add(new Application("Wafiy", "Chinese Dance", "Pending"));
		appList.add(new Application("Nicholas", "Girls Guides", "Pending"));
		appList.add(new Application("Hassan", "Robotics", "Pending"));

 
		String userOpt = "";
		String passOpt = "";
		int aOption = 0;
		int stOption = 0;
		int tOption = 0;
		userOpt = Helper.readString("Enter username > ");
		passOpt = Helper.readString("Enter password > ");

 
		for (int i = 0; i < userList.size(); i++) {
			if (userOpt.equals(userList.get(i).getUsername()) && passOpt.equals(userList.get(i).getPassword())) {
				String userRole = userList.get(i).getRole();

				while (stOption != 9 || tOption != 9 || aOption != 9) {

					if (userRole.equalsIgnoreCase("Student")) {
						System.out.println("");
						System.out.println("YOU ARE LOGGED IN AS A STUDENT");
						C206_CaseStudy.studentMenu();
						stOption = Helper.readInt("ENTER AN OPTION > ");
						if (stOption == 1) {
							C206_CaseStudy.viewAllCCA(ccaList);
						} else if (stOption == 2) {
							C206_CaseStudy.applyCCA(ccaList);
						}

 

					} else if (userRole.equalsIgnoreCase("Admin")) {
						System.out.println("");
						System.out.println("YOU ARE LOGGED IN AS AN ADMIN");
						C206_CaseStudy.adminMenu();
						aOption = Helper.readInt("ENTER AN OPTION > ");
						if (aOption == 1) {
							C206_CaseStudy.addCCA(ccaList);
						} else if (aOption == 2) {
							C206_CaseStudy.deleteCCA(ccaList);
						} else if (aOption == 3) {
							C206_CaseStudy.updateCCA(ccaList);
						} else if (aOption == 4) {
							C206_CaseStudy.addUser(userList);
						} else if (aOption == 5) {
							C206_CaseStudy.deleteUser(userList);
						} else if (aOption == 6) {
							C206_CaseStudy.updateUser(userList);
						}

 

					} else {
						System.out.println("");
						System.out.println("YOU ARE LOGGED IN AS A TEACHER");
						C206_CaseStudy.teacherMenu();
						tOption = Helper.readInt("ENTER AN OPTION > ");
						if (tOption == 1) {
							C206_CaseStudy.addCCA(ccaList);
						} else if (tOption == 2) {
							C206_CaseStudy.deleteCCA(ccaList);
						} else if (tOption == 3) {
							C206_CaseStudy.updateCCA(ccaList);
						} else if (tOption == 4) {
							C206_CaseStudy.appStatus(appList); 
						} else if (tOption == 5) {
							C206_CaseStudy.viewAppStatus(appList);
						}
					}
				}
			}
		}
	}


	public static void studentMenu() {
		C206_CaseStudy.setHeader("CCA APPLICATION APP");
		Helper.line(80, "-");
		System.out.println("1. View all CCA");
		System.out.println("2. Apply CCA");
		System.out.println("9. Quit");
		Helper.line(80, "-");
	}

 

	public static void teacherMenu() {
		C206_CaseStudy.setHeader("CCA APPLICATION APP");
		Helper.line(80, "-");
		System.out.println("1. Add CCA");
		System.out.println("2. Delete CCA");
		System.out.println("3. Update CCA");
		System.out.println("4. Approve request");
		System.out.println("5. View application status");
		System.out.println("9. Quit");
		Helper.line(80, "-");
	}

 

	public static void adminMenu() {
		C206_CaseStudy.setHeader("CCA APPLICATION APP");
		Helper.line(80, "-");
		System.out.println("1. Add CCA");
		System.out.println("2. Delete CCA");
		System.out.println("3. Update CCA");
		System.out.println("4. Add User");
		System.out.println("5. Delete User");
		System.out.println("6. Update User");
		System.out.println("9. Quit");
		Helper.line(80, "-");
	}

 

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

 

	public static String showAvailability(boolean isAvailable) {
		String avail;
 
	if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

 
	public static String retrieveAllCCA(ArrayList<CCA> ccaList) {
		String output = "";

 

		for (int i = 0; i < ccaList.size(); i++) {

 

			output += String.format("%-84s \n", ccaList.get(i).toString());
		}
		return output;
	}
	
	public static void viewAppStatus(ArrayList<Application> appList) {
	    System.out.printf("%-20s %-20s %-20s%n", "Name", "CCA", "Application Status");
	    Helper.line(80, "-");

	    for (int i = 0; i < appList.size(); i++) {
	        System.out.printf("%-20s %-20s %-20s%n", appList.get(i).getStudentName(), appList.get(i).getStudentCCA(), appList.get(i).getStatus());
	    }
	}

	public static void appStatus(ArrayList<Application> appList) {
		C206_CaseStudy.viewAppStatus(appList);
	    
	    String sName = "";
	    sName = Helper.readString("ENTER STUDENT NAME > ");
	    String sStatus = "";
	    sStatus = Helper.readString("ENTER APPLICATION STATUS, <YES FOR APPROVE, NO FOR REJECT>");
	    
	    for (int i = 0; i < appList.size(); i++) {
	    	if (sName.equalsIgnoreCase(appList.get(i).getStudentName())) {
	    		if (sStatus.equalsIgnoreCase("YES")) {
	    			appList.get(i).setStatus("Approved");
	    		} else {
	    			appList.get(i).setStatus("Rejected");
	    		}
	    	}
	    }
	}

	public static String retrieveAllUser(ArrayList<Student> userList) {
		String output = "";

 

		for (int i = 0; i < userList.size(); i++) {

 

			output += String.format("%-84s \n", userList.get(i).toString());
		}
		return output;
	}

 

	public static void viewAllCCA(ArrayList<CCA> ccaList) {
	    setHeader("CCA LIST");
	    System.out.printf("%-20s %-70s %-10s%n", "CCA Name", "Description", "Restriction");
	    Helper.line(120, "-");

	    for (CCA cca : ccaList) {
	        System.out.printf("%-20s %-70s %-30s%n", cca.getCcaName(), cca.getDescription(), cca.getRestriction());
	    }
	}

 

	public static void viewAllUser(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION", "AVAILABLE",
				"DUE DATE", "OPTICAL ZOOM");
		output += retrieveAllUser(userList);
		System.out.println(output);
	}

 

 

	public static void addCCA(ArrayList<CCA> ccaList) {
		C206_CaseStudy.setHeader("ADD CCA");
		String ccaName = "";
		String desc = "";
		String rest = "";
		ccaName = Helper.readString("ENTER CCA NAME > ");
		desc = Helper.readString("ENTER CCA DESCRIPTION > ");
		rest = Helper.readString("ENTER CCA RESTRICTION > ");

 

		ccaList.add(new CCA(ccaName, desc, rest));

 

		System.out.println("CCA ADDED! ");

 

	}

 

	public static boolean doDeleteCCA(ArrayList<CCA> ccaList, String CCA, String dueDate) {

 

		boolean isLoaned = false;

 

		if (CCA.isEmpty() || dueDate.isEmpty())
			return false;

 

		for (int i = 0; i < ccaList.size(); i++) {

 

			if (CCA.equalsIgnoreCase(ccaList.get(i).getccaName()) && ccaList.get(i).getIsAvailable() == true) {

 

				ccaList.remove(i);

 

				isLoaned = true;

 

			}
		}
		return isLoaned;
	}

 

	public static void deleteCCA(ArrayList<CCA> ccaList) {
		C206_CaseStudy.viewAllCCA(ccaList);
		String tag = Helper.readString("Enter asset tag > ");
		String due = Helper.readString("Enter due date > ");
		Boolean isLoaned = doDeleteCCA(ccaList, tag, due);
		if (isLoaned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Laptop " + tag + " loaned out");
		}
	}

 

	public static boolean doUpdateLaptop(ArrayList<CCA> ccaList, String CCA) {
		boolean isReturned = false;

 

		if (CCA.isEmpty())
			return false;

 

		for (int i = 0; i < ccaList.size(); i++) {

 

			if (CCA.equalsIgnoreCase(ccaList.get(i).getccaName())

 

					&& ccaList.get(i).getIsAvailable() == false) {

 

				ccaList.get(i).setAvailable(true);
				isReturned = true;

 

			}
		}
		return isReturned;
	}

 

	public static void updateCCA(ArrayList<CCA> ccaList) {
		C206_CaseStudy.viewAllCCA(ccaList);
		String CCA = Helper.readString("Enter CCA > ");
		Boolean isReturned = doUpdateLaptop(ccaList, CCA);

 

		if (isReturned == false) {
			System.out.println("Invalid CCA");
		} else {
			System.out.println("CCA updated");
		}
	}

 

	public static void viewAllUsers(ArrayList<User> userList) {

 

	}

 

	public static void applyCCA(ArrayList<CCA> ccaList) {
		C206_CaseStudy.viewAllCCA(ccaList);
		String tag = Helper.readString("Enter CCA name > ");
		String due = Helper.readString("Enter due date > ");
		Boolean isLoaned = doApplyCCA(ccaList, tag);
		if (isLoaned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Laptop " + tag + " loaned out");
		}
	}

 

	public static boolean doApplyCCA(ArrayList<CCA> ccaList, String tag) {
		boolean isReturned = false;

 

		if (tag.isEmpty())
			return false;

 

		for (int i = 0; i < ccaList.size(); i++) {

 

			if (tag.equalsIgnoreCase(ccaList.get(i).getccaName())

 

					&& ccaList.get(i).getIsAvailable() == false) {

 

				ccaList.get(i).setAvailable(true);
				isReturned = true;

 

			}
		}
		return isReturned;
	}

 

 

	public static void addUser(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("ADD USER");
		String userName = "";
		String userPass = "";
		String useRole = "";
		userName = Helper.readString("ENTER CCA NAME > ");
		userPass = Helper.readString("ENTER CCA DESCRIPTION > ");
		useRole = Helper.readString("ENTER CCA RESTRICTION > ");

 

		userList.add(new User(userName, userPass, useRole));

 

		System.out.println("USER ADDED! ");
	}

 

	public static boolean doDeleteUser(ArrayList<Student> userList, String CCA, String dueDate) {

 

		boolean isLoaned = false;

 

		if (CCA.isEmpty() || dueDate.isEmpty())
			return false;

 

		for (int i = 0; i < userList.size(); i++) {

 

			if (CCA.equalsIgnoreCase(userList.get(i).getccaName()) && userList.get(i).getIsAvailable() == true) {

 

				userList.remove(i);

 

				isLoaned = true;

 

			}
		}
		return isLoaned;
	}

 

	public static void deleteUser(ArrayList<User> userList) {
		C206_CaseStudy.viewAllUser(userList);
		String tag = Helper.readString("Enter asset tag > ");
		String due = Helper.readString("Enter due date > ");
		Boolean isLoaned = doDeleteCCA(userList, tag, due);
		if (isLoaned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Laptop " + tag + " loaned out");
		}
	}

 

	public static boolean doUpdateUser(ArrayList<Student> userList, String CCA) {
		boolean isReturned = false;

 

		if (CCA.isEmpty())
			return false;

 

		for (int i = 0; i < userList.size(); i++) {

 

			if (CCA.equalsIgnoreCase(userList.get(i).getccaName())

 

					&& userList.get(i).getIsAvailable() == false) {

 

				userList.get(i).setAvailable(true);
				isReturned = true;

 

			}
		}
		return isReturned;
	}

 

	public static void updateUser(ArrayList<User> userList) {

 

	}

 

 

}