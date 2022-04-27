/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Repository.PersonRepo;
import Repository.UserRepo;

/**
 *
 * @author ash
 */
public class User {
    private String userId;
    private String password;
    private String role;
    private Person person;
    PersonRepo pr = new PersonRepo();

    public User(String userId, String password, String role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.person = pr.getPersonDetails(userId);
    }

    public User() {
        person = new Person();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        this.person = pr.getPersonDetails(userId);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
}
