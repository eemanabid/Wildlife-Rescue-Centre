package edu.ucalgary.oop;

/**
 * Class Task: task object and task methods for executing application
 * @since 1.0
 * @author Hooriya Amjad <a href="mailto:hooriya.amjad@ucalgary.ca">hooriya.amjad@ucalgary.ca</a>
 * @author Sahiti Akella <a href="mailto:sahiti.akella@ucalgary.ca">sahiti.akella@ucalgary.ca</a>
 * @author Eeman Abid <a href="mailto:eeman.abid@ucalgary.ca">eeman.abid@ucalgary.ca</a>
 * @author Hareem Khan <a href="mailto:hareem.khan@ucalgary.ca">hareem.khan@ucalgary.ca</a>
 * @version 1.2
 */

public class Task {
        
    private int taskID;
    private int duration;
    private String description;
    private int maxWindow;

    // constructor
    public Task(int taskID, String description, int duration,  int maxWindow){
        this.taskID = taskID;
        this.description = description;
        this.duration = duration;
        this.maxWindow = maxWindow;
    }

    // getters
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
