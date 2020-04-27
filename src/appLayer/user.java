package appLayer;

public class user {

    public boolean isValidCredentials(String sUserName, String sUserPassword){
        if (sUserName.equals("bugrayildiz") && sUserPassword.equals("test123")){
            return true;
        }
        else{
            return false;
        }
    }
}
