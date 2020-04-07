package test_busnies_users;

import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SubscriptionTest {

    String userName;
    String password;
    Role role;
    String expected;
    Subscription subscription;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //Input_test
                {null, "123456", Role.Coach, "null"}, {"shir", null, Role.Coach, "null"},
                {"", "123456", Role.Coach, "null"}, {"shir", "", Role.Coach, "null"},
                {"shir","123456" , null, "null"}, {"person", "123456", Role.Coach, "object"},
                {"person", "123456", Role.Fan, "object"}, {"person", "123456", Role.Guest, "object"},
                {"person", "123456", Role.Players, "object"}, {"person", "123456", Role.Referee, "object"},
                {"person", "123456", Role.SystemAdministrator, "object"}, {"person", "123456", Role.TeamManager, "object"},
                {"person", "123456", Role.TeamOwner, "object"}, {"person", "123456", Role.UnionRepresentative, "object"}
        });
    }

    public SubscriptionTest(String arg_user_name, String arg_password, Role role,String expected ) {
        this.userName = arg_user_name;
        this.password = arg_password;
        this.role = role;
        this.expected = expected;
    }

    @Test
    public void getAlerts() {
    }

    @Test
    public void equals() {
    }

    @Test
    public void getPermissions() {
    }

    @Test
    public void setPassword() {
    }

    @Test
    public void setUserName() {
    }

    @Test
    public void getPassword() {
    }

    @Test
    public void getUserName() {
    }
}