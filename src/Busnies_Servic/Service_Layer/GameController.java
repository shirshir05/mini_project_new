package Busnies_Servic.Service_Layer;

import Busnies_Servic.Business_Layer.Game.Game;
import Busnies_Servic.Business_Layer.UserManagement.Referee;
import Busnies_Servic.EventType;

import java.util.Date;

public class GameController{

    public boolean create_game(Date date, String arg_host, String arg_guest, String arg_head, String linesman1, String linesman2){

        return true;
    }

    /**
     * This function lets a referee in a game to update a new event
     * @param game_id
     * @param team_name
     * @param player_name
     * @param event
     * @return true if operation succeeded
     */
    public boolean refereeCreateNewEvent(int game_id, String team_name, String player_name, EventType event ){
        Game game = DataManagement.getGame(game_id);
        if (DataManagement.getCurrent() instanceof Referee){
            // check if the referee is a referee of the team
            if (game.getHeadReferee().getUserName().equals(DataManagement.getCurrent().getUserName()) ||
                    game.getLinesman1Referee().getUserName().equals(DataManagement.getCurrent().getUserName()) ||
                    game.getLinesman2Referee().getUserName().equals(DataManagement.getCurrent().getUserName()) ){
                game.update_new_event(team_name,player_name,event);
                return true;
            }
        }
        return false;
    }

    /**
     * This function shows a referee which games he particiapates in
     * @return
     */
    public String refereeWatchGames(){
        if (DataManagement.getCurrent() instanceof Referee){
            Referee current = (Referee)DataManagement.getCurrent();
            return current.gamesListToString();
        }
        return "You are not a referee!";
    }

    /**
     * @param arg_name
     * @return
     */
    public boolean request_create_team(String arg_name){
        // בדיקה שה-current מורשה ליצור קבוצה
        // שליחת התראה לניצג ההתאחדות איך????????????????
        //
        return true;
    }

}
