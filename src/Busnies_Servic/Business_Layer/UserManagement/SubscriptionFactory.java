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
    public Subscription Create(String userName, String password, Role role,String email){
        if(userName==null || password==null || role==null || userName.equals("") || password.equals("")) {
            return null;
        }
        if(role == Role.Coach ){
            return new Coach(userName,password, email);
        }
        else if (role ==Role.Fan){
            return new Fan(userName,password, email);
        }
        else if (role == Role.Guest){
            return new Guest(userName,password, email);
        }
        else if (role == Role.Players){
            return new Player(userName,password, email);
        }
        else if (role == Role.Referee){
            return new Referee(userName,password, email);
        }
        else if (role == Role.SystemAdministrator){
            return new SystemAdministrator(userName,password, email);
        }
        else if (role == Role.TeamManager){
            return new TeamManager(userName,password, email);
        }
        else if (role == Role.TeamOwner){
            return new TeamOwner(userName,password, email);
        }
        else if (role == Role.UnionRepresentative){
            return new UnionRepresentative(userName,password, email);
        }
        return null;
    }
}
