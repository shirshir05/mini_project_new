package Busnies_Servic.Business_Layer.Game;

import java.util.HashSet;
import java.util.Observable;

import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.Player;
import Busnies_Servic.Business_Layer.UserManagement.Referee;
import Busnies_Servic.EventType;
import javafx.util.Pair;

import java.util.Date;
import java.util.Scanner;

public class Game extends Observable{
    static int game_id=0;
    String field;
    Date date;
    Team host;
    Team guest;
    Referee head;
    Referee linesman1;
    Referee linesman2;
    Pair<Integer,Integer> score; // Integer[0] = host , Integer[1] = guest
    HashSet<Event> eventList;

    public Game(String f, Date d, Team h, Team g){
        game_id++;
        field=f;
        date=d;
        host=h;
        guest=g;
        eventList = new HashSet<>();

    }

    public boolean update_score(){

        //update ScoreTable

        return true;
    }

    public boolean create_event(){

        // write to logger
        return true;
    }

    public int get_game_id(){
        return game_id;
    }

    /**
     * This function let the user add an event to the game
     * @return true - if the event was update, false otherwise.
     */
    public boolean update_new_event(Team team_name, Player p, EventType event){
        Event new_event=null;
        if (host.getName().equals(team_name)){
            new_event=new Event(host,event,p);
            eventList.add(new_event);
        }
        else if (guest.getName().equals(team_name)){
            new_event=new Event(guest,event,p);
            eventList.add(new_event);
        }
        else{
            System.out.println("This team is not a part of the game!");
            return false;
        }
        setChanged();
        notifyObservers(new_event.event_to_string());
        return true;

    }












}
