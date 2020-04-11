package Busnies_Servic.Business_Layer.UserManagement;

import Busnies_Servic.Action;

import java.util.Observable;
import java.util.Observer;

public class TeamManager extends Subscription  implements Observer{

    Subscription appointed_by_teamOwner;
    protected String name;


    public TeamManager(String arg_user_name, String arg_password,String email) {
        super(arg_user_name, arg_password,email);
        appointed_by_teamOwner = null;
    }
    /**
     * The function allows you to save who has appointed the group owner
     * @param appointed_by_teamOwner
     */
    public void setAppointed_by_teamOwner(Subscription appointed_by_teamOwner) {
        this.appointed_by_teamOwner = appointed_by_teamOwner;
    }

    public Subscription getAppointed_by_teamOwner() {
        return appointed_by_teamOwner;
    }


    @Override
    public void update(Observable o, Object arg) {
        this.alerts.add((String)arg);
    }}
