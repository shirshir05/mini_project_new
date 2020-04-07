package Busnies_Servic.Business_Layer.TeamManagement;
import java.util.HashMap;
import java.util.Observable;
import Busnies_Servic.Business_Layer.Trace.*;
import Busnies_Servic.Business_Layer.UserManagement.*;
import javafx.util.Pair;

import java.util.HashSet;

public class Team extends Observable {

    String Name;
    HashSet<Player> list_Player;
    HashSet<Coach> list_Coach;
    HashSet<TeamManager> list_TeamManagement;// המנהל קבוצ
    HashSet<TeamOwner> list_TeamOwner; // בעל קבוצה
    String Field;
    TeamPersonalPage PersonalPage;
    int statue; // 0 - off 1 - on -1 - always close
    HashMap<Integer, Pair<String,Integer>> financial;//Integer  = quarterly


    public Team(String arg_name, String arg_field ){
        this.Name =arg_name;
        this.Field = arg_field;
        list_Player = new HashSet<>();
    }

    public void set_Player(Player Player) {
        if(Player != null){
            this.list_Player.add(Player);
        }
    }

    public void set_Coach(Coach coach) {
        if(coach != null){
            this.list_Coach.add(coach);
        }
    }

    public void set_TeamManagement(TeamManager TeamManagement) {
        if(TeamManagement != null){
            this.list_TeamManagement.add(TeamManagement);
        }
    }

    public void set_TeamOwner(TeamOwner TeamOwner) {
        if(TeamOwner != null){
            this.list_TeamOwner.add(TeamOwner);
        }
    }

    public void setField(String field) {
        Field = field;
    }

    public void setPersonalPage(TeamPersonalPage personalPage) {
        PersonalPage = personalPage;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }


    /**
     * The function allows a player to be added to a team or to remove a player from the team.
     * @param player
     * @param add_or_remove
     * @return
     */
    public String add_or_remove_player(Player player, int add_or_remove ){
        //remove the players
        if(add_or_remove == 0){
            if(list_Player.contains(player)){
                list_Player.remove(player);
                return "The player was successfully removed from the team.";
            }
            return "The player is not in the team.";
        }
        //add the players
        else if(add_or_remove == 1){
            if(!list_Player.contains(player)){
                list_Player.add(player);
                return "he player was successfully added from the team.";
            }
            return "The player is already in the team.";
        }
        return "The action is invalid.";
    }


    /**
     * The function allows to add and remove coaches from the team.
     * @param coach_add
     * @param add_or_remove
     * @return
     */
    public String add_or_remove_coach(Coach coach_add, int add_or_remove ){
        //remove the Coach
        if(add_or_remove == 0){
            if(list_Coach.contains(coach_add)){
                list_Coach.remove(coach_add);
                return "The Coach was successfully removed from the team.";
            }
            return "The Coach is not in the team.";
        }
        //add the Coach
        else if(add_or_remove == 1){
            if(!list_Coach.contains(coach_add)){
                list_Coach.add(coach_add);
                return "he Coach was successfully added from the team.";
            }
            return "The Coach is already in the team.";
        }
        return "The action is invalid.";
    }

    public Player return_player(String player_name){
        for (Player p : list_Player){
            if (p.getUser_name().equals(player_name)){
                return p;
            }
        }
        return null;
    }

    public boolean Edit_TeamOwner(TeamOwner TeamOwner, int add_or_remove){

        return true;
    }

    /**
     * The function checks whether a particular role is part of the group. If so, he can take action on it.
     * @param object
     * @return
     */
    public boolean check_if_object_in_team(Subscription object){
        return list_TeamManagement.contains(object) || list_TeamOwner.contains(object) ;
    }


    public boolean change_status(int status){
        setChanged();
        notifyObservers();
        return true;
    }

    public String getName() {
        return Name;
    }

    public PersonalPage getPersonalPage() {
        return PersonalPage;
    }
}
