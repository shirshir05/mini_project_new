package Busnies_Servic.Business_Layer.UserManagement;
import  Busnies_Servic.Business_Layer.Trace.PersonalPage;
import Busnies_Servic.Business_Layer.Trace.*;

import java.util.Observable;
import java.util.Observer;

public class Coach extends Subscription implements Observer {

    protected CoachPersonalPage PersonalPage;
    protected String qualification;
    protected String roleInTeam;

    public Coach(String arg_user_name, String arg_password,String email) {
        super(arg_user_name, arg_password,email);
        PersonalPage = new CoachPersonalPage(arg_user_name);
        permissions.add_default_player_or_coach_permission();
    }

    public CoachPersonalPage getPersonalPage() {
        return PersonalPage;
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

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setRoleInTeam(String roleInTeam) {
        this.roleInTeam = roleInTeam;
    }

    @Override
    public void update(Observable o, Object arg) {
    }

    @Override
    public String toString() {

        return "Coach: " + "\n" +
                "name: " + name + "\n" +
                "email: " + email + "\n" +
                "qualification: " + qualification + "\n" +
                "roleInTeam: " + roleInTeam;
    }
}