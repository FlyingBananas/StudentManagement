package dbd.frontend.controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dear
 */

public class StudentViewModel {
    
    private String username;
    private String password;
    private String name;    
    private String matriculationNumber;
    
     public StudentViewModel() {
    }

    public StudentViewModel(String username, String password, String name, String matriculationNumber) {
        this.username = username;
        this.password = password;
        this.matriculationNumber = matriculationNumber;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }
    
}
