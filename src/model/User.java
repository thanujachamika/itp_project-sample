/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thanuja Chamika
 */
public class User {
    private String username;
    private int password;
    private int id;

    public User(String username, int password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, int password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}
