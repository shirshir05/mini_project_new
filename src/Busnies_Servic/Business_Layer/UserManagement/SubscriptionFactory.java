package Busnies_Servic.Business_Layer.UserManagement;
import Busnies_Servic.Role;


public class SubscriptionFactory {


    /**
     * This function create Subscription by Role
     * @param arg_user_name
     * @param arg_password
     * @param role
     * @return
     */
    public Subscription Create(String arg_user_name, String arg_password, Role role){
        if(role == Role.Coach ){
            return new Coach(arg_user_name,arg_password);
        }
        else if (role ==Role.Fan){
            return new Fan(arg_user_name,arg_password);
        }
        else if (role == Role.Guest){
            return new Guest(arg_user_name,arg_password);
        }
        else if (role == Role.Players){
            return new Player(arg_user_name,arg_password);
        }
        else if (role == Role.Referee){
            return new Referee(arg_user_name,arg_password);
        }
        else if (role == Role.SystemAdministrator){
            return new SystemAdministrator(arg_user_name,arg_password);
        }
        else if (role == Role.TeamManager){
            return new TeamManager(arg_user_name,arg_password);
        }
        else if (role == Role.TeamOwner){
            return new TeamOwner(arg_user_name,arg_password);
        }
        else if (role == Role.UnionRepresentative){
            return new UnionRepresentative(arg_user_name,arg_password);
        }
        return null;
    }



}
