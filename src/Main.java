import Busnies_Servic.Business_Layer.UserManagement.Referee;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Presentation_Layer.Spelling;

public class Main {

        public static void main(String[] args) {
            /**
            /// Check the complaints update
            Complaint c = new Complaint("Hello");
            SystemAdministrator s = new SystemAdministrator("Raz","Raz");
            c.addObserver(s);
            ComplaintController cont = new ComplaintController(c);
            cont.add_complaint();
            s.printAlerts();
             **/

            /// Check the game event update
            /*
            Player p = new Player("raz","1234");
            Fan me = new Fan("Raz","1234");
            Team host = new Team("TLV", "Teddi");
            Team guest = new Team("Haifa", "Sami");
            guest.add_or_remove_player(p,1);
            Game g = new Game("Teddi", null, host, guest);
            g.addObserver(me);
            g.update_new_event();
            me.getAlerts();
            */

            //initialize the system:
            /**
            LogAndExitController lc = new LogAndExitController();


        //    String str = lc.Registration("mainAdmin", "p@$$w0rd", "SystemAdministrator","email");
       //    System.out.println(str + "\n" );

            String str = lc.Registration("mainAdmin", "p@$$w0rd", "SystemAdministrator","email");
            System.out.println(str + "\n" );
             **/

            /* test for spelling class
            Spelling.updateDictionary("this is my name");
            System.out.println("the correct: "+Spelling.getCorrectWord("this si mi name") +"!");
            */

        }
}
