package Busnies_Servic.Service_Layer;

import Busnies_Servic.Business_Layer.Game.League;
import Busnies_Servic.Business_Layer.Game.Season;
import Busnies_Servic.Business_Layer.UserManagement.Referee;

public class SettingsController extends DataManagement {


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
        if (year!=null && league_name!=null) {
            int intFormatYear= Integer.parseInt(year);
            if (intFormatYear>1900 && intFormatYear<2021)
                this.findLeauge(league_name).addSeason(new Season(year));
            return true;
        }
        return false;
    }

    /**
     * This function let the union rep to add a referee to the system
     * @param referee_user_name is the username of the referee
     * @param referee_password is the password of the referee
     * @return true if the operation succeeded
     */
    public boolean addRefereeToSystem(String referee_user_name, String referee_password){
        if (referee_user_name!=null && referee_password!=null){
            Referee current = new Referee(referee_user_name,referee_password);
            if (!list_referee.contains(current)) {
                list_referee.add(current);
                return true;
            }
        }
        return false;
    }

    public boolean deleteRefereeFromSystem(String referee_user_name){
        if (referee_user_name!=null){
            Referee current_referee = this.findReferee(referee_user_name);
            if (current_referee!=null){
                this.list_referee.remove(current_referee);
                return true;
            }
        }
        return false;
    }


    public boolean defineRefereeInLeauge(String leauge_name, String referee_user_name, String season_year) {
        League league = findLeauge(leauge_name);
        Referee referee = findReferee(referee_user_name);
        if (league != null && referee!=null) {
            Season season = league.getSeason(season_year);
            if (season!=null){
                season.addReferee(referee);
                return true;
            }
        }
        return false;
    }

}
