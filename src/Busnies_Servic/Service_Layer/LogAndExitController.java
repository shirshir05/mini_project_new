package Busnies_Servic.Service_Layer;

// all Subscription in system
import Busnies_Servic.Action;
import Busnies_Servic.ActionStatus;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Business_Layer.UserManagement.SubscriptionFactory;
import Busnies_Servic.Role;
import DB_Layer.logger;
import Presentation_Layer.Spelling;


import java.util.regex.Pattern;

// to function that remove all Subscription


/**
 * This Class is responsible for connecting to the system exit system
 */
public class LogAndExitController{

    protected static SubscriptionFactory factory = new SubscriptionFactory();
    private Subscription current;

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
        String check_input = DataManagement.InputTest(arg_user_name,arg_password);
        Role role_enum = DataManagement.return_enum(arg_role);
        if(!DataManagement.checkEmail(email)){
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
        Spelling.updateDictionary(arg_user_name);
        logger.log("new Registration attempt of user : "+ arg_user_name+" "+arg_role+" "+email + AC.getDescription());
        return AC;
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
    public ActionStatus RemoveSubscription(String user_name){
        // לוודא שעדיין יש בעל קבוצה ומנהל קבוצה אחד לפחות בקבוצה

        // פונקציה לא שלמה יש להסיר את התלויות מהקבוצה גם - נעשה בסוף לאחר שנבין את כל האילוצים
        ActionStatus AC = null;
        if((current.getPermissions().check_permissions((Action.Removing_Subscriptions)) == 0)){
            AC =  new ActionStatus(false,  "You are not authorized to perform this action.");
        }
        else if(DataManagement.contain_subscription(user_name) == null){
            AC = new ActionStatus(false,  "The subscription does not exist in the system.");
        }
        else {
            DataManagement.removeSubscription(user_name);
            AC = new ActionStatus(false, "the transaction completed successfully.");
        }
        logger.log("Remove Subscription attempt of user : "+user_name+" "+AC.getDescription());
        return AC;
    }


}
