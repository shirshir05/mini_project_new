package Busnies_Servic.Business_Layer.Game;

import java.util.HashSet;
import java.util.Observable;

import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.Player;
import Busnies_Servic.Business_Layer.UserManagement.Referee;
import Busnies_Servic.EventType;
import javafx.util.Pair;

import java.util.Date;

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
    public boolean update_new_event(String team_name, String player_name, EventType event){
        //***WRITE TO LOGGER***//
        Event new_event=null;
        if (host.getName().equals(team_name)){
            Player p = host.getPlayer(player_name);
            new_event=new Event(host,event,p);
            eventList.add(new_event);
        }
        else if (guest.getName().equals(team_name)){
            Player p = guest.getPlayer(player_name);
            new_event=new Event(guest,event,p);
            eventList.add(new_event);
        }
        else{
            System.out.println("This team is not a part of the game!");
            return false;
        }
        setChanged();
        notifyObservers(new_event.eventToString());
        return true;
    }

    /**
     * host referee setter
     * @param r
     */
    public void setHeadReferee(Referee r){
        if (r!=null) {
            r.addGame(this);
            this.addObserver(r);
            head = r;
        }
    }

    /**
     * linesman1 referee setter
     * @param r
     */
    public void setLinesman1Referee(Referee r){
        if (r!=null) {
            r.addGame(this);
            this.addObserver(r);
            linesman1 = r;
        }
    }
    /**
     * linesman2 referee setter
     * @param r
     */
    public void setLinesman2Referee(Referee r){
        if (r!=null) {
            r.addGame(this);
            this.addObserver(r);
            linesman2 = r;
        }
    }
    /**
     * head referee getter
     * @return
     */
    public Referee getHeadReferee(){ return head;}
    /**
     * linesman1 referee getter
     * @return
     */
    public Referee getLinesman1Referee(){ return linesman1;}
    /**
     * linesman2 referee getter
     * @return
     */
    public Referee getLinesman2Referee(){ return linesman2;}

    public void change_field(String new_field){
        field=new_field;
        setChanged();
        notifyObservers("The field has changed! The new field is: "+new_field);
    }

    public void change_date(Date new_date){
        date=new_date;
        setChanged();
        notifyObservers("The date has changed! The new date is: "+new_date.toString());
    }

    public Date getDate() {
        return date;
    }

    public Team getHost() {
        return host;
    }

    public Team getGuest() {
        return guest;
    }

    public Pair<Integer, Integer> getScore() {
        return score;
    }

    public HashSet<Event> getEventList() {
        return eventList;
    }

    public static void setGame_id(int game_id) {
        Game.game_id = game_id;
    }

    public void setHost(Team host) {
        this.host = host;
    }

    public void setGuest(Team guest) {
        this.guest = guest;
    }
}
