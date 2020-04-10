package Busnies_Servic.Business_Layer.UserManagement;

import Busnies_Servic.Action;

public class UnionRepresentative extends Subscription{

    protected String name;

    public UnionRepresentative(String arg_user_name, String arg_password) {
        super(arg_user_name, arg_password);
        permissions.edit_permissions(Action.define_league,1);
        permissions.edit_permissions(Action.define_season,1);
        permissions.edit_permissions(Action.appointment_referee,1);
        permissions.edit_permissions(Action.remove_referee,1);
        permissions.edit_permissions(Action.setting_referee_in_league,1);
        permissions.edit_permissions(Action.Calculation_Policy,1);
        permissions.edit_permissions(Action.setting_games,1);
        permissions.edit_permissions(Action.watch_game,1);

    }




}
