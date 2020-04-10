package test_busnies_users;


import Busnies_Servic.Business_Layer.UserManagement.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CoachTest {

    String userName;
    String password;
    String complaint;
    Coach coach;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //Input_test
                {"person","09876",""}, {"me","837465","complaining complaints"},
                {"???","123456","fix this!"}, {"", "123456","what?!"}
        });
    }

    public CoachTest(String arg_user_name, String arg_password,String arg_complaint) {
        this.userName = arg_user_name;
        this.password = arg_password;
        this.complaint = arg_complaint;
    }

    @Before
    public void setUp() throws Exception {
        coach = new Coach(userName,password);
    }

    @Test
    public void getPersonalPage() {
        assertNotNull(coach.getPersonalPage());
    }

    @Test
    public void setPersonalPage() {
        assertNotNull(coach.getPersonalPage());
        coach.setPersonalPage(null);
        assertNull(coach.getPersonalPage());
    }

    @Test
    public void update() {
    }
}