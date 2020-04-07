package Busnies_Servic.Service_Layer;
// all Subscription in system
import Busnies_Servic.Business_Layer.Game.Game;
import Busnies_Servic.Business_Layer.Game.League;
import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Business_Layer.UserManagement.SubscriptionFactory;
import Busnies_Servic.Role;
import java.util.HashSet;

public class LogicManagement {

    SubscriptionFactory factory;

    // A list that keeps all the subscriptions that are currently subscribed to the system
    HashSet<Subscription>  Subscription;

    // Saves the current subscription that is currently being registered to the system
    Subscription Current;

    HashSet<Team> list_team = new HashSet<>();

    HashSet<Game> list_game = new HashSet<>();

    HashSet<League> list_league = new HashSet<>();


    /**
     * Constructor to initialize the parameters
     */
    public LogicManagement(){
        Subscription = new HashSet<>();
        Current = null;
        factory = new SubscriptionFactory();
    }


    /**
     * A function is to check if there is a subscription in the system by username.
     * @param arg_user_name
     * @return Subscription
     */
    public Subscription contain_subscription(String arg_user_name){
        for (Subscription  subscription : Subscription) {
            if (subscription.getUser_name().equals(arg_user_name)){
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
    protected Role return_enum(String arg_role){
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
    protected Team findTeam(String arg_user_to_register) {
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
    protected Game find_game(int game_id){
        for ( Game g: list_game ){
            if (g.get_game_id()==game_id)
                return g;
        }
        return null;
    }




}
