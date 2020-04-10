package Busnies_Servic.Service_Layer;
// all Subscription in system
import Busnies_Servic.Business_Layer.Game.Game;
import Busnies_Servic.Business_Layer.Game.League;
import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Business_Layer.UserManagement.SubscriptionFactory;
import Busnies_Servic.Role;
import DBconnection.stateTaxSystem;
import DBconnection.unionFinanceSystem;

import java.util.HashSet;

public final class LogicManagement {

    private static final LogicManagement instance = new LogicManagement();



    // A list that keeps all the subscriptions that are currently subscribed to the system
    private static HashSet<Subscription>  Subscription = new HashSet<>();

    private static HashSet<Team> list_team = new HashSet<>();

    private static HashSet<Game> list_game = new HashSet<>();

    private static HashSet<League> list_league = new HashSet<>();

    // Saves the current subscription that is currently being registered to the system
    private static Subscription current;

    private stateTaxSystem taxSys;

    private unionFinanceSystem financeSys;

    public static LogicManagement getInstance() {
        return instance;
    }

    /**
     * singleton constructor to initialize the parameters
     */
    private LogicManagement() {
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


    /**
     * The function accepts a string with the role name and returns Enum.
     * @param arg_role
     * @return Role or null if the tole not found
     */
    protected static Role return_enum(String arg_role){
        Role enum_role =  Role.valueOf(arg_role);
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
    protected static Game find_game(int game_id){
        for ( Game g: list_game ){
            if (g.get_game_id()==game_id)
                return g;
        }
        return null;
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
    }

    public static HashSet getListTeam(){
        return list_team;
    }

}
