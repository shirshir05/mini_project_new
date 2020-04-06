package Busnies_Servic.Business_Layer.UserManagement;

import java.util.Observable;
import java.util.Observer;

public class TeamManager extends Subscription  implements Observer{



    public TeamManager(String arg_user_name, String arg_password) {
        super(arg_user_name, arg_password);

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
