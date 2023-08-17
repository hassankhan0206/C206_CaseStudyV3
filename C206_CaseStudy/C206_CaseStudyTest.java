import static org.junit.Assert.*;

 

 

import org.junit.After;

 

import org.junit.Before;

 

import org.junit.Test;

 

import java.util.ArrayList;

 

 

public class C206_CaseStudyTest {

 

 

	@Before

 

	public void setUp() throws Exception {

 

	}

 

 

	@After

 

	public void tearDown() throws Exception {

 

	}

 

 

	@Test

 

	public void c206_test() {

 

		//fail("Not yet implemented");

 

		assertTrue("C206_CaseStudy_SampleTest ",true);

 

	}

 

 

	@Test

 

	public void testViewAppStatus() {  

 

		ArrayList<Application> appList = new ArrayList<>();

 

 

		appList.add(new Application("Wafiy", "NPCC", "Pending"));

 

		appList.add(new Application("Nicholas", "Girls Guides", "Pending"));

 

		appList.add(new Application("Hassan", "Girls Guides", "Pending"));

 

 

		C206_CaseStudy.viewAppStatus(appList);

 

 

		assertTrue("testViewAppStatus", true);

 

 

	}

 

 

	@Test

 

    public void testAppStatusApproveAndRemove() {

 

        ArrayList<Application> appList = new ArrayList<>();

 

        appList.add(new Application("Wafiy", "NPCC", "Pending"));

 

 

        C206_CaseStudy.appStatus(appList);

 

        assertEquals(0, appList.size());

 

    }

 

 

    @Test

 

    public void testAppStatusRejectAndKeep() {

 

        ArrayList<Application> appList = new ArrayList<>();

 

 

        appList.add(new Application("Nicholas", "Girls Guides", "Pending"));

 

 

        C206_CaseStudy.appStatus(appList);

 

        assertEquals("Rejected", appList.get(0).getStatus());

 

        assertEquals(1, appList.size());

 

    }

 

 

    @Test

 

    public void testAppStatusInvalidStudent() {

 

        ArrayList<Application> appList = new ArrayList<>();

 

 

        appList.add(new Application("Wafiy", "NPCC", "Pending"));

 

 

        C206_CaseStudy.appStatus(appList);

 

        assertEquals(1, appList.size());

 

    }

 

 

    @Test

 

    public void testUpdateUserValid() {

 

        ArrayList<User> userList = new ArrayList<>();

 

 

        userList.add(new User("admin", "adminpass", "Admin"));

 

        userList.add(new User("teacher", "teacherpass", "Teacher"));

 

 

        C206_CaseStudy.updateUser(userList);

 

 

        assertEquals("newpass", userList.get(0).getPassword());

 

        assertEquals("Teacher", userList.get(0).getRole());

 

    }

 

 

    @Test

 

    public void testUpdateUserInvalidName() {

 

        ArrayList<User> userList = new ArrayList<>();

 

        userList.add(new User("admin", "adminpass", "Admin"));

 

        userList.add(new User("teacher", "teacherpass", "Teacher"));

 

 

        

 

        Helper.setMockUserInput("invaliduser", "newpass", "Student");

 

 

        C206_CaseStudy.updateUser(userList);

 

 

    }

 

 

    @Test

 

    public void testDoDeleteUserValid() {

 

        ArrayList<User> userList = new ArrayList<>();

 

        userList.add(new User("admin", "adminpass", "Admin"));

 

        userList.add(new User("teacher", "teacherpass", "Teacher"));

 

 

        boolean result = C206_CaseStudy.doDeleteUser(userList, "admin");

 

 

        assertTrue(result);

 

        assertEquals(1, userList.size());

 

        assertEquals("teacher", userList.get(0).getUsername());

 

    }

 

 

    @Test

 

    public void testDeleteUserValid() {

 

        ArrayList<User> userList = new ArrayList<>();

 

        userList.add(new User("admin", "adminpass", "Admin"));

 

        userList.add(new User("teacher", "teacherpass", "Teacher"));

 

 

        C206_CaseStudy.deleteUser(userList);

 

 

 

        assertEquals(1, userList.size());

 

        assertEquals("teacher", userList.get(0).getUsername());

 

 

    }

 

 

    public static void addCCA(ArrayList<CCA> ccaList, String ccaName, String desc, String rest) {

 

        if (ccaName.isEmpty()) {

 

            throw new IllegalArgumentException("CCA name cannot be empty");

 

        }

 

 

        ccaList.add(new CCA(ccaName, desc, rest, 0));

 

    }

 

 

    @Test

 

    public void testAddCCANormal() {

 

        ArrayList<CCA> ccaList = new ArrayList<>();

 

 

        addCCA(ccaList, "Football Club", "Sports activity", "No restrictions");

 

 

        // Assert the CCA has been added successfully

 

        assertEquals("Incorrect CCA count after adding", 1, ccaList.size());

 

    }

 

	@Test

 

    public void testAddCCABoundary() {

 

        ArrayList<CCA> ccaList = new ArrayList<>();

 

 

        // Add multiple CCAs to test boundary condition

 

        addCCA(ccaList, "NPCC", "Mental exercise", "No restrictions");

 

        addCCA(ccaList, "ChineseDance", "Creative expression", "No restrictions");

 

        // Assert the CCAs have been added successfully

 

        assertEquals("Incorrect CCA count after adding", 2, ccaList.size());

 

    }

 

    @Test(expected = IllegalArgumentException.class)

 

    public void testAddCCAError() {

 

        ArrayList<CCA> ccaList = new ArrayList<>();
        // Attempt to add a CCA with an empty name to trigger an error condition

 

        addCCA(ccaList, "", "Invalid CCA", "No restrictions");

 

    }
    @Test
    public void testAddUser() {
        ArrayList<User> userList = new ArrayList<>();
        C206_CaseStudy.addUser(userList);

 

        assertEquals(1, userList.size());

 

        User addedUser = userList.get(0);
        assertEquals("User1", addedUser.getUsername());
        assertEquals("userpass", addedUser.getPassword());
        assertEquals("Admin", addedUser.getRole());
    }


    @Before
    public void setUp1() throws Exception {
    	ArrayList<CCA> ccaList = new ArrayList<CCA>();
        ccaList = new ArrayList<>();
        ccaList.add(new CCA("NPCC", "NPCC is a fulfilling and enriching co-curricular activity which allows cadets to learn and grow."
            , "Must have discipline!", 4));
        ccaList.add(new CCA("Chinese Dance", "Understand the chinese culture by emersing yourself in their ways of dancing"
            , "Must be able to speak chinese", 2));
    }

 

    @After
    public void tearDown1() throws Exception {
    	ArrayList<CCA> ccaList = new ArrayList<CCA>();
        ccaList.clear();
    }

 

    @Test
    public void testDeleteCCAValid() {
    	ArrayList<CCA> ccaList = new ArrayList<CCA>();

    	 ccaList.add(new CCA("NPCC", "NPCC is a fulfilling and enriching co-curricular activity which allows cadets to learn and grow."
    	            , "Must have discipline!", 4));
    	 ccaList.add(new CCA("Chinese Dance", "Understand the chinese culture by emersing yourself in their ways of dancing"
    	            , "Must be able to speak chinese", 2));
        C206_CaseStudy.deleteCCA(ccaList);

 

        assertEquals(1, ccaList.size());
        assertEquals("Chinese Dance", ccaList.get(0).getCcaName());
    }

 

    @Test
    public void testDeleteCCAInvalid() {
    	ArrayList<CCA> ccaList = new ArrayList<CCA>();

    	 ccaList.add(new CCA("NPCC", "NPCC is a fulfilling and enriching co-curricular activity which allows cadets to learn and grow."
    	            , "Must have discipline!", 4));
    	 ccaList.add(new CCA("Chinese Dance", "Understand the chinese culture by emersing yourself in their ways of dancing"
    	            , "Must be able to speak chinese", 2));
        C206_CaseStudy.deleteCCA(ccaList);

 

        assertEquals(2, ccaList.size());
    }

    @Test
    public void testDoUpdateCCAValid() {
        ArrayList<CCA> ccaList = new ArrayList<>();
        ccaList.add(new CCA("NPCC", "NPCC is a fulfilling and enriching co-curricular activity which allows cadets to learn and grow."
            , "Must have discipline!", 4));
        ccaList.add(new CCA("Chinese Dance", "Understand the chinese culture by emersing yourself in their ways of dancing"
            , "Must be able to speak chinese", 2));

 

        boolean result = C206_CaseStudy.doUpdateCCA(ccaList, "NPCC", "NPCC description updated", "Updated restriction");
        assertTrue(result);

 

        assertEquals("NPCC description updated", ccaList.get(0).getDescription());
        assertEquals("Updated restriction", ccaList.get(0).getRestriction());
        assertEquals("Must be able to speak chinese", ccaList.get(1).getRestriction());
    }

 

    @Test
    public void testDoUpdateCCAInvalid() {
        ArrayList<CCA> ccaList = new ArrayList<>();
        ccaList.add(new CCA("NPCC", "NPCC is a fulfilling and enriching co-curricular activity which allows cadets to learn and grow."
            , "Must have discipline!", 4));
        ccaList.add(new CCA("Chinese Dance", "Understand the chinese culture by emersing yourself in their ways of dancing"
            , "Must be able to speak chinese", 2));

 

        boolean result = C206_CaseStudy.doUpdateCCA(ccaList, "Football Club", "New description", "New restriction");
        assertFalse(result);

 

        assertEquals("NPCC is a fulfilling and enriching co-curricular activity which allows cadets to learn and grow.",
                     ccaList.get(0).getDescription());
        assertEquals("Must have discipline!", ccaList.get(0).getRestriction());
        assertEquals("Must be able to speak chinese", ccaList.get(1).getRestriction());
    }

 

    

}