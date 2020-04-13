package Busnies_Servic.Business_Layer.UserManagement;
import  Busnies_Servic.Business_Layer.Trace.PersonalPage;
import Busnies_Servic.Business_Layer.Trace.*;

import java.util.Observable;
import java.util.Observer;

public class Coach extends Subscription {

    protected CoachPersonalPage PersonalPage;
    protected String qualification;
    protected String roleInTeam;

    public Coach(String arg_user_name, String arg_password,String email) {
        super(arg_user_name, arg_password,email);
        PersonalPage = new CoachPersonalPage(arg_user_name);
        permissions.add_default_player_or_coach_permission();
    }

    }

    /**
     * Get of Coach Qualification
     * @return
     */
    public String getQualification() {
        return qualification;
    }


    public String getRoleInTeam() {
        return roleInTeam;
    }

    public void setPersonalPage(CoachPersonalPage personalPage) {
        PersonalPage = personalPage;
    }
   public CoachPersonalPage getPersonalPage() {
        return PersonalPage;
    }

      /**
     * Placement of Coach Qualification
     * @param qualification
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * Placement of a role in the group
     * @param roleInTeam
     */
    public void setRoleInTeam(String roleInTeam) {
        this.roleInTeam = roleInTeam;
    }


    /**
     * Get of a role in the group
     * @return
     */
    public String getRoleInTeam() {
        return roleInTeam;
    }


    /**
     * @return
     */
    @Override
    public String toString() {

        return "Coach: " + "\n" +
                "name: " + name + "\n" +
                "email: " + email + "\n" +
                "qualification: " + qualification + "\n" +
                "roleInTeam: " + roleInTeam;
    }


    /**
     * @param personalPage
     */
    public void setPersonalPage(CoachPersonalPage personalPage) {
        PersonalPage = personalPage;
    }

    /**
     * @return
     */
    public PersonalPage getPersonalPage() {
        return PersonalPage;
    }

}