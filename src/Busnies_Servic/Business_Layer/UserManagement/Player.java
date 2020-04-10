package Busnies_Servic.Business_Layer.UserManagement;


import Busnies_Servic.Business_Layer.Trace.PlayerPersonalPage;

import java.security.ProtectionDomain;
import java.util.Date;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Player extends Subscription implements Observer {

    protected PlayerPersonalPage PersonalPage;
    protected String position;
    protected Date birthday;
    protected String name;

    public void setPersonalPage(PlayerPersonalPage personalPage) {
        PersonalPage = personalPage;
    }

    public PlayerPersonalPage getPersonalPage() {
        return PersonalPage;
    }

    public Player(String arg_user_name, String arg_password) {
        super(arg_user_name, arg_password);
        PersonalPage=new PlayerPersonalPage(arg_user_name);

    }

    public String getPosition() {
        return position;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.alerts.add((String)arg);
    }

}
