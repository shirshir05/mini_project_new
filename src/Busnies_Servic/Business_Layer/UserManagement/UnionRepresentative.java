package Busnies_Servic.Business_Layer.UserManagement;

import java.util.Observable;
import java.util.Observer;

public class UnionRepresentative extends Subscription implements Observer {

    protected String name;
    public UnionRepresentative(String arg_user_name, String arg_password,String email) {
        super(arg_user_name, arg_password,email);
        permissions.add_default_union_permission();
    }


    @Override
    public void update(Observable o, Object arg) {
        this.alerts.add((String)arg);
    }
}
