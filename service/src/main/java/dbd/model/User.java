package dbd.model;

public abstract class User {

    private LoginDetails login;

    public LoginDetails getLogin() {
        return login;
    }

    public void setLogin(LoginDetails login) {
        this.login = login;
    }
}
