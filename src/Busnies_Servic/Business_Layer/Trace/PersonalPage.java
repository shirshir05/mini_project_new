package Busnies_Servic.Business_Layer.Trace;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;

import java.util.HashSet;
import java.util.Observable;



public class PersonalPage extends Observable {

    protected String name;
    protected HashSet<String> perrmissionToEdit;
    protected String pageOwner;


    public PersonalPage(String subject_name){
        name=subject_name;
        perrmissionToEdit = new HashSet<>();
    }

    public void addPerrmissionToEdit(String user){
        perrmissionToEdit.add(user);
    }

    public void addPageOwner(String user){
        pageOwner = user;
        perrmissionToEdit.add(user);
    }

    public boolean chackPerrmissionToEdit(String user){
        return perrmissionToEdit.contains(user);
    }

    public boolean removePerrmissionToEdit(String user){
        boolean ans = false;
        if(!user.equals(pageOwner)) {
            perrmissionToEdit.remove(user);
            ans = true;
        }
        return ans;
    }

    /*
    כאשר רוצים לשנות משהו בתוך הפונקציה נקרא לשיטות:
public change(){
        setChanged();
        notifyObservers();
}

כדי להוסיף נושא מסוים עושים:
subject.addObserver(צופה);
     */

}
