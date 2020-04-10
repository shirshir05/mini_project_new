package test_busnies_users;

import Busnies_Servic.Action;
import Busnies_Servic.Business_Layer.UserManagement.Permissions;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Business_Layer.UserManagement.SubscriptionFactory;
import Busnies_Servic.Business_Layer.UserManagement.SystemAdministrator;
import Busnies_Servic.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SystemAdministratorTest {

    String userName;
    String password;
    SystemAdministrator sysAdmin;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //Input_test
                {"person","09876"}, {"me","837465"},
                {"???","123456"}, {"", "123456"}
        });
    }

    public SystemAdministratorTest(String arg_user_name, String arg_password) {
        this.userName = arg_user_name;
        this.password = arg_password;
    }

    @Before
    public void setUp() throws Exception {
        sysAdmin = new SystemAdministrator(userName,password);
    }

    @Test
    public void creation() {
        Subscription sub = new SystemAdministrator(userName,password);
        assertTrue(sub instanceof SystemAdministrator);
    }

    @Test
    public void getPermissions() {
        Permissions perm = sysAdmin.getPermissions();
        Integer one = 1 ;
        Integer zero = 0;
        assertEquals(one,perm.check_permissions(Action.Close_team_perpetually));
        assertEquals(one,perm.check_permissions(Action.Respond_to_complaints));
        assertEquals(one,perm.check_permissions(Action.Removing_Subscriptions));
        assertEquals(one,perm.check_permissions(Action.watch_log));
        assertEquals(one,perm.check_permissions(Action.Recommendation_system));

        assertEquals(zero,perm.check_permissions(Action.watch_personal_page));
        assertEquals(zero,perm.check_permissions(Action.write_complaint));
        assertEquals(zero,perm.check_permissions(Action.Search_History));
        assertEquals(zero,perm.check_permissions(Action.Upload_personal_page));
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