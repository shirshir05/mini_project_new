package Busnies_Servic.Business_Layer.UserManagement;
import Busnies_Servic.Action;

import java.util.Observable;
public class Referee extends Subscription{

    protected String qualification;

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Referee(String arg_user_name, String arg_password) {
        super(arg_user_name, arg_password);
        permissions.edit_permissions(Action.Upload_personal_page,1);
        permissions.edit_permissions(Action.watch_game,1);
        permissions.edit_permissions(Action.update_event,1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Referee)) return false;
        Referee referee = (Referee) o;
        return referee.user_name.equals(this.user_name);
    }

}
