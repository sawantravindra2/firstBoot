package com.ravi.model;

public class EmployeeDTO {

    private String firstname;
    private String lastname;

    private Address userAddress;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    public EmployeeDTO(){

    }

    public EmployeeDTO(String firstname, String lastname, Address userAddress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.userAddress = userAddress;
    }
}
