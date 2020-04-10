package Busnies_Servic.Business_Layer.Game;

import Busnies_Servic.Business_Layer.UserManagement.Referee;

import java.time.Year;
import java.util.HashSet;

public class Season {
    protected String season;
    protected HashSet<Referee> list_referee;
    protected HashSet<Game> list_game;

    /**
     * season constructor
     * @param year is the season's year
     */
    public Season(String year){
        if (year!=null ) {
            int intFormatYear= Integer.parseInt(year);
            if (intFormatYear>1900 && intFormatYear<2021)
                this.season = year;
        }
    }

    /**
     * This function is adding a referee to the league
     * @param r is the referee
     */
    public void addReferee(Referee r){
        list_referee.add(r);
    }

    /**
     * This function is deleting a referee from the league
     * @param r is the referee
     */
    public void deleteReferee(Referee r){
        list_referee.remove(r);
    }

    public Referee getReferee(String refereeName){
        for (Referee r : list_referee){
            if (r.getUserName().equals(refereeName)){
                return r;
            }
        }
        return null;
    }

    /**
     * This function is adding a game to the League
     * @param g is the game
     */
    public void addGame(Game g){
        list_game.add(g);
    }

    /**
     * This function is deleting a game from the league
     * @param g is the game
     */
    public void deleteGame(Game g){
        list_game.remove(g);
    }

    /**
     * This function gets the season's year
     * @return
     */
    public String getYear(){
        return this.season;
    }



}
