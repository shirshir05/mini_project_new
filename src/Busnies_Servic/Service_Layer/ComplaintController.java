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
    public void add_complaint(){
        Scanner complaint_scan = new Scanner (System.in);
        System.out.println("Enter tour complaint:");
        String complaint_description="";
        complaint_description+=complaint_scan.nextLine();
        complaints.updateComplaint(complaint_description);
    }


}
