package Busnies_Servic.Business_Layer.UserManagement;

import java.util.Observable;
import java.util.Observer;

public class SystemAdministrator extends Subscription implements Observer{

    public SystemAdministrator(String arg_user_name, String arg_password,String email) {
        super(arg_user_name, arg_password,email);
        permissions.add_default_admin_permission();
    }

    public boolean approve_create_team(){

        return true;
    }

    public boolean change_status_team(int status, String name_team){

        return true;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.alerts.add((String)arg);
    }

    @Override
    public String toString() {

        return "SystemAdministrator: " + "\n" +
                "name: " + name + "\n" +
                "email: " + email;
    }

}
