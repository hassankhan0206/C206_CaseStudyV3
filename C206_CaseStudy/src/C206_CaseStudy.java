import java.util.ArrayList;
public class C206_CaseStudy {

 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ArrayList<User> userList = new ArrayList<User>();

 

		ccaList.add(new CCA("NPCC", "NPCC is a fulfilling and enriching co-curricular activity which allows cadets to learn and grow significantly in personal competencies and leadership.", "Must have discipline!"));
		ccaList.add(new CCA("Basketball", "The Basketball CCA aims to provide students with the opportunity to hone basic basketball skills, which includes various ball handling and shooting techniques. ", "Must have good leadership!"));

 

		userList.add(new User("admin","adminpass", "Admin"));
		userList.add(new User("teacher", "teacherpass", "Teacher"));
		userList.add(new User("student", "studentpass", "Student"));

		String userOpt = "";
		String passOpt = "";
		int option = 0;
		userOpt = Helper.readString("Enter username > ");
		passOpt = Helper.readString("Enter password > ");

		for (int i = 0; i < userList.size(); i++) {
			if (userOpt.equals(userList.get(i).getUsername()) && passOpt.equals(userList.get(i).getPassword())) {
				String userRole = userList.get(i).getRole();

 

				if (userRole == "Student") {
					while (option != 9) {
						System.out.println("");
						System.out.println("YOU ARE LOGGED IN AS A STUDENT");
						C206_CaseStudy.studentMenu();
						option = Helper.readInt("ENTER AN OPTION > ");
					}
				} else if (userRole == "Admin") {
					while (option != 9) {
						System.out.println("");
						System.out.println("YOU ARE LOGGED IN AS AN ADMIN");
						C206_CaseStudy.adminMenu();
						option = Helper.readInt("ENTER AN OPTION > ");
					}	
				} else {
					while (option != 9) {
						System.out.println("");
						System.out.println("YOU ARE LOGGED IN AS A TEACHER");
						C206_CaseStudy.teacherMenu();
						option = Helper.readInt("ENTER AN OPTION > ");
					}
				}
			}
		}


	
			if (option == 1) {
				// View all items
				C206_CaseStudy.viewAllCCA(ccaList);

 

			} else if (option == 2) {
				// Loan item
				C206_CaseStudy.setHeader("Apply CCA");			

 

 

					// Loan laptop
					C206_CaseStudy.applyCCA(ccaList);

 

 

			} else if (option == 3) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD CCA");			

 

 

				C206_CaseStudy.viewAllCCA(ccaList);

 

 

					// Add a laptop
					CCA lp = inputCCA();
					C206_CaseStudy.addCCA(ccaList, lp);
					System.out.println("CCA added");

 

 

			} else if (option == 4) {
				// Return item
				C206_CaseStudy.setHeader("Delete CCA");				

 

 

					// Return laptop
					C206_CaseStudy.deleteCCA(ccaList);

 

			} else if (option == 5) {
				// Return item
				C206_CaseStudy.setHeader("Update CCA");				

 

 

					// Return laptop
					C206_CaseStudy.updateCCA(ccaList);
			} else if (option == 6) {
				// Return item
				C206_CaseStudy.setHeader("Add User");				

 

 

					// Return laptop
					C206_CaseStudy.addUser(ccaList);
			} else if (option == 7) {
				// Return item
				C206_CaseStudy.setHeader("Delete User");				

 

 

					// Return laptop
					C206_CaseStudy.deleteUser(ccaList);
			} else if (option == 8) {
				// Return item
				C206_CaseStudy.setHeader("Update User");				

 

 

					// Return laptop
					C206_CaseStudy.updateUser(ccaList);
			} else if (option == 9) {
				// Return item
				C206_CaseStudy.setHeader("Request Approval");				

 

 

					// Return laptop
					C206_CaseStudy.approveRequest(ccaList);
			} else if (option == 0) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}


 

	public static void itemTypeMenu() {
		C206_CaseStudy.setHeader("ITEM TYPES");
		System.out.println("1. Camcorder");
	}

 

 

	public static void studentMenu() {
		C206_CaseStudy.setHeader("CCA APPLICATION APP");
		Helper.line(80, "-");
		System.out.println("1. Display CCA");
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

 

	public static String retrieveAllUser(ArrayList<Student> userList) {
		String output = "";

 

			    for (int i = 0; i < userList.size(); i++) {

 

 

			output += String.format("%-84s \n", userList.get(i).toString());
			    }
			    return output;
			  }

 

	

    public static void viewAllCCA(ArrayList<CCA> ccaList) {
        setHeader("CCA LIST");
        for (CCA cca : ccaList) {
            System.out.println(cca.toString());
        }
    }

	
	public static void viewAllUser(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("USER LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
				"AVAILABLE", "DUE DATE","OPTICAL ZOOM");
		 output += retrieveAllUser(userList);	
		System.out.println(output);
	}

 

 

	public static CCA inputCCA() {
		String CCA = Helper.readString("Enter activity > ");
		String description = Helper.readString("Enter description > ");
		String restriction = Helper.readString("Enter restriction > ");

 

		CCA lp= new CCA(CCA, description, restriction);
		return lp;

 

	}

 

	public static void addCCA(ArrayList<CCA> ccaList, CCA lp) {
		CCA item;
		for(int i = 0; i < ccaList.size(); i++) {
			item = ccaList.get(i);
			if (item.getccaName().equalsIgnoreCase(lp.getccaName()) )
				return;
		}
		if ((lp.getccaName().isEmpty()) || (lp.getDescription().isEmpty()) ) {
			return;
		}
		ccaList.add(lp);

 

	}
	public static boolean doDeleteCCA(ArrayList<CCA> ccaList, String CCA, String dueDate) {

 

		boolean isLoaned = false;

 

 

		if (CCA.isEmpty() || dueDate.isEmpty())
			return false;

 

		for (int i = 0; i < ccaList.size(); i++) {

 

			if (CCA.equalsIgnoreCase(ccaList.get(i).getccaName())				
&& ccaList.get(i).getIsAvailable() == true) {

 

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

 

	public static boolean doUpdateLaptop(ArrayList<CCA> ccaList,String CCA) {
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

 

 

	public static void updateLaptop(ArrayList<CCA> ccaList) {
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
	public static boolean doApplyCCA(ArrayList<CCA> ccaList,String tag) {
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

 

 

 

public static Student inputUser() {
	String user = Helper.readString("Enter activity > ");
	String description = Helper.readString("Enter description > ");
	String restriction = Helper.readString("Enter restriction > ");

 

 

 

	CCA lp= new CCA(CCA, description, restriction);
	return lp;

 

 

}

 

 

public static void addUser(ArrayList<Student> userList, CCA lp) {
	Student item;
	for(int i = 0; i < userList.size(); i++) {
		item = userList.get(i);
		if (item.getccaName().equalsIgnoreCase(lp.getccaName()) )
			return;
	}
	if ((lp.getccaName().isEmpty()) || (lp.getDescription().isEmpty()) ) {
		return;
	}
	userList.add(lp);

 

}
public static boolean doDeleteUser(ArrayList<Student> userList, String CCA, String dueDate) {

 

	boolean isLoaned = false;

 

 

	if (CCA.isEmpty() || dueDate.isEmpty())
		return false;

 

	for (int i = 0; i < ccaList.size(); i++) {

 

		if (CCA.equalsIgnoreCase(ccaList.get(i).getccaName())				
&& ccaList.get(i).getIsAvailable() == true) {

 

			ccaList.remove(i);

 

			isLoaned = true;

 

		}
	}
	return isLoaned;
}

 

 

public static void deleteUser(ArrayList<Student> userList) {
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

 

public static boolean doUpdateUser(ArrayList<Student> userList,String CCA) {
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

 

 

public static void updateUser(ArrayList<CCA> ccaList) {
	C206_CaseStudy.viewAllCCA(ccaList);
	String CCA = Helper.readString("Enter CCA > ");
	Boolean isReturned = doUpdateLaptop(ccaList, CCA);

 

	if (isReturned == false) {
		System.out.println("Invalid CCA");
	} else {
		System.out.println("CCA updated");
	}
}

 

 

public static void addUser(ArrayList<CCA> ccaList) {
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
public static boolean doAddUser(ArrayList<CCA> ccaList,String tag) {
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

 

 

}