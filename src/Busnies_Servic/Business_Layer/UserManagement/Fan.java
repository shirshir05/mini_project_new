package Busnies_Servic.Business_Layer.UserManagement;
import Busnies_Servic.Action;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

public class Fan extends Subscription implements Observer{

    protected HashSet<Complaint> list_complaint;
    protected String name;

    public boolean add_complaint(Complaint complaint){
        if(!list_complaint.contains(complaint)) {
            list_complaint.add(complaint);
            return true;
        }
        else{
            return false;
        }
    }


    public Fan(String arg_user_name, String arg_password,String email) {
        super(arg_user_name, arg_password, email);
        permissions.edit_permissions(Action.watch_personal_page,1);
        permissions.edit_permissions(Action.write_complaint,1);
        permissions.edit_permissions(Action.Game_alerts,1);
        permissions.edit_permissions(Action.Search_History,1);
        list_complaint = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.alerts.add((String)arg);
    }


}
