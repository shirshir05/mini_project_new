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
    String email;
    Coach coach;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //Input_test
                {"person","09876","shir0@post.bgu.ac.il",""}, {"me","837465","shir0@post.bgu.ac.il","complaining complaints"},
                {"???","123456","shir0@post.bgu.ac.il","fix this!"}, {"", "123456","shir0@post.bgu.ac.il|","what?!"}
        });
    }

    public CoachTest(String arg_user_name, String arg_password,String arg_complaint, String email) {
        this.userName = arg_user_name;
        this.password = arg_password;
        this.email = email;
        this.complaint = arg_complaint;
    }

    @Before
    public void setUp() throws Exception {
        coach = new Coach(userName,password,email);
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