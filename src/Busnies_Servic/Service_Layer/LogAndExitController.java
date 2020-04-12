package Busnies_Servic.Service_Layer;

// all Subscription in system
import Busnies_Servic.PermissionAction;
import Busnies_Servic.ActionStatus;
import Busnies_Servic.Business_Layer.TeamManagement.Team;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Business_Layer.UserManagement.SubscriptionFactory;
import Busnies_Servic.Business_Layer.UserManagement.SystemAdministrator;
import Busnies_Servic.Business_Layer.UserManagement.TeamOwner;
import Busnies_Servic.Role;
import DB_Layer.logger;


import java.util.HashSet;
import java.util.regex.Pattern;

// to function that remove all Subscription


/**
 * This Class is responsible for connecting to the system exit system
 */
public class LogAndExitController{

    protected static SubscriptionFactory factory = new SubscriptionFactory();
    private Subscription current;
    /**
     * This function check if email is legal
     * @param email
     * @return
     */
    private boolean checkEmail(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    /**
     * The purpose of this function is to register the user to the system.
     * The function checks that the user information is correct
     * @param arg_user_name
     * @param arg_password
     * @param arg_role
     * @return comment print to user
     */
    public ActionStatus Registration(String arg_user_name, String arg_password, String arg_role, String email){
        ActionStatus AC = null;
        String check_input = InputTest(arg_user_name,arg_password);
        Role role_enum = DataManagement.return_enum(arg_role);
        if(!checkEmail(email)){
            AC =  new ActionStatus(false,  "Invalid email, please enter a valid email.");
        }
        else if( check_input!= null){
            AC = new ActionStatus(false, check_input);
        }
        else if(role_enum == null){
            AC = new ActionStatus(false, "The role does not exist in the system.");
        }
        else {
            Subscription newSub = factory.Create(arg_user_name, arg_password, role_enum, email);
            DataManagement.setSubscription(newSub);
            DataManagement.setCurrent(newSub);
            AC = new ActionStatus(true, "Subscription successfully added!");
        }
        logger.log("new Registration attempt of user : "+ arg_user_name+" "+arg_role+" "+email + AC.getDescription());
        return AC;
    }


    /**
     * The purpose of this function is to check the correctness of the input of the user who
     * wishes to register.
     * Laws:
     * password - only number and length of 5 digits
     * user_name -Unique not empty
     * @param arg_user_name
     * @param arg_password
     * @return comment print to user
     * if return  null the input correct
     */
    private String InputTest(String arg_user_name, String arg_password){
        if(arg_user_name == null || arg_password == null || arg_user_name.equals("") || arg_password.equals("")){
            return "The input is empty.";
        }
        if(arg_password.length() < 5){
            return "The password must contain at least 5 digits.";
        }
        if (DataManagement.contain_subscription(arg_user_name) != null){
            return "Please select another username because this username exists in the system.";
        }
        return null;
    }


    /**
     * A function that allows the user to log in to the system by username and password
     * @param arg_user_name
     * @param arg_password
     * @return comment print to user
     */
    public ActionStatus Login(String arg_user_name, String arg_password){
        ActionStatus AC = null;
        Subscription Current_check = DataManagement.contain_subscription(arg_user_name);
        if(current != null){
            AC = new ActionStatus(false, "Another subscription is connected to the system.");
        }
        else if (Current_check != null){
            if (!Current_check.getPassword().equals(arg_password) ){
                AC = new ActionStatus(false,  "The password does not match the username.");
            }
            else {
                current = Current_check;
                AC = new ActionStatus(true, "Login successful.");
            }
        }
        else if(AC ==null) {
            AC = new ActionStatus(false, "There is no user with such a name.");
        }
        logger.log("Login attempt of user : "+ arg_user_name+" "+ AC.getDescription());
        return AC;
    }


    /**
     * The function allows logging off of a user connected to the system
     * @param arg_user_name
     * @param arg_password
     * @return comment print to user
     */
    public ActionStatus Exit(String arg_user_name, String arg_password){
        ActionStatus AC = null;
        if(DataManagement.getCurrent() != null){
            if(DataManagement.getCurrent().getUserName().equals(arg_user_name) && DataManagement.getCurrent().getPassword().equals(arg_password)){
                DataManagement.setCurrent(null);
                AC = new ActionStatus(true,  "Successfully disconnected from the system.");
            }
        }
        else if(AC ==null){
            AC = new ActionStatus(false, "One of the details you entered is incorrect.");
        }
        logger.log("Exit attempt of user : "+ arg_user_name+" "+ AC.getDescription());
        return AC;
    }


    /**
     * Only the administrator can delete  users
     * @return
     */
    public ActionStatus RemoveSubscription(String userName){
        ActionStatus AC = null;
        if(ConstraintsCorrectness(userName) == false){
            AC =  new ActionStatus(false,  "The system constraints do not allow this subscription to be deleted.");
        }
        else if(DataManagement.contain_subscription(userName) == null){
            AC =  new ActionStatus(false,  "There is no subscription with this username in the system.");
        }
        else if(!(current.getPermissions().check_permissions((PermissionAction.Removing_Subscriptions)))){
            AC =  new ActionStatus(false,  "You are not authorized to perform this action.");
        }
        else {
            if(DataManagement.getCurrent().getPermissions().equals(userName)){
                DataManagement.setCurrent(null);
            }
            DataManagement.removeSubscription(userName);
            AC = new ActionStatus(false, "the transaction completed successfully.");
        }
        logger.log("Remove Subscription attempt of user : "+userName+" "+AC.getDescription());
        return AC;
    }

    private boolean ConstraintsCorrectness(String userName){
        return ( numberSystemAdministrator(userName) && TeamOwnerForTeam(userName));

    }

    /**
     * Check if there is more than one administrator
     * @param userName
     * @return false - error the action illegal
     */
    private boolean numberSystemAdministrator(String userName){
        HashSet<SystemAdministrator> list =  DataManagement.getSystemAdministratorsList();
        if(list.size() == 1){
            for (SystemAdministrator user: list) {
                if(user.getUserName().equals(userName)){
                    // the action illegal
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * Check that there is another team owner for a team
     * @param userName
     * @return
     */
    private boolean TeamOwnerForTeam(String userName){
        Subscription teamOwner = DataManagement.contain_subscription(userName);
        if(teamOwner instanceof TeamOwner){
            HashSet<Team> list =  DataManagement.getListTeam();
            for (Team team: list) {
                HashSet<TeamOwner> teamOwnerHash = team.getListTeamOwner();
                if(teamOwnerHash.size() == 1){
                    if(teamOwnerHash.contains(teamOwner)){
                        return false;
                    }
                }
            }
        }
        return true;

    }



}
