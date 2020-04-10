package Busnies_Servic.Service_Layer;

import Busnies_Servic.Business_Layer.UserManagement.Complaint;

import java.util.Scanner;

public class ComplaintController{
    Complaint complaints;

    /**
     * The controller constructor
     * @param c is a complaint
     */
    public ComplaintController(Complaint c){
        complaints=c;
    };

    /**
     * This function adds a complaint by a user.
     *
     */
    public void add_complaint(String complaint_description){
        if (complaint_description!=null){
            complaints.updateComplaint(complaint_description);
        }
    }


}
