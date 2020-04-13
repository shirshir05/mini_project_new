import Busnies_Servic.Business_Layer.UserManagement.Referee;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Presentation_Layer.Spelling;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

        public static void main(String[] args) {

                Date date = new GregorianCalendar(1992, 10, 14).getTime();

                System.out.println(date.getYear());
                System.out.println(date.getDay());

                System.out.println(date);

        }
}
