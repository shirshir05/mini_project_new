package Busnies_Servic.Business_Layer.Game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class EventTest {

    /**
     * Test - E1
     */
    @RunWith(Parameterized.class)
    public static class Event{
        //parameter


        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{


            });
        }
        public Event() {
            //parameter
        }
        @Test
        public void EventTest() {

        }

    }//Event



    /**
     * Test - E2
     */
    @RunWith(Parameterized.class)
    public static class eventToString{
        //parameter


        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{


            });
        }
        public eventToString() {
            //parameter
        }
        @Test
        public void eventToStringTest() {

        }

    }//eventToString


}