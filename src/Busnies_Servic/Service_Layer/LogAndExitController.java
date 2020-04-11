package Busnies_Servic.Service_Layer;

// all Subscription in system
import Busnies_Servic.Action;
import Busnies_Servic.Business_Layer.ActionStatus;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Business_Layer.UserManagement.SubscriptionFactory;
import Busnies_Servic.Role;

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
        if(!checkEmail(email)){
            return new ActionStatus(false,  "Invalid email, please enter a valid email.");
        }
        String check_input = InputTest(arg_user_name,arg_password);

        if( check_input!= null){
            return new ActionStatus(false, check_input);
        }
        Role role_enum = DataManagement.return_enum(arg_role);
        if (role_enum == null){
            return new ActionStatus(false, "The role does not exist in the system.");
        }

        Subscription newSub = factory.Create(arg_user_name,arg_password, role_enum,email);
        DataManagement.setSubscription(newSub);
        DataManagement.setCurrent(newSub);
        return new ActionStatus(true, "Subscription successfully added!");
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
        if(current != null){
            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        Subscription Current_check = DataManagement.contain_subscription(arg_user_name);
        if (Current_check != null){
            if (!Current_check.getPassword().equals(arg_password) ){
                return new ActionStatus(false,  "The password does not match the username.");
            }
            current =Current_check;
            return new ActionStatus(true,  "Login successful.");
        }
        return new ActionStatus(false,  "There is no user with such a name.");
    }


    /**
     * The function allows logging off of a user connected to the system
     * @param arg_user_name
     * @param arg_password
     * @return comment print to user
     */
    public ActionStatus Exit(String arg_user_name, String arg_password){
        if(DataManagement.getCurrent() != null){
            if(DataManagement.getCurrent().getUserName().equals(arg_user_name) && DataManagement.getCurrent().getPassword().equals(arg_password)){
                DataManagement.setCurrent(null);
                return new ActionStatus(true,  "Successfully disconnected from the system.");
            }
        }
        return new ActionStatus(false, "One of the details you entered is incorrect.");
    }


    /**
     * Only the administrator can delete  users
     * @return
     */
    public ActionStatus RemoveSubscription(String user_name){
        // לוודא שעדיין יש בעל קבוצה ומנהל קבוצה אחד לפחות בקבוצה

        // פונקציה לא שלמה יש להסיר את התלויות מהקבוצה גם - נעשה בסוף לאחר שנבין את כל האילוצים
        if((current.getPermissions().check_permissions((Action.Removing_Subscriptions)) == 0)){
            return new ActionStatus(false,  "You are not authorized to perform this action.");
        }
        if(DataManagement.contain_subscription(user_name) == null){
            return new ActionStatus(false,  "The subscription does not exist in the system.");
        }
        DataManagement.removeSubscription(user_name);
        return new ActionStatus(false,  "the transaction completed successfully.");
    }


}
