package Busnies_Servic.Business_Layer.UserManagement;

import Busnies_Servic.PermissionAction;

import java.util.HashSet;

public class Permissions {

    private HashSet<PermissionAction> list_Permissions;

    /**
     * Constructor that initializes all object fields by 0 (no permission)
     */
    public Permissions(){
        list_Permissions = new HashSet<>();
    }

    public void add_default_fan_permission(){
        list_Permissions.add(PermissionAction.write_complaint);
        list_Permissions.add(PermissionAction.Search_History);
    }

    public void add_default_player_or_coach_permission(){
        list_Permissions.add(PermissionAction.personal_page);
    }

    public void add_default_owner_permission(){
        list_Permissions.add(PermissionAction.Edit_team);
        list_Permissions.add(PermissionAction.Appointment_of_team_owner);
        list_Permissions.add(PermissionAction.Remove_Appointment_of_team_owner);
        list_Permissions.add(PermissionAction.Appointment_of_team_manager);
        list_Permissions.add(PermissionAction.Remove_Appointment_of_team_manager);
        list_Permissions.add(PermissionAction.Appointment_of_player);
        list_Permissions.add(PermissionAction.Remove_Appointment_of_player);
        list_Permissions.add(PermissionAction.Team_financial);
        list_Permissions.add(PermissionAction.Close_team);
    }


    public void add_default_admin_permission(){
        list_Permissions.add(PermissionAction.Close_team_perpetually);
        list_Permissions.add(PermissionAction.Removing_Subscriptions);
        list_Permissions.add(PermissionAction.Respond_to_complaints);
        list_Permissions.add(PermissionAction.watch_log);
        list_Permissions.add(PermissionAction.Recommendation_system);
    }

    public void add_default_union_permission(){
        list_Permissions.add(PermissionAction.define_league);
        list_Permissions.add(PermissionAction.define_season);
        list_Permissions.add(PermissionAction.appointment_referee);
        list_Permissions.add(PermissionAction.remove_referee);
        list_Permissions.add(PermissionAction.setting_referee_in_league);
        list_Permissions.add(PermissionAction.Calculation_Policy);
        list_Permissions.add(PermissionAction.setting_games);
        list_Permissions.add(PermissionAction.setting_games_Policy);
        list_Permissions.add(PermissionAction.uniun_financial);
    }

    public void add_default_referee_permission(){
        list_Permissions.add(PermissionAction.update_event);
    }

    /**
     * @param action
     */
    public void add_permissions(PermissionAction action){
        list_Permissions.add(action);
    }

    /*
     * @param action
     */
    public void remove_permissions(PermissionAction action){
        if(list_Permissions.contains(action)) {
            list_Permissions.remove(action);
        }
    }


    /**
     * @param action
     * @return true if has permission
     */
    public boolean check_permissions(PermissionAction action){
        return list_Permissions.contains(action);
    }

}
