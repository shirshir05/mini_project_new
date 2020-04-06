package Busnies_Servic.Business_Layer.UserManagement;

public class SubscriptionFactory {


    public Subscription Create(String arg_user_name, String arg_password, int role){
        if(role == 0 ){
            return new Coach(arg_user_name,arg_password);
        }
        else if (role ==1){
            return new Fan(arg_user_name,arg_password);
        }
        else if (role == 2){
            return new Guest(arg_user_name,arg_password);
        }
        else if (role == 3){
            return new Player(arg_user_name,arg_password);
        }
        else if (role == 4){
            return new Referee(arg_user_name,arg_password);
        }
        else if (role == 5){
            return new SystemAdministrator(arg_user_name,arg_password);
        }
        else if (role == 6){
            return new TeamManager(arg_user_name,arg_password);
        }
        else if (role == 7){
            return new TeamOwner(arg_user_name,arg_password);
        }
        else if (role == 8){
            return new UnionRepresentative(arg_user_name,arg_password);
        }
        return null;
    }



}
