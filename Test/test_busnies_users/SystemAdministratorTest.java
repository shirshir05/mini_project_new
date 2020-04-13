package test_busnies_users;

import Busnies_Servic.PermissionAction;
import Busnies_Servic.Business_Layer.UserManagement.Permissions;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Business_Layer.UserManagement.SystemAdministrator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SystemAdministratorTest {

    String userName;
    String password;
    String email;
    SystemAdministrator sysAdmin;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //Input_test
                {"person","shir0@post.bgu.ac.il","09876"}, {"me","shir0@post.bgu.ac.il","837465"},
                {"???","shir0@post.bgu.ac.il","123456"}, {"","shir0@post.bgu.ac.il", "123456"}
        });
    }

    public SystemAdministratorTest(String arg_user_name, String arg_password,String email) {
        this.userName = arg_user_name;
        this.password = arg_password;
        this.email = email;
    }

    @Before
    public void setUp() throws Exception {
        sysAdmin = new SystemAdministrator(userName,password,email);
    }

    @Test
    public void creation() {
        Subscription sub = new SystemAdministrator(userName,password,email);
        assertTrue(sub instanceof SystemAdministrator);
    }

    @Test
    public void getPermissions() {
        Permissions perm = sysAdmin.getPermissions();
        Integer one = 1 ;
        Integer zero = 0;
        assertEquals(one,perm.check_permissions(PermissionAction.Close_team_perpetually));
        assertEquals(one,perm.check_permissions(PermissionAction.Respond_to_complaints));
        assertEquals(one,perm.check_permissions(PermissionAction.Removing_Subscriptions));
        assertEquals(one,perm.check_permissions(PermissionAction.watch_log));
        assertEquals(one,perm.check_permissions(PermissionAction.Recommendation_system));

        assertEquals(zero,perm.check_permissions(PermissionAction.write_complaint));
        assertEquals(zero,perm.check_permissions(PermissionAction.Search_History));
    }


    @Test
    public void approve_create_team() {
    }

    @Test
    public void change_status_team() {
    }

    @Test
    public void update() {
    }
}