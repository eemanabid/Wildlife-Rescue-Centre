package edu.ucalgary.oop;

import java.util.regex.Pattern;

public class Schedule {

    private Task task;
    private Animal animal;
    private int volunteerID;
    private boolean backupVolunteer;
    private final String REGEX = "\"([A-Z]+) - ([A-Z]{1,2})"; // CHANGE
    private final Pattern PATTERN = Pattern.compile(REGEX);

    public Schedule(){

    }

    public Task getTask(){

    }

    public void setTask (Task task){
        this.task = task;
    }

    public Animal getAnimal(){

    }

    public void setAnimal(Animal animal){
        this.animal = animal;
    }

    public int getVolunteerID (){
       return 1;
    }

    public void setTask (int volunteerID){
        this.volunteerID = volunteerID;
    }

    public String printSchedule(){
        return "";
    }

    
}

