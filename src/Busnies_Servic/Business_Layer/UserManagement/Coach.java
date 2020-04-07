package Busnies_Servic.Business_Layer.UserManagement;
import  Busnies_Servic.Business_Layer.Trace.PersonalPage;
import Busnies_Servic.Business_Layer.Trace.*;

import java.util.Observable;
import java.util.Observer;

public class Coach extends Subscription implements Observer {
    CoachPersonalPage PersonalPage;
    protected String qualification;

    public void setPersonalPage(CoachPersonalPage personalPage) {
        PersonalPage = personalPage;
    }

    public PersonalPage getPersonalPage() {
        return PersonalPage;
    }

    public Coach(String arg_user_name, String arg_password) {
        super(arg_user_name, arg_password);
        PersonalPage = new CoachPersonalPage(arg_user_name);
    }

    @Override
    public void update(Observable o, Object arg) {
    }

}