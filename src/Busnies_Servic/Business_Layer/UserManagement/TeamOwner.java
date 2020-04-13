package Busnies_Servic.Business_Layer.UserManagement;

import Busnies_Servic.PermissionAction;

import java.util.Observable;
import java.util.Observer;

public class TeamOwner extends Subscription  implements Observer{


    //teamOwner or SystemAdministrator
    protected Subscription appointedByTeamOwner;

    public TeamOwner(String arg_user_name, String arg_password,String email) {
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
        //Removing the appointed
        if(appointedByTeamOwner == null){
            this.appointedByTeamOwner = null;
            permissions.remove_permissions(PermissionAction.Edit_team);
            permissions.remove_permissions(PermissionAction.Appointment_of_team_owner);
            permissions.remove_permissions(PermissionAction.Remove_Appointment_of_team_owner);
            permissions.remove_permissions(PermissionAction.Appointment_of_team_manager);
            permissions.remove_permissions(PermissionAction.Remove_Appointment_of_team_manager);
            permissions.remove_permissions(PermissionAction.Appointment_of_player);
            permissions.remove_permissions(PermissionAction.Close_team);
            permissions.remove_permissions(PermissionAction.Team_financial);
            permissions.remove_permissions(PermissionAction.Remove_Appointment_of_player);

        }else {
            permissions.add_default_owner_permission();
            this.appointedByTeamOwner = appointedByTeamOwner;
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        this.alerts.add((String)arg);
    }


    @Override
    public String toString() {

        return "TeamOwner: " + "\n" +
                "name: " + name + "\n" +
                "email: " + email;
    }

}

