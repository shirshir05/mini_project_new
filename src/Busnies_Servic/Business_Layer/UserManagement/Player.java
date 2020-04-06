package Busnies_Servic.Business_Layer.UserManagement;


import Busnies_Servic.Business_Layer.Trace.PlayerPersonalPage;

import java.util.Date;

import java.util.Observable;
import java.util.Observer;

public class Player extends Subscription implements Observer {
    PlayerPersonalPage PersonalPage;
    String role;
    Date birthday;

    public void setPersonalPage(PlayerPersonalPage personalPage) {
        PersonalPage = personalPage;
    }

    public PlayerPersonalPage getPersonalPage() {
        return PersonalPage;
    }

    public Player(String arg_user_name, String arg_password) {
        super(arg_user_name, arg_password);
        // add permissions og the role
        // permissions.add_permissions(1,0)
        PersonalPage=new PlayerPersonalPage(arg_user_name);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.alerts.add((String)arg);
    }

}
