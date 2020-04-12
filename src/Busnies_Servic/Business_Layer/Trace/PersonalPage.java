package Busnies_Servic.Business_Layer.Trace;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Observable;



import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Observable;

public class PersonalPage extends Observable {

    protected String name;
    protected HashSet<String> perrmissionToEdit;
    protected String pageOwner;

    protected HashMap<String,Object> pageData;


    public PersonalPage(String subject_name){
        name=subject_name;
        perrmissionToEdit = new HashSet<>();
        pageData = new HashMap<>();
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

    public boolean addToPageData(String dataHedline , Object data){
        boolean ans = false;
        if(!pageData.containsKey(dataHedline)){
            pageData.put(dataHedline,data);
            ans = true;
        }
        return ans;
    }

    public Object getPageData(String dataHedline){
        if(pageData.containsKey(dataHedline)){
            return pageData.get(dataHedline);
        }
        return null;
    }

    public Object editPageData(String dataHedline,Object newData){
        boolean ans = false;
        if(pageData.containsKey(dataHedline)){
            pageData.replace(dataHedline,newData);
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