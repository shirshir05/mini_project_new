package Busnies_Servic.Service_Layer;
// all Subscription in system
import Busnies_Servic.Business_Layer.Game.Game;
import Busnies_Servic.Business_Layer.Game.League;
import Busnies_Servic.Business_Layer.TeamManagement.Team;

import Busnies_Servic.Business_Layer.UserManagement.Referee;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Business_Layer.UserManagement.SubscriptionFactory;
import Busnies_Servic.Business_Layer.UserManagement.UnionRepresentative;
import Busnies_Servic.Business_Layer.UserManagement.*;
import Busnies_Servic.Role;
import DBconnection.stateTaxSystem;
import DBconnection.unionFinanceSystem;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public final class DataManagement {

    private static final DataManagement instance = new DataManagement();



    // A list that keeps all the subscriptions that are currently subscribed to the system
    private static HashSet<Subscription>  Subscription = new HashSet<>();

    private static HashSet<Team> list_team = new HashSet<>();

    private static HashSet<Game> list_game = new HashSet<>();

    private static HashSet<League> list_league = new HashSet<>();

    private static HashSet<Complaint> list_Complaints = new HashSet<>();


    // Saves the current subscription that is currently being registered to the system
    private static Subscription current;

    private stateTaxSystem taxSys;

    private unionFinanceSystem financeSys;

    /**
     * singleton constructor to initialize the parameters
     */
    private DataManagement() {
        if (instance == null) {
            //Prevent Reflection
            throw new IllegalStateException("Cannot instantiate a new singleton instance of logic management");

        }
        this.createLogicManagement();
    }



    /**
     * singleton initialize the parameters
     */
    private void createLogicManagement(){
        //initialize system and connections
        financeSys = new unionFinanceSystem();
        boolean checkSystem1 = financeSys.initConnection();
        taxSys = new stateTaxSystem();
        boolean checkSystem2 = taxSys.initConnection();
    }



    /**
     * A function is to check if there is a subscription in the system by username.
     * @param arg_user_name
     * @return Subscription
     */
    public static Subscription contain_subscription(String arg_user_name){
        for (Subscription  subscription : Subscription) {
            if (subscription.getUserName().equals(arg_user_name)){
                return subscription;
            }
        }
        return null;
    }

    private static boolean isInEnum(String value) {
        return Arrays.stream(Role.values()).anyMatch(e -> e.name().equals(value));
    }


    /**
     * The function accepts a string with the role name and returns Enum.
     * @param arg_role
     * @return Role or null if the tole not found
     */
    protected static Role return_enum(String arg_role){
        Role enum_role =  Role.valueOf(arg_role);
        if (!isInEnum(arg_role)) {

            return null;
        }
        switch (enum_role) {
            case Coach:
                return Role.Coach;
            case Fan:
                return Role.Fan;
            case Guest:
                return Role.Guest;
            case Players:
                return Role.Players;
            case Referee:
                return Role.Referee;
            case SystemAdministrator:
                return Role.SystemAdministrator;
            case TeamManager:
                return Role.TeamManager;
            case TeamOwner:
                return Role.TeamOwner;
            case UnionRepresentative:
                return Role.UnionRepresentative;
            default:
                return null;
        }
    }


    /**
     * @param arg_user_to_register
     * @return
     */
    protected static Team findTeam(String arg_user_to_register) {
        for (Team t : list_team){
            if (t.getName().equals(arg_user_to_register))
                return t;
        }
        return null;
    }

    /**
     * This function get game_id and return Game
     * @param game_id
     * @return
     */
    protected static Game getGame(int game_id){
        for ( Game g: list_game ){
            if (g.get_game_id()==game_id)
                return g;
        }
        return null;
    }

    /**
     * This function gets a leaugeName and return Leauge
     * @param leaugeName
     * @return
     */
    protected static League findLeauge(String leaugeName) {
        for (League l : list_league) {
            if (l.getName().equals(leaugeName)) {
                return l;
            }
        }
        return null;
    }

    protected static Subscription findSubscription(String subscription_name){
        for (Subscription s : Subscription){
            if (s.getUserName().equals(subscription_name)){
                return s;
            }
        }
        return null;
    }

    protected static ArrayList<UnionRepresentative> getUnionRepresentatives(){
        ArrayList<UnionRepresentative> unionReps = new ArrayList<>();
        for(Subscription s: Subscription){
            if(s instanceof UnionRepresentative)
                unionReps.add((UnionRepresentative)s);
        }
        return unionReps;
    }



    public static void setSubscription(Subscription sub){
        Subscription.add(sub);
    }

    public static void removeSubscription(String user_name){
        Subscription.remove(contain_subscription(user_name));
    }

    public static void setCurrent(Subscription sub){
        current = sub;
    }

    public static Subscription getCurrent(){
        return current;
    }

    public static void addToListTeam(Team team){
        list_team.add(team);
        HashSet<SystemAdministrator> list = getSystemAdministratorsList();
        for (SystemAdministrator s : list){
            team.addObserver(s);
        }
    }

    public static HashSet getListTeam(){
        return list_team;

    }

    public static void addToListLeague(League league){
        list_league.add(league);
    }

    public static HashSet getListLeague(){
        return list_league;
    }

    /**
     * This function returns a list of all the System Administrators in the system
     * @return
     */
    public static HashSet<SystemAdministrator> getSystemAdministratorsList(){
        HashSet<SystemAdministrator> list = new HashSet<>();
        for (Subscription s : Subscription){
            if (s instanceof SystemAdministrator){
                list.add((SystemAdministrator)s);
            }
        }
        return list;
    }

    public static void setComplaint(String complaint){
        Complaint new_complaint = new Complaint(complaint);
        HashSet<SystemAdministrator> list = getSystemAdministratorsList();
        for (SystemAdministrator s : list){
            new_complaint.addObserver(s);
        }
        new_complaint.notify_all();
        list_Complaints.add(new_complaint);
    }

}
