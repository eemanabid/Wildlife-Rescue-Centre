package edu.ucalgary.oop;

public class Volunteer {
    private String volunteerID;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Volunteer(String firstName, String lastName, String volunteerID, String phoneNumber){
        this.firstName = firstName; 
        this.lastName = lastName;
        this.volunteerID = volunteerID;
        this.phoneNumber = phoneNumber;
    }

    
}
