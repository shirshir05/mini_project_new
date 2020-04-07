package Busnies_Servic.Service_Layer;

// all Subscription in system
import Busnies_Servic.Action;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import Busnies_Servic.Role;

// to function that remove all Subscription


/**
 * This Class is responsible for connecting to the system exit system
 */
public class LogAndExitController extends LogicManagement{


    /**
     * The purpose of this function is to register the user to the system.
     * The function checks that the user information is correct
     * @param arg_user_name
     * @param arg_password
     * @param arg_role
     * @return comment print to user
     */
    public String Registration(String arg_user_name, String arg_password, String arg_role){
        String check_input = Input_test(arg_user_name,arg_password);
        if( check_input!= null){
            return check_input;
        }
        Role role_enum = return_enum(arg_role);
        if (role_enum == null){
            return "The role does not exist in the system.";
        }

        Subscription.add(factory.Create(arg_user_name,arg_password, role_enum));
        return "Subscription successfully added!";
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
     * if return nul the input correct
     */
    private String Input_test(String arg_user_name, String arg_password){
        if(arg_user_name == null || arg_password == null || arg_user_name.equals("") || arg_password.equals("")){
            return "The input is empty.";
        }
        if(arg_password.length() != 5){
            return "The password must contain exactly 5 digits.";
        }
        try {
            int password = Integer.parseInt(arg_password);
            if (contain_subscription(arg_user_name) != null){
                return "Please select another username because this username exists in the system.";
            }
        }catch (Exception e){
            return "The password must contain only digits.";
        }
        return null;
    }


    /**
     * A function that allows the user to log in to the system by username and password
     * @param arg_user_name
     * @param arg_password
     * @return comment print to user
     */
    public String Login(String arg_user_name, String arg_password){
        if(Current != null){
            return "Another subscription is connected to the system.";
        }
        Subscription Current_check = contain_subscription(arg_user_name);
        if (Current_check != null){
            if (!Current_check.getPassword().equals(arg_password) ){
                return "The password does not match the username.";
            }
            Current =Current_check;
            return "Login successful.";
        }
        return "There is no user with such a name.";
    }


    /**
     * The function allows logging off of a user connected to the system
     * @param arg_user_name
     * @param arg_password
     * @return comment print to user
     */
    public String Exit(String arg_user_name, String arg_password){
        if(Current != null){
            if(Current.equals(arg_user_name) && Current.getPassword().equals(arg_password)){
                Current = null;
                return "Successfully disconnected from the system.";
            }
        }
        return "One of the details you entered is incorrect.";
    }


    /**
     * Only the administrator can delete  users
     * @return
     */
    public String remove_subscription(String user_name){
        // לוודא שעדיין יש בעל קבוצה ומנהל קבוצה אחד לפחות בקבוצה

        // פונקציה לא שלמה יש להסיר את התלויות מהקבוצה גם - נעשה בסוף לאחר שנבין את כל האילוצים
        if((Current.getPermissions().check_permissions((Action.Removing_Subscriptions)) == 0)){
            return "You are not authorized to perform this action.";
        }
        if(contain_subscription(user_name) == null){
            return "The subscription does not exist in the system.";
        }
        Subscription.remove(contain_subscription(user_name));
        return "the transaction completed successfully.";
    }


}
