package Busnies_Servic.Business_Layer.UserManagement;

import Busnies_Servic.Action;

import java.util.HashMap;

public class Permissions {

    private HashMap<Action,Integer> list_Permissions;

    /**
     * Constructor that initializes all object fields by 0 (no permission)
     */
    public Permissions(){
        list_Permissions = new HashMap<>();
        list_Permissions.put(Action.watch_personal_page,0);
        list_Permissions.put(Action.Game_alerts,0);
        list_Permissions.put(Action.write_complaint,0);
        list_Permissions.put(Action.Search_History,0);
        list_Permissions.put(Action.Upload_personal_page,0);
        list_Permissions.put(Action.Edit_team,0);
        list_Permissions.put(Action.Appointment_of_team_owner,0);
        list_Permissions.put(Action.Remove_Appointment_of_team_owner,0);
        list_Permissions.put(Action.Appointment_of_team_manager,0);
        list_Permissions.put(Action.Remove_Appointment_of_team_manager,0);
        list_Permissions.put(Action.Close_team,0);
        list_Permissions.put(Action.Close_team_perpetually,0);
        list_Permissions.put(Action.financial,0);
        list_Permissions.put(Action.Removing_Subscriptions,0);
        list_Permissions.put(Action.Respond_to_complaints,0);
        list_Permissions.put(Action.watch_log,0);
        list_Permissions.put(Action.Recommendation_system,0);
        list_Permissions.put(Action.define_league,0);
        list_Permissions.put(Action.define_season,0);
        list_Permissions.put(Action.appointment_referee,0);
        list_Permissions.put(Action.remove_referee,0);
        list_Permissions.put(Action.setting_referee_in_league,0);
        list_Permissions.put(Action.Calculation_Policy,0);
        list_Permissions.put(Action.setting_games,0);
        list_Permissions.put(Action.watch_game,0);
        list_Permissions.put(Action.update_event,0);
    }


    /**
     * @param action
     * @param zero_or_one
     */
    public void edit_permissions(Action action, Integer zero_or_one){
        list_Permissions.put(action,zero_or_one);
    }

    /**
     * @param action
     * @return 1 if has permission
     */
    public Integer check_permissions(Action action){
        return list_Permissions.get(action);
    }


}
