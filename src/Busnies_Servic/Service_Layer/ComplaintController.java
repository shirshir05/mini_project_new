package Busnies_Servic.Service_Layer;

import Busnies_Servic.Business_Layer.ActionStatus;
import Busnies_Servic.Business_Layer.UserManagement.Complaint;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ComplaintController{

    // TODO permissions?

    private static ArrayList<Complaint> complaints;

    /**
     * This method adds a complaint by a user.
     */
    public static ActionStatus add_complaint(String complaint_description){
        if(complaint_description == null || complaint_description.equals(""))
            return new ActionStatus(false,"Complaint cannot be empty");
        if(complaints == null)
            complaints = new ArrayList<>();
        Complaint c = new Complaint(complaint_description);
        complaints.add(c);
        return new ActionStatus(true,"Complaint added successfully");
    }

    /**
     * for the use of the system manager, to read all the complaints in the system
     * @return a list of all the complaints
     */
    public static ArrayList<Complaint> getComplaints() {
        return complaints;
    }

}
