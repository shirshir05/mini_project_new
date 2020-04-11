package Busnies_Servic.Business_Layer.UserManagement;

import Busnies_Servic.Action;
import java.util.Observable;
import java.util.Observer;

public class TeamOwner extends Subscription  implements Observer{


    //teamOwner or SystemAdministrator
    Subscription appointed_by_teamOwner;
    protected String name;

    public TeamOwner(String arg_user_name, String arg_password,String email) {
        super(arg_user_name, arg_password,email);
        appointed_by_teamOwner = null;
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
            permissions.edit_permissions(Action.Edit_team,0);
            permissions.edit_permissions(Action.Appointment_of_team_owner,0);
            permissions.edit_permissions(Action.Remove_Appointment_of_team_owner,0);
            permissions.edit_permissions(Action.Appointment_of_team_manager,0);
            permissions.edit_permissions(Action.Remove_Appointment_of_team_manager,0);
            permissions.edit_permissions(Action.Close_team,0);
            permissions.edit_permissions(Action.financial,0);
            return;
        }
        permissions.edit_permissions(Action.Edit_team,1);
        permissions.edit_permissions(Action.Appointment_of_team_owner,1);
        permissions.edit_permissions(Action.Remove_Appointment_of_team_owner,1);
        permissions.edit_permissions(Action.Appointment_of_team_manager,1);
        permissions.edit_permissions(Action.Remove_Appointment_of_team_manager,1);
        permissions.edit_permissions(Action.Close_team,1);
        permissions.edit_permissions(Action.financial,1);
        this.appointed_by_teamOwner = appointed_by_teamOwner;
        return;
    }

    public Subscription getAppointed_by_teamOwner() {
        return appointed_by_teamOwner;
    }


}

