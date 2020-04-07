package Busnies_Servic.Business_Layer.Game;

import Busnies_Servic.Business_Layer.UserManagement.Referee;

import java.time.Year;
import java.util.HashSet;

public class League {

    protected String name;
    protected Year season;
    protected HashSet<Referee> list_referee;
    protected HashSet<Game> list_game;

    /**
     * constructor
     * @param arg_name is the leauge name
     */
    public League(String arg_name){
        name=arg_name;
    }

    /**
     * this function sets the season of the leauge
     * @param year is the season
     */
    public void set_season(Year year){
        if (year.isBefore(Year.of(1900))){
            season=year;
        }
    }

    /**
     * This function is adding a referee to the league
     * @param r is the referee
     */
    public void add_referee(Referee r){
        list_referee.add(r);
    }

    /**
     * This function is deleting a referee from the league
     * @param r is the referee
     */
    public void delete_referee(Referee r){
        list_referee.remove(r);
    }

    public Referee getReferee(String refereeName){
        for (Referee r : list_referee){
            if (r.get_name().equals(refereeName)){
                return r;
            }
        }
        return null;
    }

    /**
     * This function is adding a game to the League
     * @param g is the game
     */
    public void add_game(Game g){
        list_game.add(g);
    }

    /**
     * This function is deleting a game from the league
     * @param g is the game
     */
    public void delete_game(Game g){
        list_game.remove(g);
    }

    /**
     * leauge name getter
     * @return name
     */
    public String getName(){
        return this.name;
    }



}
