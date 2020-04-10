package Busnies_Servic.Business_Layer.UserManagement;


import Busnies_Servic.Business_Layer.Trace.PlayerPersonalPage;

import java.security.ProtectionDomain;
import java.util.Date;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Player extends Subscription implements Observer {
    protected PlayerPersonalPage PersonalPage;
    protected String role;
    protected Date birthday;

    public void setPersonalPage(PlayerPersonalPage personalPage) {
        PersonalPage = personalPage;
    }

    public PlayerPersonalPage getPersonalPage() {
        return PersonalPage;
    }

    public Player(String arg_user_name, String arg_password,String email) {
        super(arg_user_name, arg_password,email);
        PersonalPage=new PlayerPersonalPage(arg_user_name);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.alerts.add((String)arg);
    }

}
