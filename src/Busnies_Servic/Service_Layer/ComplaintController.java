package Busnies_Servic.Service_Layer;

import Busnies_Servic.Business_Layer.UserManagement.Complaint;

import java.util.Scanner;

public class ComplaintController extends LogicManagement{
    Complaint complaints;
    public void add_complaint(String description){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter tour complaint:");
        String complaint_description="";
        complaint_description+=scanner.nextLine();
        scanner.close();
        complaints.updateComplaint(complaint_description);
    }


}
