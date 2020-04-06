package Busnies_Servic.Business_Layer.UserManagement;

import java.util.Observable;

public class Complaint extends Observable {
    String description;
    boolean status;

    public Complaint(String des){
        description = des;
        status=false;
    }

    public void updateComplaint(String new_description){
        this.description=new_description;
        setChanged();
        notifyObservers(new_description);
    }

}
