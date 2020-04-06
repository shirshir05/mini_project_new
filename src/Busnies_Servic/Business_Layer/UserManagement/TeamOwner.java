package Busnies_Servic.Business_Layer.UserManagement;

import Busnies_Servic.Action;
import java.util.Observable;
import java.util.Observer;

public class TeamOwner extends Subscription  implements Observer{


    public TeamOwner(String arg_user_name, String arg_password) {
        super(arg_user_name, arg_password);
        permissions.edit_permissions(Action.Edit_team,1);
        permissions.edit_permissions(Action.Appointment_of_team_owner,1);
        permissions.edit_permissions(Action.Remove_Appointment_of_team_owner,1);
        permissions.edit_permissions(Action.Appointment_of_team_manager,1);
        permissions.edit_permissions(Action.Remove_Appointment_of_team_manager,1);
        permissions.edit_permissions(Action.Close_team,1);
        permissions.edit_permissions(Action.financial,1);
    }


    @Override
    public void update(Observable o, Object arg) {

    }


}

