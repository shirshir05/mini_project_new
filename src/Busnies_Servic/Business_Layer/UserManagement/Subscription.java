package Busnies_Servic.Business_Layer.UserManagement;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public abstract class Subscription {
    protected String userName;
    public String password;
    public Permissions permissions;
    public String email;

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

    public Permissions getPermissions() {
        return permissions;
    }

    public void setPassword(String password) {
        this.password = getHash(password);
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

}
