package Busnies_Servic.Business_Layer.UserManagement;

import java.util.Observable;
import java.util.Observer;

public class TeamOwner extends Subscription  implements Observer{


    //teamOwner or SystemAdministrator
    protected Subscription appointed_by_teamOwner;
    protected

    public TeamOwner(String arg_user_name, String arg_password,String email) {
        super(arg_user_name, arg_password,email);
        appointed_by_teamOwner = null;
    }

    public Subscription getAppointed_by_teamOwner() {
        return appointed_by_teamOwner;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.alerts.add((String)arg);
    }

    /**
     * The function allows you to save who has appointed the group owner
     * @param appointed_by_teamOwner
     */
    public void setAppointed_by_teamOwner(Subscription appointed_by_teamOwner) {
        //Removing the appointed
        if(appointed_by_teamOwner == null){
            this.appointed_by_teamOwner = null;

        }else {
            permissions.add_default_owner_permission();
            this.appointed_by_teamOwner = appointed_by_teamOwner;
        }
    }

    @Override
    public String toString() {

        return "TeamOwner: " + "\n" +
                "name: " + name + "\n" +
                "email: " + email;
    }

}

