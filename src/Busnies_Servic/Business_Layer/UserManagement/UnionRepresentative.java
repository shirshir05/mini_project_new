package Busnies_Servic.Business_Layer.UserManagement;

import Busnies_Servic.Action;

import java.util.Observable;
import java.util.Observer;

public class UnionRepresentative extends Subscription implements Observer {

    public UnionRepresentative(String arg_user_name, String arg_password,String email) {
        super(arg_user_name, arg_password,email);
        permissions.edit_permissions(Action.define_league,1);
        permissions.edit_permissions(Action.define_season,1);
        permissions.edit_permissions(Action.appointment_referee,1);
        permissions.edit_permissions(Action.remove_referee,1);
        permissions.edit_permissions(Action.setting_referee_in_league,1);
        permissions.edit_permissions(Action.Calculation_Policy,1);
        permissions.edit_permissions(Action.setting_games,1);
        permissions.edit_permissions(Action.watch_game,1);

    }

    @Override
    public void update(Observable o, Object arg) {
        this.alerts.add((String)arg);
    }

    @Override
    public String toString() {

        return "UnionRepresentative: " + "\n" +
                "name: " + name + "\n" +
                "email: " + email;
    }
}
