package com.sellnow.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertoricogarcia on 15/3/17.
 */

public class User {

    private String user;
    private String pass;

    private String email;
    private String name;

    public User(){}

    public User(String user, String pass, String email, String name) {
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
