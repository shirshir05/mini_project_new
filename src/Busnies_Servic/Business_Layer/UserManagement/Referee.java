package Busnies_Servic.Business_Layer.UserManagement;
import Busnies_Servic.Action;
import Busnies_Servic.Business_Layer.Game.Game;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

public class Referee extends Subscription implements Observer {

    protected String qualification;
    protected String name;
    protected HashSet<Game> referee_games;


    public String getQualification() {
        return qualification;
    }

    public String getName() {
        return name;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Referee(String arg_user_name, String arg_password,String email) {
        super(arg_user_name, arg_password,email);
        permissions.add_default_referee_permission();
        referee_games = new HashSet<>();
    }

    /**
     * adds a game to the game-list the referee participates in
     * @param g
     */
    public void addGame(Game g){referee_games.add(g);}

    /**
     * a to-string function to the list of games of the referee
     * @return
     */
    public String gamesListToString(){
        String return_value = "You are participates in the next games: ";
        for (Game g:referee_games){
            return_value+=g.get_game_id()+", ";
        }
        return return_value.substring(0,return_value.length()-2);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Referee)) return false;
        Referee referee = (Referee) o;
        return referee.userName.equals(this.userName);
    }

    @Override
    public void update(Observable o, Object arg) {
        String alert = (String)arg;
        if (alert.substring(0,3).equals("The")){
            this.alerts.add((String)arg);
        }
    }


}
