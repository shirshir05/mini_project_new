package Busnies_Servic.Business_Layer.UserManagement;

import Busnies_Servic.Action;

import java.util.HashMap;
import java.util.HashSet;

public class Permissions {

    private HashSet<Action> list_Permissions;

    /**
     * Constructor that initializes all object fields by 0 (no permission)
     */
    public Permissions(){
        list_Permissions = new HashSet<>();
    }

    public void add_default_fan_permission(){
        list_Permissions.add(Action.write_complaint);
        list_Permissions.add(Action.Search_History);
    }

    public void add_default_player_or_coach_permission(){
        list_Permissions.add(Action.personal_page);
    }

    public void add_default_owner_permission(){
        list_Permissions.add(Action.Edit_team);
        list_Permissions.add(Action.Appointment_of_team_owner);
        list_Permissions.add(Action.Remove_Appointment_of_team_owner);
        list_Permissions.add(Action.Appointment_of_team_manager);
        list_Permissions.add(Action.Remove_Appointment_of_team_manager);
        list_Permissions.add(Action.Appointment_of_player);
        list_Permissions.add(Action.Remove_Appointment_of_player);
        list_Permissions.add(Action.Team_financial);
        list_Permissions.add(Action.Close_team);
    }


    public void add_default_admin_permission(){
        list_Permissions.add(Action.Close_team_perpetually);
        list_Permissions.add(Action.Removing_Subscriptions);
        list_Permissions.add(Action.Respond_to_complaints);
        list_Permissions.add(Action.watch_log);
        list_Permissions.add(Action.Recommendation_system);
    }

    public void add_default_union_permission(){
        list_Permissions.add(Action.define_league);
        list_Permissions.add(Action.define_season);
        list_Permissions.add(Action.appointment_referee);
        list_Permissions.add(Action.remove_referee);
        list_Permissions.add(Action.setting_referee_in_league);
        list_Permissions.add(Action.Calculation_Policy);
        list_Permissions.add(Action.setting_games);
        list_Permissions.add(Action.setting_games_Policy);
        list_Permissions.add(Action.uniun_financial);
    }

    public void add_default_referee_permission(){
        list_Permissions.add(Action.update_event);
    }

    /**
     * @param action
     */
    public void add_permissions(Action action){
        list_Permissions.add(action);
    }

    /*
     * @param action
     */
    public void remove_permissions(Action action){
        if(list_Permissions.contains(action)) {
            list_Permissions.remove(action);
        }
    }


    /**
     * @param action
     * @return true if has permission
     */
    public boolean check_permissions(Action action){
        return list_Permissions.contains(action);
    }

}
