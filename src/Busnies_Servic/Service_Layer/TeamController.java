package Busnies_Servic.Service_Layer;
import Busnies_Servic.Action;
import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.*;

public class TeamController {


    /**
     * Once the association representative is approved, a Team is created in the system.
     * only TeamOwner can create team
     *
     * @param arg_name
     * @param arg_field
     * @return
     */
    public String create_team(String arg_name, String arg_field) {
        // צריך לבדוק שיש אישור ליצור קבוצה
        if ((DataManagement.getCurrent().getPermissions().check_permissions((Action.Edit_team)) == 0) && !(DataManagement.getCurrent() instanceof TeamOwner)) {
            return "You are not allowed to perform actions on the group.";
        }
        Team team = DataManagement.findTeam(arg_name);
        if (team != null) {
            return "The Team already exists in the system.";
        }
        Team new_team = new Team(arg_name, arg_field);
        DataManagement.addToListTeam((new_team));
        new_team.set_TeamOwner((TeamOwner) DataManagement.getCurrent());
        return "The Team was successfully created in the system.";

    }

    /**
     * The function allows a player to be added to a team or to remove a player from the team
     *
     * @param name_team
     * @param user_name
     * @param add_or_remove
     * @return
     */
    public String add_or_remove_player(String name_team, String user_name, int add_or_remove) {
        String ans = check_input_edit_team(name_team, user_name);
        if (ans != null) {
            return ans;
        }
        Subscription player = DataManagement.contain_subscription(user_name);
        if (!(player instanceof Player)) {
            return "The username is not defined as a player on the system.";
        }
        Team team = DataManagement.findTeam(name_team);
        if (team != null) {
            return team.add_or_remove_player((Player) player, add_or_remove);
        }
        return "The code should not reach this point - error.";
    }

    /**
     * The function allows a player to be added to a team or to remove a player from the team.
     *
     * @param name_team
     * @param coach_add
     * @param add_or_remove
     * @return
     */
    public String add_or_remove_coach(String name_team, String coach_add, int add_or_remove) {
        String ans = check_input_edit_team(name_team, coach_add);
        if (ans != null) {
            return ans;
        }
        Subscription coach = DataManagement.contain_subscription(coach_add);
        if (!(coach instanceof Coach)) {
            return "The username is not defined as a Coach on the system.";
        }
        Team team = DataManagement.findTeam(name_team);
        if (team != null) {
            return team.add_or_remove_coach((Coach) coach, add_or_remove);
        }
        return "The code should not reach this point - error.";
    }


    /**
     * If the add_or_remove is 1 the function allows a new group owner to be set to the system
     * If the add_or_remove is 0 the function allows a team owner to explain a group owner from the system eight by him
     *
     * @param name_team
     * @param TeamOwner
     * @param add_or_remove
     * @return
     */
    public String add_or_remove_TeamOwner(String name_team, String TeamOwner, int add_or_remove) {
        // כאן צריך ליצור אובייקט חדש למנוי שאינו מוגדר כ-team owner
        //חלק זמן יממוש בהמשך
        String ans = check_input_edit_team(name_team, TeamOwner);
        if (ans != null) {
            return ans;
        }
        Subscription teamOwner = DataManagement.contain_subscription(TeamOwner);
        if (!(teamOwner instanceof TeamOwner)) {
            return "The username is not defined as a Team Owner on the system.";
        }
        Team team = DataManagement.findTeam(name_team);
        if (team == null) {
            return "The Team does not exist in the system.";
        }
        // add teamOwner to team
        if (add_or_remove == 1) {
            Subscription appointed = ((TeamOwner) teamOwner).getAppointed_by_teamOwner();
            if (appointed != null) {
                return "You are already set as a team owner.";
            }
            ((TeamOwner) teamOwner).setAppointed_by_teamOwner(DataManagement.getCurrent());
            return team.Edit_TeamOwner((TeamOwner) teamOwner, add_or_remove);
        }
        // remove teamOwner to team
        if (add_or_remove == 0) {
            Subscription appointed = ((TeamOwner) teamOwner).getAppointed_by_teamOwner();
            if (DataManagement.contain_subscription(appointed.getUserName()) != null) {
                // The person responsible for appointing the team is still in the system
                if (appointed != DataManagement.getCurrent()) {
                    return "You do not appoint the team owner and therefore cannot remove them from the team";
                }
            }
            ((TeamOwner) teamOwner).setAppointed_by_teamOwner(null);
            return team.Edit_TeamOwner((TeamOwner) teamOwner, add_or_remove);
        }
        return "The action is invalid.";
    }


    /**
     * If the add_or_remove is 1 the function allows a new group owner to be set to the system
     * If the add_or_remove is 0 the function allows a team owner to explain a group owner from the system eight by him
     *
     * @param name_team
     * @param TeamOwner
     * @param add_or_remove
     * @return
     */
    public String add_or_remove_TeamManager(String name_team, String TeamOwner, int add_or_remove) {
        // כאן צריך ליצור אובייקט חדש למנוי שאינו מוגדר כ-team MANAGER
        //חלק זמן יממוש בהמשך
        String ans = check_input_edit_team(name_team, TeamOwner);
        if (ans != null) {
            return ans;
        }
        Subscription teamManager = DataManagement.contain_subscription(TeamOwner);
        if (!(teamManager instanceof TeamManager)) {
            return "The username is not defined as a Team Owner on the system.";
        }
        Team team = DataManagement.findTeam(name_team);
        if (team == null) {
            return "The Team does not exist in the system.";
        }
        // add teamOwner to team
        if (add_or_remove == 1) {
            Subscription appointed = ((TeamManager) teamManager).getAppointed_by_teamOwner();
            if (appointed != null) {
                return "You are already set as a team Manager.";
            }
            ((TeamManager) teamManager).setAppointed_by_teamOwner(DataManagement.getCurrent());
            return team.Edit_TeamManager((TeamManager) teamManager, add_or_remove);
        }
        // remove teamOwner to team
        if (add_or_remove == 0) {
            Subscription appointed = ((TeamManager) teamManager).getAppointed_by_teamOwner();
            if (DataManagement.contain_subscription(appointed.getUserName()) != null) {
                // The person responsible for appointing the team is still in the system
                if (appointed != DataManagement.getCurrent()) {
                    return "You do not appoint the team owner and therefore cannot remove them from the team";
                }

            }
            ((TeamManager) teamManager).setAppointed_by_teamOwner(null);
            return team.Edit_TeamManager((TeamManager) teamManager, add_or_remove);

        }
        return "The action is invalid.";

    }

    /**
     * The function checks the permissions to edit a set and the parameters proper
     *
     * @param name_team
     * @param user_name
     * @return
     */
    private String check_input_edit_team(String name_team, String user_name) {
        if ((DataManagement.getCurrent().getPermissions().check_permissions((Action.Edit_team)) == 0)) {
            return "You are not allowed to perform actions on the group.";
        }
        Team team = DataManagement.findTeam(name_team);
        if (team == null) {
            return "The Team does not exist in the system.";
        }
        if (!team.check_if_object_in_team(DataManagement.getCurrent()) || (DataManagement.getCurrent() instanceof SystemAdministrator)) {
            return "You are not allowed to perform actions in this group.";
        }
        Subscription subscription = DataManagement.contain_subscription(user_name);
        if (subscription == null) {
            return "The username does not exist on the system.";
        }
        // no error
        return null;
    }


    /**
     * A function that allows the system administrator and the group owner to change the status of the group
     * 0 - close
     * 1- open
     * -1  -  permanently close
     *
     * @param name_team
     * @param status
     * @return
     */
    public String change_status_team(String name_team, int status) {
        if (status != 0 && status != 1 && status != -1) {
            return "The action is invalid.";
        }
        String ans = check_input_edit_team(name_team, DataManagement.getCurrent().getUserName());
        if (ans != null) {
            return ans;
        }
        Team team = DataManagement.findTeam(name_team);
        if (team == null) {
            return "The Team does not exist in the system.";
        }
        if (team.getStatus() == -1) {
            return "The team is permanently closed.";
        }
        if (DataManagement.getCurrent().getPermissions().check_permissions(Action.Close_team) == 0) {
            return "You are not allowed to close a team.";
        }

        if (!(DataManagement.getCurrent() instanceof SystemAdministrator)) {
            //Only an administrator can permanently close the team
            if (status == -1) {
                return "You are not authorized to perform this action.";
            }
        } else {
            if (DataManagement.getCurrent().getPermissions().check_permissions(Action.Close_team_perpetually) == 0) {
                return "You are not allowed to close a team.";
            }
        }
        return team.change_status(status);
    }

    public boolean change_financial(String name_team, String Operation, Integer sum) {


        return true;
    }

}
