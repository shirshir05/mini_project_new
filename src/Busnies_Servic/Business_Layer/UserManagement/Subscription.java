package Busnies_Servic.Business_Layer.UserManagement;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;


public abstract class Subscription {
    protected String userName;
    private String password;
    public Permissions permissions;
    public String email;
    protected String name;

    protected HashSet<String> alerts = new HashSet<>();

    public Subscription(String argUserName, String argPassword,String email){
        userName=argUserName;
        password = getHash(argPassword);
        permissions = new Permissions();
        this.email = email;
    }

    /**
     * This function returns the hash of the password
     */
    private String getHash(String password){
        String sha1 = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes("utf8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return sha1;
    }

    /**
     * This function returns the subscription alerts
     */
    public String getAlerts(){
        String ans = "";
        for (String alert : alerts){
            ans = ans + alert +"\n";
        }
        return ans;
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
        return Objects.equals(userName, that.userName);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPassword(String password) {
        this.password = getHash(password);
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }

    public void addAlert(String s){alerts.add(s);}

    public String sendEMail(String mailto, String mail){
        return "Send to: "+mailto+"From: "+this.email+"Mail: "+mail;
    }

}




