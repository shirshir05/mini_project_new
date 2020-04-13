package test_busnies_users;

import Busnies_Servic.PermissionAction;
import Busnies_Servic.Business_Layer.UserManagement.Complaint;
import Busnies_Servic.Business_Layer.UserManagement.Fan;
import Busnies_Servic.Business_Layer.UserManagement.Permissions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FanTest {

    String userName;
    String password;
    String complaint;
    String email;
    Fan fan;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //Input_test
                {"person","09876","shir0@post.bgu.ac.il",""}, {"me","837465","shir0@post.bgu.ac.il","complaining complaints"},
                {"???","123456","shir0@post.bgu.ac.il","fix this!"}, {"", "123456","shir0@post.bgu.ac.il","what?!"}
        });
    }

    public FanTest(String arg_user_name, String arg_password,String arg_complaint,String email) {
        this.userName = arg_user_name;
        this.password = arg_password;
        this.complaint = arg_complaint;
        this.email = email;
    }

    @Before
    public void setUp() throws Exception {
        fan = new Fan(userName,password,email);
    }

    @Test
    public void getPermissions() {
        Permissions perm = fan.getPermissions();
        Integer one = 1 ;
        Integer zero = 0;
        assertEquals(one,perm.check_permissions(PermissionAction.write_complaint));
        assertEquals(one,perm.check_permissions(PermissionAction.Search_History));
        assertEquals(zero,perm.check_permissions(PermissionAction.Recommendation_system));
    }

    @Test
    public void add_complaint() {
        Complaint comp1 = new Complaint(complaint);
        fan.addComplaint(comp1);
        //assertEquals(fan.list_complaint.size(),1);
        //assertTrue(fan.list_complaint.contains(comp1));
        Complaint comp2 = new Complaint("");
        fan.addComplaint(comp2);
        //assertEquals(fan.list_complaint.size(),2);
        //assertTrue(fan.list_complaint.contains(comp2));
    }

    @Test
    public void update() {
    }
}