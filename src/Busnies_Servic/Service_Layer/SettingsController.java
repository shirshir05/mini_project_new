package Busnies_Servic.Service_Layer;

import Busnies_Servic.Business_Layer.Game.League;
import Busnies_Servic.Business_Layer.UserManagement.Referee;

import java.sql.Ref;
import java.time.Year;

public class SettingsController extends LogicManagement{


    /**
     * this function let the union rep to define a leauge
     * @param name is the name of the leauge
     * @return true if it was defined
     */
    public boolean defineLeaugue(String name){
        if (name!=null) {
            this.list_league.add(new League(name));
            return true;
        }
        return false;
    }

    /**
     * this dunction let the union rep to define a season to a leauge
     * @param league_name is the name of the leauge
     * @param year is the season
     * @return true if the season was updated
     */
    public boolean defineSeasonToLeague(String league_name, String year){
        Year year_format = Year.parse(year);
        if (year_format.isAfter(Year.of(1900)) && league_name!=null && findLeauge(league_name)!=null){
            this.findLeauge(league_name).set_season(year_format);
            return true;
        }
        return false;
    }

    public boolean defineRefereeInLeauge(String leauge_name, String referee_user_name, String referee_password) {
        League league = findLeauge(leauge_name);
        if (league != null) {
            Referee new_referee = new Referee(referee_user_name, referee_user_name);
            league.add_referee(new_referee);
            return true;
        }
        return false;
    }

    public boolean deleteRefereeFromLeague(String league_name, String referee_user_name){
        League league = findLeauge(league_name);
        if (league!=null){
            Referee referee = league.getReferee(referee_user_name);
            if(referee!=null){
                league.delete_referee(referee);
                return true;
            }
        }
        return false;
    }


}
