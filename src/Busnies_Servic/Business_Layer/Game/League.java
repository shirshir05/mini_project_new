package Busnies_Servic.Business_Layer.Game;

import Busnies_Servic.Business_Layer.UserManagement.Referee;

import java.time.Year;
import java.util.HashSet;

public class League {

    protected String name;
    protected HashSet<Season> seasons;

    /**
     * constructor
     * @param arg_name is the leauge name
     */
    public League(String arg_name){
        name=arg_name;
    }

    /**
     * leauge name getter
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * this function adds a season to the keauge
     * @param season
     * @return
     */
    public boolean addSeason(Season season){
        if (season!=null){
            seasons.add(season);
            return true;
        }
        return false;
    }

    /**
     * This function gets a season in  a leauge
     * @param year
     * @return
     */
    public Season getSeason(String year){
        for (Season s : seasons){
            if (s.getYear().equals(year)){
                return s;
            }
        }
        return null;

    }


}
