package com.ecommerce;

public abstract class User {
    private String username;
    private String email;

    //default full argument cons
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    //1
    //getter Encapsulation return type String
    public String getUsername() {
        return username;
    }
    //2
    //setter (void = no return type)
    public void setUsername(String username) {
        this.username = username;
    }

    //3
    //getter return type String (email)
    public String getEmail() {
        return email;
    }

    //4
    public void setEmail(String email) {
        this.email = email;
    }

    //abstract method (inherited class must provide body)
    public abstract void displayProfile();
}