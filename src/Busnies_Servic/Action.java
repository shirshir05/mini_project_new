package Busnies_Servic;

public enum Action {
  watch_personal_page, Game_alerts, write_complaint, Search_History,
        Upload_personal_page, Edit_team
        /* only team_owner can open team*/
         , Appointment_of_team_owner,
        Remove_Appointment_of_team_owner, Appointment_of_team_manager,
        Remove_Appointment_of_team_manager,Close_team, Close_team_perpetually,
        financial,Removing_Subscriptions, Respond_to_complaints, watch_log,
        Recommendation_system, define_league, define_season,appointment_referee, remove_referee,
      setting_referee_in_league,Calculation_Policy, setting_games, watch_game, update_event
}
