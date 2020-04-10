package Busnies_Servic.Service_Layer;

import static org.junit.Assert.*;

import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Business_Layer.UserManagement.SubscriptionFactory;
import Busnies_Servic.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LogAndExitControllerTest {

    SubscriptionFactory factory;
    LogAndExitController controller;
    Subscription Current;
    String name;
    String password;
    String role;
    String expected;
    boolean ifRegistationTest;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //Input_test
                {"shir", "12345","Coach", "Subscription successfully added!"},
                {"shir", "11111", "Coach", "Please select another username because this username exists in the system."},
                {null, "12345", "Coach", "The input is empty."},
                {"shir", null, "Coach", "The input is empty."},
                {"", "nul2l", "Coach", "The input is empty."},
                {"shir", "", "Coach", "The input is empty."},
                {"shir","123456", "Coach", "The password must contain exactly 5 digits."},
                {"shir", "1", "Coach", "The password must contain exactly 5 digits."},
                {"shir", "1rr", "Coach", "The password must contain exactly 5 digits."},
                {"shir", ";", "Coach", "The password must contain exactly 5 digits."},
                {"shir", "1rr", "Coach", "The password must contain exactly 5 digits."},
                {"shir", "12345", "Teacher", "The role does not exist in the system."},
                {"shir", "12345", "Coach", "Another subscription is connected to the system."},
        });
    }

//    public LogAndExitControllerTest(String arg_user_name, String arg_password, String role, String expected) {
//        this.name = arg_user_name;
//        this.password = arg_password;
//        this.role = role;
//        this.expected = expected;
//    }

    public LogAndExitControllerTest(String arg_user_name, String arg_password, String role, String expected) {
        factory = new SubscriptionFactory();
        this.name = arg_user_name;
        this.password = arg_password;
        this.role = role;
        this.expected = expected;
    }

    @Before
    public void setUp() throws Exception {

        ifRegistationTest = false;
        controller = new LogAndExitController();
        factory = new SubscriptionFactory();
    }

    @Test
    public void registrationTest() {

        if (expected.equals("The input is empty.") ||
                expected.equals("The password must contain exactly 5 digits.") ||
                expected.equals("The password must contain only digits.") ||
                expected.equals("Subscription successfully added!") ||
                expected.equals("The role does not exist in the system.")) {

            ifRegistationTest = true;
            assertEquals(expected, controller.Registration(name, password, role));

            if (expected.equals("Subscription successfully added!")) {

                assertEquals("Please select another username because this username exists in the system.", controller.Registration(name, password, role));
            }
        }
    }

    @Test
    public void loginTest() {

        this.name = "matan";
        this.password = "12345";
        this.role = "Coach";

        //check Successfully Registration
        assertEquals("Subscription successfully added!", controller.Registration(name, password, role)); //maybe need to use stub and change it
        //controller.Subscription.add(factory.Create(name,password, Role.Coach)); //Registare user manualy

        //check login when another subscription is connected
        controller.Current = controller.contain_subscription(name);
        assertEquals("Another subscription is connected to the system.", controller.Login(name, password));
        controller.Current = null;

        //check login when password does not match
        this.password = "12346";
        assertEquals("The password does not match the username.", controller.Login(name, password));
        this.password = "12345";

        //check login when there is no such a name."
        this.name = "other name";
        assertEquals("There is no user with such a name.", controller.Login(name, password));
        this.name = "matan";

        //check login successful
        assertEquals("Login successful.", controller.Login(name, password));

    }
    @Test
    public void exitTest() {

        this.name = "matan";
        this.password = "12345";
        this.role = "Coach";

        //Register and login user manually
        controller.Subscription.add(controller.Current = factory.Create(name,password, Role.Coach));

        //check exit wrong user name
        this.name = "mata";
        assertEquals("One of the details you entered is incorrect.", controller.Exit(name, password));
        this.name = "matan";

        //check exit wrong password
        this.password = "1s2345";
        assertEquals("One of the details you entered is incorrect.", controller.Exit(name, password));
        this.password = "12345";

        //check exit Successfully
        assertEquals("Successfully disconnected from the system.", controller.Exit(name, password));

        //check exit no current login user
        controller.Current = null;
        assertEquals("One of the details you entered is incorrect.", controller.Exit(name, password));
    }
}



