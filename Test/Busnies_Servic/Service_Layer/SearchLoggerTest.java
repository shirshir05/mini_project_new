package Busnies_Servic.Service_Layer;

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
    public static class SearchLogger{
        //parameter


        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{


            });
        }
        public SearchLogger() {
            //parameter
        }
        @Test
        public void SearchLoggerTest() {

        }


    }//SearchLogger

    /**
     * Test - SL2
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
     * Test - SL3
     */
    @RunWith(Parameterized.class)
    public static class showSearchHistory{
        //parameter


        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{


            });
        }
        public showSearchHistory() {
            //parameter
        }
        @Test
        public void showSearchHistory() {

        }


    }//showSearchHistory


}