package Busnies_Servic.Service_Layer;

import Busnies_Servic.ActionStatus;
import Busnies_Servic.Business_Layer.UserManagement.Complaint;
import Busnies_Servic.Business_Layer.UserManagement.Fan;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;
import DB_Layer.logger;



import java.util.ArrayList;

public class ComplaintController{

    // TODO permissions?

    private static ArrayList<Complaint> complaints;

    /**
     * This method adds a complaint by a user.
     * @param fan the fan who created the complaint
     */
    public static ActionStatus addComplaint(String complaint_description, Fan fan){
        ActionStatus AC = null;
        if(complaint_description == null || complaint_description.equals("")) {
            AC = new ActionStatus(false, "Complaint cannot be empty");
        }
        else {
            if (complaints == null)
                complaints = new ArrayList<>();
            Complaint c = new Complaint(complaint_description);
            fan.addComplaint(c);
            complaints.add(c);
            AC = new ActionStatus(true, "Complaint added successfully");
        }
        logger.log("Add Complaint of user : "+ fan.getName() +" "+AC.getDescription());
        return AC;
    }

    /**
     * for the use of the system manager, to read all the complaints in the system
     * @return a list of all the complaints
     */
    public static ArrayList<Complaint> getComplaints() {
        return complaints;
    }

    public void add_complaint(String complaint_description){
        DataManagement.setComplaint(complaint_description);
    }


}
