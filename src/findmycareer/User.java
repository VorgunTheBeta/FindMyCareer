
// Josh has added this java file along with the subclasses UserAdmin and User Personal.

package findmycareer;

/**
 *
 * @author 7107723813
 */
public class User {
    private String email;
    private String password;
    private int accountLevel;
    private String lastLogin;
    private String fName;
    private String lName;

    public User()
    {
        this.email = "";
        this.password = "";
        this.accountLevel = 0;
        this.lastLogin = "";
        this.fName = "";
        this.lName = "";
    }

    public User(String email, String password, int accountLevel, String lastLogin, String fName, String lName)
    {
        this.email = email;
        this.password = password;
        this.accountLevel = accountLevel;
        this.lastLogin = lastLogin;
        this.fName = fName;
        this.lName = lName;
    }
     
    

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the accountLevel
     */
    public int getAccountLevel() {
        return accountLevel;
    }

    /**
     * @param accountLevel the accountLevel to set
     */
    public void setAccountLevel(int accountLevel) {
        this.accountLevel = accountLevel;
    }

    /**
     * @return the lastLogin
     */
    public String getLastLogin() {
        return lastLogin;
    }

    /**
     * @param lastLogin the lastLogin to set
     */
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

}

