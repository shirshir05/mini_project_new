package Busnies_Servic.Service_Layer;
import Busnies_Servic.Action;
import Busnies_Servic.Business_Layer.Game.Game;
import Busnies_Servic.Business_Layer.Game.League;
import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.*;

import java.time.Year;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class TeamGameController extends LogicManagement{

    HashSet<Team> list_team = new HashSet<>();
    HashSet<Game> list_game = new HashSet<>();
    HashSet<League> list_league = new HashSet<>();



    public boolean create_game(Date date, String arg_host, String arg_guest, String arg_head, String linesman1, String linesman2){

        return true;
    }

    /**
     *
     */
    public void fan_register_to_game_alerts(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter game id:");
        int game_number=scanner.nextInt();
        scanner.close();
        Game chosen_game = find_game(game_number);
        chosen_game.addObserver((Fan)this.Current);
    }

    /**
     * This function register the current user to the page he asked to be registered to.
     * @param arg_user_to_register is the name of the page the user wants to register to
     * @return true if the registeration succeeded
     */
    public boolean fan_register_to_page(String arg_user_to_register){
        Subscription current_user = this.contain_subscription(arg_user_to_register);
        if (current_user instanceof Coach) {
            ((Coach) current_user).getPersonalPage().addObserver((Fan)this.Current);
            return true;
        }
        else if (current_user instanceof Player) {
            ((Player) current_user).getPersonalPage().addObserver((Fan)this.Current);
            return true;
        }
        else{
            Team t = findTeam(arg_user_to_register);
            if (t!=null){
                t.getPersonalPage().addObserver((Fan)this.Current);
                return true;
            }
        }
        System.out.println("Wrong page name");
        return false;
    }

    /**
     * @param arg_user_to_register
     * @return
     */
    private Team findTeam(String arg_user_to_register) {
        for (Team t : list_team){
            if (t.getName().equals(arg_user_to_register))
                return t;
        }
        return null;
    }

    /**
     * This function get game_id and return Game
     * @param game_id
     * @return
     */
    private Game find_game(int game_id){
        for ( Game g: list_game ){
            if (g.get_game_id()==game_id)
                return g;
        }
        return null;
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

    /**
     * Once the association representative is approved, a Team is created in the system.
     * only TeamOwner can create team
     * @param arg_name
     * @param arg_field
     * @return
     */
    public String create_team(String arg_name, String arg_field){
        // צריך לבדוק שיש אישור ליצור קבוצה
        if((Current.getPermissions().check_permissions((Action.Edit_team)) == 0) && !(Current instanceof  TeamOwner)){
            return "You are not allowed to perform actions on the group.";
        }
        Team team = findTeam(arg_name);
        if(team != null){
            return "The Team already exists in the system.";
        }
        Team new_team = new Team(arg_name,arg_field);
        new_team.set_TeamOwner((TeamOwner)Current);
        list_team.add(new_team);
        return "The Team was successfully created in the system.";
    }

    /**
     * The function allows a player to be added to a team or to remove a player from the team
     * @param name_team
     * @param user_name
     * @param add_or_remove
     * @return
     */
    public String add_or_remove_player(String name_team, String user_name, int add_or_remove ){
        String ans = check_input_edit_team(name_team,user_name);
        if(ans != null){
            return ans;
        }
        Subscription player = contain_subscription(user_name);
        if(!(player instanceof Player)){
            return "The username is not defined as a player on the system.";
        }
        Team team = findTeam(name_team);
        if(team != null){
            return team.add_or_remove_player((Player)player,add_or_remove);
        }
        return "The code should not reach this point - error.";
    }

    /**
     * The function allows a player to be added to a team or to remove a player from the team.
     * @param name_team
     * @param coach_add
     * @param add_or_remove
     * @return
     */
    public String add_or_remove_coach(String name_team, String coach_add, int add_or_remove){
        String ans = check_input_edit_team(name_team,coach_add);
        if(ans != null){
            return ans;
        }
        Subscription coach = contain_subscription(coach_add);
        if(!(coach instanceof Coach)){
            return "The username is not defined as a Coach on the system.";
        }
        Team team = findTeam(name_team);
        if(team != null){
            return team.add_or_remove_coach((Coach)coach,add_or_remove);
        }
        return "The code should not reach this point - error.";
    }


    public String add_or_remove_TeamOwner(String name_team, String TeamOwner, int add_or_remove){
            // יש בעיה איך מגדירים בעל קבוצה איזה מנוי הוא?
        //??????????????????????
        return null;
    }

    /**
     * The function checks the permissions to edit a set and the parameters proper
     * @param name_team
     * @param user_name
     * @return
     */
    private String check_input_edit_team(String name_team, String user_name){
        if((Current.getPermissions().check_permissions((Action.Edit_team)) == 0)){
            return "You are not allowed to perform actions on the group.";
        }
        Team team = findTeam(name_team);
        if(team == null){
            return "The Team does not exist in the system.";
        }
        if(!team.check_if_object_in_team(Current)){
            return "You are not allowed to perform actions in this group.";
        }
        Subscription subscription = contain_subscription(user_name);
        if( subscription== null){
            return "The username does not exist on the system.";
        }
        // no error
        return null;
    }



    public boolean change_status_team(int status, String name_team){


        return true;
    }

    public boolean change_financial(String name_team, String Operation , Integer sum){


        return true;
    }

    public boolean create_league(String name){
        // לוודא כי המשתמש הוא נציג התאחדות

        return true;
    }

    public boolean add_year_league(String name_league, Year year){


        return true;
    }


    public boolean subscription_referee_to_league(String name_league, String name_referee, Year year){

        return true;
    }











}
