package Busnies_Servic.Business_Layer.TeamManagement;
import java.util.HashMap;
import java.util.Observable;

import Busnies_Servic.Business_Layer.ActionStatus;
import Busnies_Servic.Business_Layer.BudgetManagement.Expense;
import Busnies_Servic.Business_Layer.BudgetManagement.Income;
import Busnies_Servic.Business_Layer.BudgetManagement.TeamBudget;
import Busnies_Servic.Business_Layer.Trace.*;
import Busnies_Servic.Business_Layer.UserManagement.*;
import javafx.util.Pair;

import java.util.HashSet;

public class Team extends Observable {

    String Name;
    HashSet<Player> list_Player;
    HashSet<Coach> list_Coach;
    HashSet<TeamManager> list_TeamManager;
    HashSet<TeamOwner> list_TeamOwner;
    HashSet<Object> list_assets;
    TeamPersonalPage PersonalPage;
    int status; // 0 - off 1 - on -1 - always close
    HashMap<Integer, Pair<String,Integer>> financial;//Integer  = quarterly

    TeamBudget budget;


    public Team(String arg_name, String arg_main_field ){
        this.Name =arg_name;
        list_Player = new HashSet<>();
        budget = new TeamBudget();
        list_Coach = new HashSet<>() ;
        list_TeamManager = new HashSet<>();
        list_TeamOwner = new HashSet<>();
        list_assets = new HashSet<>();
        PersonalPage = new TeamPersonalPage(Name);
        list_assets.add(arg_main_field);
    }

    public String set_Player(Player Player) {
        if(status == -1 || status == 0){
            return "The team is inactive so no activity can be performed on it";
        }
        if(Player != null){
            this.list_Player.add(Player);
        }
        return null;
    }

    public String set_Coach(Coach coach) {
        if(status == -1 || status == 0){
            return "The team is inactive so no activity can be performed on it";
        }
        if(coach != null){
            this.list_Coach.add(coach);
        }
        return null;
    }

    public String set_TeamManagement(TeamManager TeamManagement) {
        if(status == -1 || status == 0){
            return "The team is inactive so no activity can be performed on it";
        }
        if(TeamManagement != null){
            this.list_TeamManager.add(TeamManagement);
            this.addObserver(TeamManagement); //adds the team manager as an observer
        }
        return null;
    }

    public String set_TeamOwner(TeamOwner TeamOwner) {
        if(status == -1 || status == 0){
            return "The team is inactive so no activity can be performed on it";
        }
        if(TeamOwner != null){
            this.list_TeamOwner.add(TeamOwner);
            this.addObserver(TeamOwner); //adds the team owner as an observer

        }
        return "Operation failed.";
    }

    public String setAsset(String asset) {
        if(status == -1 || status == 0){
            return "The team is inactive so no activity can be performed on it";
        }
        list_assets.add(asset);
        return null;

    }

    public String setPersonalPage(TeamPersonalPage personalPage) {
        if(status == -1 || status == 0){
            return "The team is inactive so no activity can be performed on it";
        }
        PersonalPage = personalPage;
        return null;
    }


    public int getStatus() {
        return status;
    }

    /**
     * The function allows a player to be added to a team or to remove a player from the team.
     * @param player
     * @param add_or_remove
     * @return
     */
    public String add_or_remove_player(Player player, int add_or_remove ){
        if(status == -1 || status == 0){
            return "The team is inactive so no activity can be performed on it";
        }
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
        if(status == -1 || status == 0){
            return "The team is inactive so no activity can be performed on it";
        }
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
            if (p.getUserName().equals(player_name)){
                return p;
            }
        }
        return null;
    }

    /**
     * The function allows to add and remove Team Owner from the team.
     * @param TeamOwner
     * @param add_or_remove
     * @return
     */
    public String Edit_TeamOwner(TeamOwner TeamOwner, int add_or_remove){
        if(status == -1 || status == 0){
            return "The team is inactive so no activity can be performed on it";
        }
        //remove the TeamOwner
        if(add_or_remove == 0){
            if(list_TeamOwner.contains(TeamOwner)){
                list_TeamOwner.remove(TeamOwner);
                return "The Team Owner was successfully removed from the team.";
            }
            return "The Team Owner is not in the team.";
        }
        //add the TeamOwner
        else if(add_or_remove == 1){
            if(!list_TeamOwner.contains(TeamOwner)){
                list_TeamOwner.add(TeamOwner);
                return "he Team Owner was successfully added from the team.";
            }
            return "The Team Owner is already in the team.";
        }
        return "The action is invalid.";
    }

    /**
     * The function allows to add and remove Team mANAGER from the team.
     * @param teamManager
     * @param add_or_remove
     * @return
     */
    public String Edit_TeamManager(TeamManager teamManager, int add_or_remove){
        if(status == -1 || status == 0){
            return "The team is inactive so no activity can be performed on it";
        }
        //remove the teamManager
        if(add_or_remove == 0){
            if(list_TeamManager.contains(teamManager)){
                list_TeamManager.remove(teamManager);
                return "The Team Manager was successfully removed from the team.";
            }
            return "The Team Manager is not in the team.";
        }
        //add the teamManager
        else if(add_or_remove == 1){
            if(!list_TeamManager.contains(teamManager)){
                list_TeamManager.add(teamManager);
                return "he Team Manager was successfully added from the team.";
            }
            return "The Team Manager is already in the team.";
        }
        return "The action is invalid.";
    }

    /**
     * The function checks whether a particular role is part of the group. If so, he can take action on it.
     * @param object
     * @return
     */
    public boolean check_if_object_in_team(Subscription object){
        return list_TeamManager.contains(object) || list_TeamOwner.contains(object) ;
    }

    public String change_status(int status){
        String notify="";
        if(status == this.status){
           return "The group is already set" + this.status;
        }
        this.status = status;
        if (status==0){notify="The group "+this.Name+" is closed";}
        else if(status==1){notify="The group "+this.Name+" is open";}
        else if(status==2){notify="The group "+this.Name+" is permanently closed";}
        setChanged();
        notifyObservers(notify);
        return "The status of the group has changed successfully.";
    }

    public String getName() {
        return Name;
    }

    public PersonalPage getPersonalPage() {
        return PersonalPage;
    }

    //region Budget

    //TODO how to initialize budget?
    public void setInitialBudget(double amount){
        if(amount > 0)
            budget.setAmountForCurrentQuarter(amount);
    }

    public void startNewQuarterForBudget(double amount){
        budget.startNewQuarter(amount);
    }

    public ActionStatus addExpense(double expense, Expense description){
        return budget.addExpense(expense,description);
    }

    public ActionStatus addIncome(double income, Income description){
        return budget.addIncome(income,description);
    }

    public double getCurrentAmountInBudget(){
        return budget.getCurrentAmount();
    }

    public HashSet<TeamManager> getListTeamManager() {
        return list_TeamManager;
    }

    public HashSet<TeamOwner> getListTeamOwner() {
        return list_TeamOwner;
    }

    public Player getPlayer(String player_name){
        if ( player_name!=null) {
            for (Player p : list_Player) {
                if (p.getUserName().equals(player_name)) {
                    return p;
                }
            }
        }
        return null;
    }

}
