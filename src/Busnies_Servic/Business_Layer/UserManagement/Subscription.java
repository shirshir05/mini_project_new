package Busnies_Servic.Business_Layer.UserManagement;

import java.util.HashSet;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public abstract class Subscription {
    protected String user_name;
    public String password;
    protected String name;
    public Permissions permissions;
    protected HashSet<String> alerts = new HashSet<>();

    public Subscription(String arg_user_name, String arg_password){
        user_name=arg_user_name;
        password=arg_password;
        permissions = new Permissions();
    }


    /**
     * This function prints the subscription alerts
     */
    public void printAlerts(){
        for (String alert : alerts){
            System.out.println(alert);
        }
    }

    /**
     * Thif function equal Subscription by user_name
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(user_name, that.user_name);
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_name() {
        return user_name;
    }

    public String get_name() {
        return name;
    }

}
