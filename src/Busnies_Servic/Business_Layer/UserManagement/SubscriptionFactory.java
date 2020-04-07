package Busnies_Servic.Business_Layer.UserManagement;
import Busnies_Servic.Role;


public class SubscriptionFactory {


    /**
     * This function create Subscription by Role
     * @param userName
     * @param password
     * @param role
     * @return
     */
    public Subscription Create(String userName, String password, Role role){
        if(userName==null || password==null || role==null || userName.equals("") || password.equals("")) {
            return null;
        }
        if(role == Role.Coach ){
            return new Coach(userName,password);
        }
        else if (role ==Role.Fan){
            return new Fan(userName,password);
        }
        else if (role == Role.Guest){
            return new Guest(userName,password);
        }
        else if (role == Role.Players){
            return new Player(userName,password);
        }
        else if (role == Role.Referee){
            return new Referee(userName,password);
        }
        else if (role == Role.SystemAdministrator){
            return new SystemAdministrator(userName,password);
        }
        else if (role == Role.TeamManager){
            return new TeamManager(userName,password);
        }
        else if (role == Role.TeamOwner){
            return new TeamOwner(userName,password);
        }
        else if (role == Role.UnionRepresentative){
            return new UnionRepresentative(userName,password);
        }
        return null;
    }
}
