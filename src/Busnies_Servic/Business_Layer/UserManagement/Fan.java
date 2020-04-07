package Busnies_Servic.Business_Layer.UserManagement;
import Busnies_Servic.Action;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

public class Fan extends Subscription implements Observer{
    HashSet<Complaint> list_complaint;



    public boolean add_complaint(Complaint Complaint){

        return true;
    }


    public Fan(String arg_user_name, String arg_password) {
        super(arg_user_name, arg_password);
        permissions.edit_permissions(Action.watch_personal_page,1);
        permissions.edit_permissions(Action.write_complaint,1);
        permissions.edit_permissions(Action.Game_alerts,1);
        permissions.edit_permissions(Action.Search_History,1);

    }

    @Override
    public void update(Observable o, Object arg) {
        this.alerts.add((String)arg);
    }
}
