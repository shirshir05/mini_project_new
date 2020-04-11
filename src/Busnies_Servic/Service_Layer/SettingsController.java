package Busnies_Servic.Service_Layer;

import Busnies_Servic.Business_Layer.Game.League;
import Busnies_Servic.Business_Layer.Game.Season;
import Busnies_Servic.Business_Layer.UserManagement.Referee;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Business_Layer.UserManagement.UnionRepresentative;

public class SettingsController{


    /**
     * this function let the union rep to define a leauge
     * @param name is the name of the leauge
     * @return true if it was defined
     */
    public boolean defineLeaugue(String name){
        if (name!=null && DataManagement.getCurrent() instanceof UnionRepresentative) {
            DataManagement.getListLeague().add(new League(name));
            return true;
        }
        return false;
    }

    /**
     * this function let the union rep to define a season to a leauge
     * @param league_name is the name of the leauge
     * @param year is the season
     * @return true if the season was updated
     */
    public boolean defineSeasonToLeague(String league_name, String year){
        if (year!=null && league_name!=null && DataManagement.getCurrent() instanceof UnionRepresentative) {
            int intFormatYear= Integer.parseInt(year);
            if (intFormatYear>1900 && intFormatYear<2021)
                DataManagement.findLeauge(league_name).addSeason(new Season(year));
            return true;
        }
        return false;
    }

    /**
     * This function let the union rep to add a referee to the system
     * int add_or_remove
     * @param referee_user_name is the username of the referee
     * @param referee_password is the password of the referee
     * @param mail is the password of the referee
     * @param add_or_remove is 0 to add and 1 to remove
     * @return true if the operation succeeded
     */
    public boolean addOrDeleteRefereeToSystem(String referee_user_name, String referee_password, String mail, int add_or_remove){
        if (DataManagement.getCurrent() instanceof UnionRepresentative) {
            if (referee_user_name != null && referee_password != null) {
                Subscription current_referee = DataManagement.findSubscription(referee_user_name);
                if (add_or_remove == 0 && current_referee != null) {
                    Referee current = new Referee(referee_user_name, referee_password, mail);
                    String mail_content= "Hello! you were invited to our system! your username: "+referee_user_name+" and you password: "+referee_password;
                    DataManagement.getCurrent().sendEMail(mail,mail_content);
                    DataManagement.setSubscription(current);
                    return true;
                } else if (add_or_remove == 1) {
                    if (current_referee != null) {
                        DataManagement.removeSubscription(referee_user_name);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * This function let the union rep to add a referee to the system
     * @param leauge_name
     * @param referee_user_name
     * @param season_year
     * @return
     */
    public boolean defineRefereeInLeauge(String leauge_name, String referee_user_name, String season_year) {
        League league = DataManagement.findLeauge(leauge_name);
        Subscription referee = DataManagement.findSubscription(referee_user_name);
        if (league != null && referee!=null && referee instanceof Referee) {
            Season season = league.getSeason(season_year);
            if (season!=null){
                season.addReferee((Referee)referee);
                return true;
            }
        }
        return false;
    }

}
