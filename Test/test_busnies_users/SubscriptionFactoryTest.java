package test_busnies_users;

import Busnies_Servic.Business_Layer.UserManagement.*;
import Busnies_Servic.Role;
import Busnies_Servic.Service_Layer.TeamGameController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SubscriptionFactoryTest {

    String userName;
    String password;
    Role role;
    String expected;
    SubscriptionFactory factory;

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

    public SubscriptionFactoryTest(String arg_user_name, String arg_password, Role role,String expected ) {
        this.userName = arg_user_name;
        this.password = arg_password;
        this.role = role;
        this.expected = expected;
    }

    @Before
    public void setUp() throws Exception {
        factory = new SubscriptionFactory();
    }

    @Test
    public void create() {
        Subscription sub = factory.Create(userName,password,role);
        if(expected.equals("null")){
            assertNull(factory.Create(userName,password,role));
        }
        else if(expected.equals("object")){
            assertNotNull(sub);
            if(role == Role.Coach ){
                assertTrue(sub instanceof Coach);
            }
            else if (role ==Role.Fan){
                assertTrue(sub instanceof Fan);
            }
            else if (role == Role.Guest){
                assertTrue(sub instanceof Guest);
            }
            else if (role == Role.Players){
                assertTrue(sub instanceof Player);
            }
            else if (role == Role.Referee){
                assertTrue(sub instanceof Referee);
            }
            else if (role == Role.SystemAdministrator){
                assertTrue(sub instanceof SystemAdministrator);
            }
            else if (role == Role.TeamManager){
                assertTrue(sub instanceof TeamManager);
            }
            else if (role == Role.TeamOwner){
                assertTrue(sub instanceof TeamOwner);
            }
            else if (role == Role.UnionRepresentative){
                assertTrue(sub instanceof UnionRepresentative);
            }
        }
    }
}