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
        System.out.println("Admin Username : " + getUsername());
        System.out.println("Admin Email : " + getEmail());
        System.out.println("Department : " + department);
    }


}