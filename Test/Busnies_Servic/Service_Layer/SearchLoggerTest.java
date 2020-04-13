package Busnies_Servic.Service_Layer;

import Busnies_Servic.Business_Layer.UserManagement.Fan;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Business_Layer.UserManagement.SubscriptionFactory;
import Busnies_Servic.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class SearchLoggerTest {

    /**
     * Test - SL1
     */
    @RunWith(Parameterized.class)
    public static class findData{
        //parameter


        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{


            });
        }
        public findData() {
            //parameter
        }
        @Test
        public void findDataTest() {

        }


    }//findData


    /**
     * Test - SL2
     */
    public static class showSearchHistory{

        @Test
        public void showSearchHistory() {
            LogAndExitController logAndExit = new LogAndExitController();
            SearchLogger sl = new SearchLogger();
            logAndExit.Registration("SHIR","123456","Fan","shir0@post.bgu.ac.il");
            logAndExit.Login("SHIR","123456");
            assertEquals(sl.showSearchHistory(),"");
            assertEquals(sl.findData("SHIR"),"fan: SHIR\n");
            assertEquals(sl.showSearchHistory(),"SHIR\n");
        }


    }//showSearchHistory


}