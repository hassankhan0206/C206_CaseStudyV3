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

    


}
