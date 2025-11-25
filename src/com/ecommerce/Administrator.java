package com.ecommerce;

public final class Administrator extends User {
    private String department;

    public Administrator (String username, String email) {
        super(username, email);
    }

    //methods
    //setter
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayProfile() {
        System.out.println("Administrator: " + getUsername() + " | Dept: " + department);
    }


}