package Busnies_Servic.Business_Layer.UserManagement;

import java.util.Observable;

public class Complaint extends Observable {

    private String description;

    private String answer;

    private boolean isAnswered;

    public Complaint(String dsc){
        if(dsc == null || dsc.isEmpty())
            throw new IllegalArgumentException("Cannot be null");
        //TODO what to do if the arguments are null?
        description = dsc;
        isAnswered = false;
        answer = null;
    }

    public void answerComplaint(String ans){
        answer = ans;
        isAnswered = true;
        // TODO add alert to subscription
        setChanged();
        notifyObservers("Your complaint:\n" +
                "\""+description+"\"\n" +
                "Has been answered:\n " +
                "\""+ans+"\"");
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public String getAnswer() {
        if(answer == null || answer.isEmpty())
            return "Complaint has not been answered";
        return answer;
    }
}
