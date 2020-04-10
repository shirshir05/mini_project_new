package Busnies_Servic.Service_Layer;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;


    @RunWith(Parameterized.class)
    public class registrationTest {


        LogAndExitController controller;
        @Before
        public void init(){
            controller = new LogAndExitController();
        }

        String name;
        String password;
        String role;
        String expected;
        String email;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    //user name = null
                    {null, "12345", "Coach","shir0@post.bgu.ac.il", "The input is empty."},
                    // add user name
                    {"shir", "12345", "Coach","shir0@post.bgu.ac.il", "Subscription successfully added!"},
                    //password null
                    {"shir", null, "Coach","shir0@post.bgu.ac.il", "The input is empty."},
                    {"", "null", "Coach","shir0@post.bgu.ac.il", "The input is empty."},
                    {"shir", "", "Coach","shir0@post.bgu.ac.il", "The input is empty."}, {"shir", "123456", "Coach","shir0@post.bgu.ac.il", "The password must contain exactly 5 digits."},
                    {"shir", "1", "Coach","shir0@post.bgu.ac.il", "The password must contain exactly 5 digits."},
                    //{"shir", "12345", "Coach","shir0@post.bgu.ac.il", "Please select another username because this username exists in the system."},
                    {"shir", "1rr", "Coach","shir0@post.bgu.ac.il", "The password must contain exactly 5 digits."}, {"shir", ";", "Coach","shir0@post.bgu.ac.il", "The password must contain exactly 5 digits."},
                    {"shir", "1rr", "Coach","shir0@post.bgu.ac.il", "The password must contain exactly 5 digits."}, {"shir", "1rr", "Coach","shir0@post.bgu.ac.il", "The password must contain exactly 5 digits."}
            });
        }

        public registrationTest(String name, String password, String role, String email, String expected) {
            this.name = name;
            this.password = password;
            this.role = role;
            this.expected = expected;
            this.email =email;
        }

        @Test
        public void user_name_incorrect() {
            String actual = controller.Registration(name, password, role,email);
            assertEquals(expected, actual);
        }
    }


