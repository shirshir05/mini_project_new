package Busnies_Servic.Business_Layer.UserManagement;

import java.util.Observable;
import java.util.Observer;

public class TeamManager extends Subscription  implements Observer{

    Subscription appointedByTeamOwner;
    protected String name;


    public TeamManager(String arg_user_name, String arg_password,String email) {
        super(arg_user_name, arg_password,email);
        appointedByTeamOwner = null;
    }

    public Subscription getAppointedByTeamOwner() {
        return appointedByTeamOwner;
    }

    /**
     * The function allows you to save who has appointed the group owner
     * @param appointedByTeamOwner
     */
    public void setAppointedByTeamOwner(Subscription appointedByTeamOwner) {
        this.appointedByTeamOwner = appointedByTeamOwner;
    }


    /**
     * Add alert
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        this.alerts.add((String)arg);
    }

    @Override
    public String toString() {
        return "TeamManager: " + "\n" + "name: " + name + "\n" + "email: " + email; }

}


