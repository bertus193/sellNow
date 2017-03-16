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

    public List<User> getListUsers(){
        List<User> users = new ArrayList<>();

        User user1 = new User();
        User user2 = new User();

        user1.setUser("admin");
        user1.setPass("admin");
        user1.setName("richard@gnu.com");
        user1.setEmail("Richard Stallman");

        users.add(user1);

        return users;
    }


}
