package Busnies_Servic.Business_Layer.UserManagement;
import  Busnies_Servic.Business_Layer.Trace.PersonalPage;
import Busnies_Servic.Business_Layer.Trace.*;

import java.util.Observable;
import java.util.Observer;

public class Coach extends Subscription implements Observer {

    protected String name;
    protected CoachPersonalPage PersonalPage;
    protected String qualification;
    protected String roleInTeam;

    public Coach(String arg_user_name, String arg_password) {
        super(arg_user_name, arg_password);
        PersonalPage = new CoachPersonalPage(arg_user_name);
    }

    public PersonalPage getPersonalPage() {
        return PersonalPage;
    }

    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public String getRoleInTeam() {
        return roleInTeam;
    }


    public void setPersonalPage(CoachPersonalPage personalPage) {
        PersonalPage = personalPage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setRoleInTeam(String roleInTeam) {
        this.roleInTeam = roleInTeam;
    }

    @Override
    public void update(Observable o, Object arg) {
    }

}