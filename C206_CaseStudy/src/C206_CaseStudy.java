import java.util.ArrayList;

public class C206_CaseStudy {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ArrayLists here
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Application> appList = new ArrayList<Application>();


		userList.add(new User("admin", "adminpass", "Admin"));
		userList.add(new User("teacher", "teacherpass", "Teacher"));
		userList.add(new User("student", "studentpass", "Student"));
		
		appList.add(new Application("Wafiy", "NPCC", "Pending"));
		appList.add(new Application("Nicholas", "Girls Guides", "Pending"));
		appList.add(new Application("Hassan", "Girls Guides", "Pending"));

 
		String userOpt = "";
		String passOpt = "";
		int aOption = 0;
		int stOption = 0;
		int tOption = 0;
		boolean loggedIn = false;
		
		while (loggedIn == false) {
		userOpt = Helper.readString("Enter username > ");
		passOpt = Helper.readString("Enter password > ");
		
		for (int i = 0; i < userList.size(); i++) {
			if (userOpt.equals(userList.get(i).getUsername()) && passOpt.equals(userList.get(i).getPassword())) {
				String userRole = userList.get(i).getRole();
				loggedIn = true;

				while (loggedIn) {

					if (userRole.equalsIgnoreCase("Student")) {
						System.out.println("");
						System.out.println("YOU ARE LOGGED IN AS A STUDENT");
						C206_CaseStudy.studentMenu();
						stOption = Helper.readInt("ENTER AN OPTION > ");
						if (stOption == 1) {
							C206_CaseStudy.viewAllCCA(ccaList);
							loggedIn = true;
						} else if (stOption == 2) {
							C206_CaseStudy.applyCCA(ccaList, appList);
							loggedIn = true;
						}

 

					} else if (userRole.equalsIgnoreCase("Admin")) {
						System.out.println("");
						System.out.println("YOU ARE LOGGED IN AS AN ADMIN");
						C206_CaseStudy.adminMenu();
						aOption = Helper.readInt("ENTER AN OPTION > ");
						if (aOption == 1) {
							C206_CaseStudy.addCCA(ccaList);
							loggedIn = true;
						} else if (aOption == 2) {
							C206_CaseStudy.deleteCCA(ccaList);
							loggedIn = true;
						} else if (aOption == 3) {
							C206_CaseStudy.updateCCA(ccaList);
							loggedIn = true;
						} else if (aOption == 4) {
							C206_CaseStudy.addUser(userList);
							loggedIn = true;
						} else if (aOption == 5) {
							C206_CaseStudy.deleteUser(userList);
							loggedIn = true;
						} else if (aOption == 6) {
							C206_CaseStudy.updateUser(userList);
							loggedIn = true;
						}

 

					} else {
						System.out.println("");
						System.out.println("YOU ARE LOGGED IN AS A TEACHER");
						C206_CaseStudy.teacherMenu();
						tOption = Helper.readInt("ENTER AN OPTION > ");
						if (tOption == 1) {
							C206_CaseStudy.updateCCAmembers(ccaList);
							loggedIn = true;
						} else if (tOption == 2) {
							C206_CaseStudy.viewCCA(ccaList);
							loggedIn = true;
						} else if (tOption == 3) {
							C206_CaseStudy.appStatus(appList);
							loggedIn = true;
						} else if (tOption == 4) {
							C206_CaseStudy.viewAppStatus(appList);
							loggedIn = true;
						}
					} if (stOption == 9 || tOption == 9 || aOption == 9) {
						System.out.println("Logging out...");
						loggedIn = false;
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
		System.out.println("1. Update CCA members");
		System.out.println("2. View CCA");
		System.out.println("3. Update application status");
		System.out.println("4. View application status");
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

	public static void viewAppStatus(ArrayList<Application> appList) {
		setHeader("CCA APPLICATION STATUS");
		Helper.line(80, "-");
	    System.out.printf("%-20s %-20s %-20s%n", "Name", "CCA", "Application Status");
	    Helper.line(80, "-");

	    for (int i = 0; i < appList.size(); i++) {
	        System.out.printf("%-20s %-20s %-20s%n", appList.get(i).getStudentName(), appList.get(i).getStudentCCA(), appList.get(i).getStatus());
	    }
	}

	public static void appStatus(ArrayList<Application> appList) {
	    C206_CaseStudy.viewAppStatus(appList);

	    String sName = Helper.readString("ENTER STUDENT NAME > ");
	    String sStatus = Helper.readString("ENTER APPLICATION STATUS, <YES FOR APPROVE, NO FOR REJECT>");

	    int matchingIndex = -1;
	   
	    for (int i = 0; i < appList.size(); i++) {
	    	String studentName = appList.get(i).getStudentName();
	        if (sName.equalsIgnoreCase(studentName)) {
	            matchingIndex = i;
	            break;
	        }
	    }

	    if (matchingIndex != -1) {
	        if (sStatus.equalsIgnoreCase("YES")) {
	            appList.get(matchingIndex).setStatus("Approved");
	        } else {
	            appList.get(matchingIndex).setStatus("Rejected");
	        }

	        char move = Helper.readChar("Move <APPROVED> application students to respective CCAs? (Y/N)");
	        if (move == 'Y' || move == 'y') {
	            appList.remove(matchingIndex);
	        }
	    } else {
	        System.out.println("No such student found");
	    }
	}

	public static void viewCCA(ArrayList<CCA> ccaList) {
		
		String enteredCCA = Helper.readString("ENTER CCA NAME > ");
		setHeader("CCA NAME AND DETAILS");
		System.out.printf("%-20s %-20s%n", "CCA Name", "No. of members");
		for (int i = 0; i < ccaList.size(); i++) {
			if (enteredCCA.equalsIgnoreCase(ccaList.get(i).getCcaName())) {
				System.out.printf("%-20s %-20s%n", ccaList.get(i).getCcaName(), ccaList.get(i).getCapacity());
			}
		}
	}
	
	public static void viewAllCCA(ArrayList<CCA> ccaList) {
		
	    setHeader("CCA LIST");
	    System.out.printf("%-20s %-100s %-30s %30s%n", "CCA Name", "Description", "Restriction","Capacity");
	    Helper.line(200, "-");

	    for (CCA cca : ccaList) {
	        System.out.printf("%-20s %-100s %-30s %30d%n", cca.getCcaName(), cca.getDescription(), cca.getRestriction(), cca.getCapacity());
	    }
	}

	public static void viewAllUser(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("USER LIST");
		System.out.printf("%-10s %-30s %-10s%n", "USERNAME", "PASSWORD", "ROLE");
	    Helper.line(120, "-");
		 for (User user : userList) {
		        System.out.printf("%-10s %-30s %-10s%n", user.getUsername(), user.getPassword(), user.getRole());
		    }
		
	}

	public static void addCCA(ArrayList<CCA> ccaList) {
		C206_CaseStudy.setHeader("ADD CCA");
		String ccaName = "";
		String desc = "";
		String rest = "";
		ccaName = Helper.readString("ENTER CCA NAME > ");
		desc = Helper.readString("ENTER CCA DESCRIPTION > ");
		rest = Helper.readString("ENTER CCA RESTRICTION > ");

		ccaList.add(new CCA(ccaName, desc, rest, 0));

		System.out.println("CCA ADDED! ");

	}

	public static boolean doDeleteCCA(ArrayList<CCA> ccaList, String CCA) {
		boolean deleted = false;
		if (CCA.isEmpty())
			return false;
		for (int i = 0; i < ccaList.size(); i++) {
			if (CCA.equalsIgnoreCase(ccaList.get(i).getCcaName())) {
				ccaList.remove(i);
				deleted = true;
			}
		}
		return deleted;
	}

	public static void deleteCCA(ArrayList<CCA> ccaList) {
		C206_CaseStudy.viewAllCCA(ccaList);
		String CCA = Helper.readString("Enter CCA name > ");
		Boolean isLoaned = doDeleteCCA(ccaList, CCA);
		if (isLoaned == false) {
			System.out.println("Invalid CCA name");
		} else {
			System.out.println("CCA: " + CCA + " has been deleted");
			C206_CaseStudy.viewAllCCA(ccaList);
		}
	}

	public static boolean doUpdateCCA(ArrayList<CCA> ccaList, String CCA, String desc, String restriction) {
		boolean updated = false;
		if (CCA.isEmpty())
			return false;
		for (int i = 0; i < ccaList.size(); i++) {
			String ccaNameRe = ccaList.get(i).getCcaName();
			if (CCA.equalsIgnoreCase(ccaNameRe)) {
				ccaList.get(i).setDescription(desc);
				ccaList.get(i).setRestriction(restriction);
				updated = true;
			}
		}
		return updated;
	}

	public static void updateCCA(ArrayList<CCA> ccaList) {
		C206_CaseStudy.viewAllCCA(ccaList);
		String CCA = Helper.readString("Enter CCA > ");
		String desc = Helper.readString("Enter new description > ");
		String restriction = Helper.readString("Enter new restriction > ");
		Boolean updated = doUpdateCCA(ccaList, CCA, desc, restriction);

		if (updated == false) {
			System.out.println("Invalid CCA");
		} else {
			System.out.println("CCA updated");
			C206_CaseStudy.viewAllCCA(ccaList);
		}
	}
	
	public static CCA findCCA(ArrayList<CCA> ccaList, String ccaName) {
	    for (CCA cca : ccaList) {
	        if (cca.getCcaName().equalsIgnoreCase(ccaName)) {
	            return cca;
	        }
	    }
	    return null;
	}
 
	public static boolean doApplyCCA(ArrayList<Application> appList, ArrayList<CCA> ccaList, String ccaName, String studentName) {
	    boolean isApplied = false;
	    
	    CCA selectedCCA = findCCA(ccaList, ccaName);
	    
	    if (selectedCCA != null) {
	        appList.add(new Application(studentName, ccaName, "Pending"));
	        isApplied = true;
	    }
	    return isApplied;
	}

	public static void applyCCA(ArrayList<CCA> ccaList, ArrayList<Application> appList) {
	    C206_CaseStudy.viewAllCCA(ccaList);
	    String studentName = Helper.readString("Enter your name > ");
	    String ccaName = Helper.readString("Enter CCA name > ");
	    
	    boolean isApplied = doApplyCCA(appList, ccaList, ccaName, studentName);
	    
	    if (isApplied) {
	        System.out.println("Application submitted for CCA: " + ccaName);
	    } else {
	        System.out.println("Invalid CCA name or CCA not available for application.");
	    }
	}
	
	public static void addUser(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("ADD USER");
		String userName = "";
		String userPass = "";
		String useRole = "";
		userName = Helper.readString("ENTER USER NAME > ");
		userPass = Helper.readString("ENTER USER PASSWORD > ");
		useRole = Helper.readString("ENTER USER ROLE > ");

		userList.add(new User(userName, userPass, useRole));

		System.out.println("USER ADDED! ");
		C206_CaseStudy.viewAllUser(userList);
	}

	public static boolean doDeleteUser(ArrayList<User> userList, String name) {

		boolean deleted = false;
		if (name.isEmpty())
			return false;
		for (int i = 0; i < userList.size(); i++) {
			String usernameRe = userList.get(i).getUsername();
			if (name.equalsIgnoreCase(usernameRe)) {
				userList.remove(i);
				deleted = true;
			} //test push
		}
		return deleted;
	}

	public static void deleteUser(ArrayList<User> userList) {
		C206_CaseStudy.viewAllUser(userList);
		String name = Helper.readString("Enter username to delete > ");
		Boolean deleted = doDeleteUser(userList, name);
		if (deleted == false) {
			System.out.println("Invalid username");
		} else {
			System.out.println("User " + name + " has been deleted");
			C206_CaseStudy.viewAllUser(userList);
		}
	}

	public static boolean doUpdateUser(ArrayList<User> userList, String name, String password, String role) {
		boolean isReturned = false;

		if (name.isEmpty())
			return false;

		for (int i = 0; i < userList.size(); i++) {
			if (name.equalsIgnoreCase(userList.get(i).getUsername())) {
				userList.get(i).setPassword(password);
				userList.get(i).setRole(role);
				isReturned = true;
			}
		}
		return isReturned;
	}

	public static void updateUser(ArrayList<User> userList) {
		C206_CaseStudy.viewAllUser(userList);
		String name = Helper.readString("Enter username to update > ");
		String password = Helper.readString("Enter new password > ");
		String role = Helper.readString("Enter new role > ");
		Boolean updated = doUpdateUser(userList, name, password, role);
		if (updated == false) {
			System.out.println("Invalid username");
		} else {
			System.out.println("User " + name + "'s details have been updated");
			C206_CaseStudy.viewAllUser(userList);
		}
	}
	public static boolean doUpdateCCAmember(ArrayList<CCA> ccaList, String ccaName, int capacity) {
		boolean isUpdated = false;
		if(ccaName.isEmpty()){
			isUpdated = false;
		}
		for(int i = 0; i < ccaList.size(); i++) {
			if (ccaName.equalsIgnoreCase(ccaList.get(i).getCcaName())) {
				ccaList.get(i).setCapacity(capacity + ccaList.get(i).getCapacity());
				isUpdated = true;
			}
		}
		return isUpdated;
	}
	public static void updateCCAmembers(ArrayList<CCA> ccaList) {
	    C206_CaseStudy.viewAllCCA(ccaList);
	    String ccaName = Helper.readString("Enter CCA to update > ");
	    int capacity = Helper.readInt("Enter amount to add > ");
	    boolean updated = doUpdateCCAmember(ccaList, ccaName, capacity);
		if (updated == false) {
			System.out.println("Update unsuccessful!");
		} else {
			System.out.println("User " + ccaName + "'s details have been updated");
			C206_CaseStudy.viewAllCCA(ccaList);
		}
	}

	
	public static void updateAttendance(ArrayList<Attendance> attendanceList) {
	    String studentName = Helper.readString("Enter student name > ");
	    String activityName = Helper.readString("Enter activity name > ");
	    String newAttendanceStatus = Helper.readString("Enter new attendance status (Present/Absent) > ");

	    for (Attendance attendance : attendanceList) {
	        if (attendance.getStudentName().equalsIgnoreCase(studentName) && attendance.getActivityName().equalsIgnoreCase(activityName)) {
	            attendance.setAttendanceStatus(newAttendanceStatus);
	            System.out.println("Attendance updated for " + studentName + " in " + activityName);
	            return;
	        }
	    }

	    System.out.println("Attendance record not found");
	}
	public static void searchAttendance(ArrayList<Attendance> attendanceList) {
	    String studentName = Helper.readString("Enter student name > ");
	    String activityName = Helper.readString("Enter activity name > ");

	    for (Attendance attendance : attendanceList) {
	        if (attendance.getStudentName().equalsIgnoreCase(studentName) && attendance.getActivityName().equalsIgnoreCase(activityName)) {
	            System.out.println("Attendance status for " + studentName + " in " + activityName + ": " + attendance.getAttendanceStatus());
	            return;
	        }
	    }

	    System.out.println("Attendance record not found");
	}


}
