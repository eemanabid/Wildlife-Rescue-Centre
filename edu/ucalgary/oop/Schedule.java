package edu.ucalgary.oop;

import java.util.regex.Pattern;

public class Schedule {
    private Task task;
    private Animal animal;
    private boolean backupVolunteer = false;
    private int timeSpent;
    private int timeAvailable = 60;
    private int startTime;
    //private final String REGEX = "\"([A-Z]+) - ([A-Z]{1,2})"; // CHANGE
    //private final Pattern PATTERN = Pattern.compile(REGEX);
 
    public Schedule(Task task, Animal animal, int startTime, int timeSpent, boolean backupVolunteer){
        this.task = task;
        this.animal = animal;
        this.startTime = startTime;
        this.timeSpent = timeSpent;
        this.timeAvailable -= timeSpent;
        this.backupVolunteer = backupVolunteer;
    }

    public Task getTask(){
       return task;
    }

    public void setTask (Task task){
       this.task = task;
    }

    public Animal getAnimal(){
       return animal;
    }

    public void setAnimal(Animal animal){
       this.animal = animal;
    }

    public void setStartTime(int startTime){
        this.startTime = startTime;
    }

    public void setTimeSpent(int timeSpent){
        this.timeSpent = timeSpent;
    }

    public void setTimeAvailable(int timeAvailable){
        this.timeAvailable = timeAvailable;
    }
}