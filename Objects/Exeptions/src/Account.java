public class Account {
    private Integer attempts = 3;
    private String userID;
    private String password;

    public Account(String userID, String password)
    {
        this.userID = userID;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void attemptReset()
    {
        this.attempts = 3;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }
}
