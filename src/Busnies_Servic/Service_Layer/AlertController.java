package Busnies_Servic.Service_Layer;



import java.util.Scanner;

public class AlertController extends LogicManagement {

    public void game_alert(String description){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter tour complaint:");
        String complaint_description="";
        complaint_description+=scanner.nextLine();
        scanner.close();
        //complaints.updateComplaint(complaint_description);
    }

}
