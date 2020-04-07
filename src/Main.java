import Busnies_Servic.Business_Layer.Game.Game;
import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.Complaint;
import Busnies_Servic.Business_Layer.UserManagement.Fan;
import Busnies_Servic.Business_Layer.UserManagement.Player;
import Busnies_Servic.Business_Layer.UserManagement.SystemAdministrator;
import Busnies_Servic.Service_Layer.ComplaintController;

import java.util.Date;

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
            Player p = new Player("raz","1234");
            Fan me = new Fan("Raz","1234");
            Team host = new Team("TLV", "Teddi");
            Team guest = new Team("Haifa", "Sami");
            guest.add_or_remove_player(p,1);
            Game g = new Game("Teddi", null, host, guest);
            g.addObserver(me);
            g.update_new_event();
            me.getAlerts();
        }
}
