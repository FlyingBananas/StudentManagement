package dbd.model;

public abstract class User {

    private LoginDetails login;
    
    //0 teacher[admin]
    //1 student[regular user]
    private int role;

    public LoginDetails getLogin() {
        return login;
    }

    public void setLogin(LoginDetails login) {
        this.login = login;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    
}
