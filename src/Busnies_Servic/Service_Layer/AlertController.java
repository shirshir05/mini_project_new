package Busnies_Servic.Service_Layer;



import Busnies_Servic.Business_Layer.Game.Game;
import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.Coach;
import Busnies_Servic.Business_Layer.UserManagement.Fan;
import Busnies_Servic.Business_Layer.UserManagement.Player;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;

import java.util.Scanner;

public class AlertController {

    /**
     *  This function register the fan to alerts of a game he choose.
     */
    public void fan_register_to_game_alerts(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter game id:");
        int game_number=scanner.nextInt();
        scanner.close();
        Game chosen_game = LogicManagement.find_game(game_number);
        chosen_game.addObserver((Fan)LogicManagement.getCurrent());
    }


    /**
     * This function register the current user to the page he asked to be registered to.
     * @param arg_user_to_register is the name of the page the user wants to register to
     * @return true if the registeration succeeded
     */
    public boolean fan_register_to_page(String arg_user_to_register){
        Busnies_Servic.Business_Layer.UserManagement.Subscription current_user = LogicManagement.contain_subscription(arg_user_to_register);
        if (current_user instanceof Coach) {
            ((Coach) current_user).getPersonalPage().addObserver((Fan)LogicManagement.getCurrent());
            return true;
        }
        else if (current_user instanceof Player) {
            ((Player) current_user).getPersonalPage().addObserver((Fan)LogicManagement.getCurrent());
            return true;
        }
        else{
            Team t = LogicManagement.findTeam(arg_user_to_register);
            if (t!=null){
                t.getPersonalPage().addObserver((Fan)LogicManagement.getCurrent());
                return true;
            }
        }
        System.out.println("Wrong page name");
        return false;
    }





}
