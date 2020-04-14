package Busnies_Servic.Business_Layer.Game;

import java.time.LocalDate;
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
    int id;
    String field;
    LocalDate date;
    Team host;
    Team guest;
    Referee head;
    Referee linesman1;
    Referee linesman2;
    Pair<Integer,Integer> score; // Integer[0] = host , Integer[1] = guest
    HashSet<Event> eventList;

    public Game(String f, LocalDate d, Team h, Team g){

        //checking null or empty input
        if(f == null ||  f == "" || d == null || h == null || g == null){
            System.out.println("non valid input! all fields must be not null and not empty");
            return;
        }

        //checking valid teams input
        if(h.equals(g)){
            System.out.println("non valid teams input! team host can't ne equals to team guest");
            return;
        }

        game_id++;
        id = game_id;
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

    public int getId(){
        return id;
    }

    /**
     * This function let the user add an event to the game
     * @return true - if the event was update, false otherwise.
     */
    public boolean updateNewEvent(String team_name, String player_name, EventType event){
        //***WRITE TO LOGGER***//
        Event new_event=null;
        if (host.getName().equals(team_name)){
            Player p = host.getPlayer(player_name);
            if(p == null){
                System.out.println("This player is not part of the team!");
                return false;
            }
            new_event=new Event(host,event,p);
            eventList.add(new_event);
        }
        else if (guest.getName().equals(team_name)){
            Player p = guest.getPlayer(player_name);
            if(p == null){
                System.out.println("This player is not part of the team!");
                return false;
            }
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

    public void changeDate(LocalDate new_date){
        if(date != null){
            date=new_date;
        }
        setChanged();
        notifyObservers("The date has changed! The new date is: "+new_date.toString());
    }

    public LocalDate getDate() {
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

    public void setHost(Team host) {
        if(host != null && !this.guest.equals(host)){

            this.host = host;
        }
    }

    public void setGuest(Team guest) {

        if(guest != null && !this.host.equals(guest)){

            this.guest = guest;
        }
    }
}
