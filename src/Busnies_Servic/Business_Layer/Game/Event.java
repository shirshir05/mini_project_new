package Busnies_Servic.Business_Layer.Game;

import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.Player;
import Busnies_Servic.EventType;

import java.util.Scanner;

public class Event {
    EventType event_type;
    Player player;
    Team team;

    /**
     * event constructor
     */
    public Event(Team arg_team, EventType arg_event_type, Player arg_player){
        team=arg_team;
        event_type=arg_event_type;
        if (arg_team.return_player(arg_player.getUserName())!=null){
            player=arg_player;
        }
        else{
            player=null;
            System.out.println("The player i not a part of the team!");
        }
    }

    public String event_to_string(){
        return event_type+" for player:"+player.getUserName()+" from team:"+ team.getName();
    }

}
