package test_busnies_users;

import Busnies_Servic.Action;
import Busnies_Servic.Business_Layer.UserManagement.Complaint;
import Busnies_Servic.Business_Layer.UserManagement.Fan;
import Busnies_Servic.Business_Layer.UserManagement.Permissions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class FanTest {

    String userName;
    String password;
    String complaint;
    Fan fan;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //Input_test
                {"person","09876",""}, {"me","837465","complaining complaints"},
                {"???","123456","fix this!"}, {"", "123456","what?!"}
        });
    }

    public FanTest(String arg_user_name, String arg_password,String arg_complaint) {
        this.userName = arg_user_name;
        this.password = arg_password;
        this.complaint = arg_complaint;
    }

    @Before
    public void setUp() throws Exception {
        fan = new Fan(userName,password);
    }

    @Test
    public void getPermissions() {
        Permissions perm = fan.getPermissions();
        Integer one = 1 ;
        Integer zero = 0;
        assertEquals(one,perm.check_permissions(Action.watch_personal_page));
        assertEquals(one,perm.check_permissions(Action.write_complaint));
        assertEquals(one,perm.check_permissions(Action.Game_alerts));
        assertEquals(one,perm.check_permissions(Action.Search_History));

        assertEquals(zero,perm.check_permissions(Action.Recommendation_system));
        assertEquals(zero,perm.check_permissions(Action.Upload_personal_page));
    }

    @Test
    public void add_complaint() {
        Complaint comp1 = new Complaint(complaint);
        fan.add_complaint(comp1);
        assertEquals(fan.list_complaint.size(),1);
        assertTrue(fan.list_complaint.contains(comp1));
        Complaint comp2 = new Complaint("");
        fan.add_complaint(comp2);
        assertEquals(fan.list_complaint.size(),2);
        assertTrue(fan.list_complaint.contains(comp2));
    }

    @Test
    public void update() {
    }
}