package Busnies_Servic.Business_Layer.Game;

import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.Player;
import Busnies_Servic.EventType;

public class Event {
    EventType eventType;
    Player player;
    Team team;

    /**
     * event constructor
     */
    public Event(Team arg_team, EventType arg_event_type, Player arg_player){
        team=arg_team;
        eventType =arg_event_type;
        if (arg_team.returnPlayer(arg_player.getUserName())!=null){
            player=arg_player;
        }
        else{
            player=null;
            System.out.println("The player i not a part of the team!");
        }
    }

    public String eventToString(){
        return eventType +" for player:"+player.getUserName()+" from team:"+ team.getName();
    }

}
