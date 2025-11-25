package com.ecommerce;

public class Customer extends User {
    private String address;

    //Constructor 1 : Chaining (calls constructor 2)
    public Customer(String username) {
        //Method Overloading - auto generate temporary email
        this(username, username + "@temp.com");
    }

    //Constructor 2 : Full details, calls parent constructor via super()
    public Customer(String username, String email) {
        super(username, email);
        this.address = "N/A";
    }

    //Override the abstract method from user (Polymorphism)
    @Override
    public void displayProfile() {
        System.out.println("Customer Profile: " + getUsername() + " | Email: " + getEmail());
    }

    //Getter/Setter for address (encapsulation)
    public void setAddress(String address) {
        this.address = address;
    }
}