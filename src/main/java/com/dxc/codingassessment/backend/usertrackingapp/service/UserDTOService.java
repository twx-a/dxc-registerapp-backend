package com.dxc.codingassessment.backend.usertrackingapp.service;

//DTO, Data Transfer Object. This allows me to receive passwords
// Handles login request. because I have json ignore password on user class.

public class UserDTOService {
    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final char manager;

    public UserDTOService(String email, String password, String firstName, String lastName, char manager){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.manager = manager;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public char getManager() {
        return manager;
    }
}
