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
     * Enemt comstructor
     * @param t is the team that is related to the event
     */
    public Event(Team t){
        team=t;
        event_type=get_event_type_from_user();
        player=get_player_name_from_user();
        if (player==null){
            System.out.println("This player don't play in this team");
        }
    }

    /**
     * This function gets from the user the event-type he wants to report on
     * @return the event-type he chose.
     */
    public Player get_player_name_from_user(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter player name");
        String player_name = scan.nextLine();
        return team.return_player(player_name);
    }


    /**
     * This function gets from the user the event-type he wants to report on
     * @return the event-type he chose.
     */
    public EventType get_event_type_from_user(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose event type:");
        System.out.println("1 - Goal");
        System.out.println("2- Offside:");
        System.out.println("3 - Foul:");
        System.out.println("4 - Red Ticket");
        System.out.println("5 - Yellow Ticket");
        System.out.println("6 - Injury");
        System.out.println("7 - player replacement:");
        int choose = scan.nextInt();
        return get_event_type_from_user_For_Test(choose);

    }

    private EventType get_event_type_from_user_For_Test(int choose) {

        EventType type_chosen = null;

        switch (choose) {
            case 1:
                type_chosen=EventType.goal;
                break;
            case 2:
                type_chosen=EventType.offside;
                break;
            case 3:
                type_chosen=EventType.foul;
                break;
            case 4:
                type_chosen=EventType.red_ticket;
                break;
            case 5:
                type_chosen=EventType.yellow_ticket;
                break;
            case 6:
                type_chosen=EventType.injury;
                break;
            case 7:
                type_chosen=EventType.player_replacement;
                break;
        }
        return type_chosen;
    }

    public String event_to_string(){
        return event_type+" for player:"+player.getUser_name()+" from team:"+ team.getName();
    }

}
