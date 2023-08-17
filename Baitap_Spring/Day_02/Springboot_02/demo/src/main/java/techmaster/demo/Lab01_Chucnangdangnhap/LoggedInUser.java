package techmaster.demo.Lab01_Chucnangdangnhap;

public class LoggedInUser {
    private String username;
    private String email;
    private String avatar;

    // Constructors
    public LoggedInUser(String username, String email, String avatar) {
        this.username = username;
        this.email = email;
        this.avatar = avatar;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
