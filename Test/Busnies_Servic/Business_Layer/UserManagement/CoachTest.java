package Busnies_Servic.Business_Layer.UserManagement;

import Busnies_Servic.Business_Layer.Trace.CoachPersonalPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class CoachTest {

    /**
     * Test - C1
     */
    @RunWith(Parameterized.class)
    public static class Coach{

        protected CoachPersonalPage PersonalPage;
        protected String qualification;
        protected String roleInTeam;


        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"Coach1","123456","shir0@post.bgu.ac.il",""},
                    {"Coach2","123456","shir0@post.bgu.ac.il",""},
                    {"Coach3","123456","shir0@post.bgu.ac.il",""},
                    {"Coach3", "123456","shir0@post.bgu.ac.il|",""}
            });
        }
        public Coach() {
            //parameter
        }
        @Test
        public void CoachTest() {

        }

    }//Coach

}