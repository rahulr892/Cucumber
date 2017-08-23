package stepdefinitions;

/**
 * Created by rahulrana on 20/08/17.
 */
public class UserData {

    private String username;
    private String password;
    private String confirmPassword;

    public UserData(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

}


