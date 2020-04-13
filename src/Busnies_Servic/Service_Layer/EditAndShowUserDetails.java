package Busnies_Servic.Service_Layer;

import Busnies_Servic.ActionStatus;
import Busnies_Servic.Business_Layer.UserManagement.Coach;
import Busnies_Servic.Business_Layer.UserManagement.Player;
import Busnies_Servic.Business_Layer.UserManagement.Referee;
import Busnies_Servic.Business_Layer.UserManagement.Subscription;

import java.time.LocalDate;
import java.util.Date;

public class EditAndShowUserDetails {

    public ActionStatus watchPersonalDetils(String user_name) {
        Subscription subscription = DataManagement.containSubscription(user_name);
        if(subscription == null){
            return new ActionStatus(false, "there is no subscription in the system by this username.");
        }
        if(subscription != DataManagement.getCurrent()){
            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        subscription.toString();
        return new ActionStatus(true, "The user details was successfully shown!");
    }

    public ActionStatus editSubscriptionName(String user_name, String newValue) {
        Subscription subscription = DataManagement.containSubscription(user_name);
        if(subscription == null){
            return new ActionStatus(false, "there is no subscription in the system by this username.");
        }
        if(subscription != DataManagement.getCurrent()){
            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        if(newValue == null || newValue.length() == 0){
            return new ActionStatus(false, "The new name is not legal");
        }
        subscription.setName(newValue);
        return new ActionStatus(true, "The name of the Subscription was successfully changed!");
    }

    public ActionStatus editSubscriptionEmail(String user_name, String newValue) {
        Subscription subscription = DataManagement.containSubscription(user_name);
        if(subscription == null){
            return new ActionStatus(false, "there is no subscription in the system by this username.");
        }
        if(subscription != DataManagement.getCurrent()){
            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        if(!DataManagement.checkEmail(newValue)){
            return new ActionStatus(false, "The new Email is not legal");
        }
        subscription.setEmail(newValue);
        return new ActionStatus(true, "The Email of the Subscription was successfully changed!");
    }

    public ActionStatus editSubscriptionUserName(String user_name, String newUserName, String currentPassword) {
        Subscription subscription = DataManagement.containSubscription(user_name);
        if(subscription != DataManagement.getCurrent()){
            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        if(DataManagement.InputTest(newUserName, currentPassword) != null) {
            return new ActionStatus(false, "The new User Name is not legal");
        }
        subscription.setUserName(newUserName);
        return new ActionStatus(true, "The User Name of the Subscription was successfully changed!");
    }

    public ActionStatus editSubscriptionPassword(String user_name, String currentUserName, String newPassword) {
        Subscription subscription = DataManagement.containSubscription(user_name);
        if(subscription != DataManagement.getCurrent()){
            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        if(DataManagement.InputTest(currentUserName, newPassword) != null) {
            return new ActionStatus(false, "The new password is not legal");
        }
        subscription.setPassword(newPassword);
        return new ActionStatus(true, "The password of the Subscription was successfully changed!");
    }

    public ActionStatus editCoachQualification(String user_name, String newValue) {
        Subscription subscription = DataManagement.containSubscription(user_name);
        if(subscription == null){
            return new ActionStatus(false, "there is no subscription in the system by this username.");
        }
        if (!(subscription instanceof Coach)) {
            return new ActionStatus(false, "The username is not defined as a coach on the system.");
        }
        if(subscription != DataManagement.getCurrent()){
            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        if(newValue == null || newValue.length() == 0){
            return new ActionStatus(false, "The new qualification is not legal");
        }
        Coach coach = (Coach) subscription;
        coach.setQualification(newValue);
        return new ActionStatus(true, "The Qualification of coach was successfully changed!");
    }

    public ActionStatus editCoachRoleInTeam(String user_name, String newValue) {
        Subscription subscription = DataManagement.containSubscription(user_name);
        if(subscription == null){
            return new ActionStatus(false, "there is no subscription in the system by this username.");
        }
        if (!(subscription instanceof Coach)) {
            return new ActionStatus(false, "The username is not defined as a coach on the system.");
        }
        if(subscription != DataManagement.getCurrent()){
            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        if(newValue == null || newValue.length() == 0){
            return new ActionStatus(false, "The new role is not legal");
        }
        Coach coach = (Coach) subscription;
        coach.setRoleInTeam(newValue);
        return new ActionStatus(true, "The role of coach was successfully changed!");
    }

    public ActionStatus editRefereeQualification(String user_name, String newValue) {
        Subscription subscription = DataManagement.containSubscription(user_name);
        if(subscription == null){
            return new ActionStatus(false, "there is no subscription in the system by this username.");
        }
        if (!(subscription instanceof Referee)) {
            return new ActionStatus(false, "The username is not defined as a Referee on the system.");
        }
        if(subscription != DataManagement.getCurrent()){
            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        if(newValue == null || newValue.length() == 0){
            return new ActionStatus(false, "The new qualification is not legal");
        }
        Referee referee = (Referee) subscription;
        referee.setQualification(newValue);
        return new ActionStatus(true, "The Qualification of Referee was successfully changed!");
    }

    public ActionStatus editPlayerPosition(String user_name, String newValue) {
        Subscription subscription = DataManagement.containSubscription(user_name);
        if(subscription == null){
            return new ActionStatus(false, "there is no subscription in the system by this username.");
        }
        if (!(subscription instanceof Player)) {
            return new ActionStatus(false, "The username is not defined as a player on the system.");
        }
        if(subscription != DataManagement.getCurrent()){
            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        if(newValue == null || newValue.length() == 0){
            return new ActionStatus(false, "The new position is not legal");
        }
        Player player = (Player)subscription;
        player.setPosition(newValue);
        return new ActionStatus(true, "The Position of player was successfully changed!");
    }

    public ActionStatus editPlayerDate(String user_name, LocalDate newValue) {
        Subscription subscription = DataManagement.containSubscription(user_name);
        if(subscription == null){
            return new ActionStatus(false, "there is no subscription in the system by this username.");
        }
        if (!(subscription instanceof Player)) {
            return new ActionStatus(false, "The username is not defined as a player on the system.");
        }
        if(subscription != DataManagement.getCurrent()){
            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        //need to check more on legal date (year, day ...)
        //consider change Date object
        if(newValue == null){
            return new ActionStatus(false, "The new birthday is not legal");
        }
        Player player = (Player)subscription;
        player.setBirthday(newValue);
        return new ActionStatus(true, "The birthday of player was successfully changed!");
    }

    public ActionStatus editPlayerPersonalPage(String user_name, Object[] values) {
        Subscription subscription = DataManagement.containSubscription(user_name);
        if (subscription == null) {
            return new ActionStatus(false, "there is no subscription in the system by this username.");
        }
        if (!(subscription instanceof Player)) {
            return new ActionStatus(false, "The username is not defined as a player on the system.");
        }
        if (subscription != DataManagement.getCurrent()) {
            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        Player player = (Player) subscription;
        if(!player.getPersonalPage().chackPerrmissionToEdit(user_name)){

            return new ActionStatus(false, "Another subscription is connected to the system.");
        }
        player.getPersonalPage().setDateOfBirth((Date) values[0]);
        player.getPersonalPage().setConutryOfBirth((String) values[1]);
        player.getPersonalPage().setCityOfBirth((String) values[2]);
        player.getPersonalPage().setHeight((String) values[3]);
        player.getPersonalPage().setWeight((String) values[4]);
        player.getPersonalPage().setPosition((String) values[5]);
        player.getPersonalPage().setJerseyNumber((String) values[6]);
        player.getPersonalPage().setSeasonYear((String) values[7]);
        return new ActionStatus(true, "The personal page of player was successfully update!");
    }
}
