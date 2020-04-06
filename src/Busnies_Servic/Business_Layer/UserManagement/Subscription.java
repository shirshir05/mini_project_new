package Busnies_Servic.Business_Layer.UserManagement;

import java.util.HashSet;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public abstract class Subscription implements Observer {
    protected String user_name;
    public String password;
    protected String name;
    public Permissions permissions;
    protected HashSet<String> alerts = new HashSet<>();


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(user_name);
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    // use case 2
    public Subscription(String arg_user_name, String arg_password){
        permissions = new Permissions();
    }

    @Override
    public void update(Observable o, Object arg) {

    }








}
