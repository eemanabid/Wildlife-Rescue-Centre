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

    public String getVolunteerID(){
        return this.volunteerID;
    }

    public String firstName(){
        return this.firstName;
    }

    public String lastName(){
        return this.lastName;
    }

    public String phoneNumber(){
        return this.phoneNumber;
    }

    public void setVolunteerID(String ID){
        this.volunteerID = ID;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPhoneNumber(String number){
        this.phoneNumber = number;
    }

}
