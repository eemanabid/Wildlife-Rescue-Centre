package edu.ucalgary.oop;

public class Task {
        
    private int taskID;
    private int duration;
    private String description;
    private int maxWindow;

    public Task(int taskID, String description, int duration,  int maxWindow){
        this.taskID = taskID;
        this.description = description;
        this.duration = duration;
        this.maxWindow = maxWindow;
    }

    public int getTaskID(){
        return taskID;
    }

    public int getDuration(){
        return this.duration;
    }

    public String getDescription(){
        return this.description;
    }

    public int getMaxWindow(){
        return this.maxWindow;
    }
}
