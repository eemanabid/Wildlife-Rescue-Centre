package edu.ucalgary.oop;

public class Task {
    
private int taskID;
private int duration;
private String description;
private int maxWindow;

public Task(int taskID, String description, int duration, int maxWindow){
    this.taskID = taskID;
    this.description = description;
    this.duration = duration;
    this.maxWindow = maxWindow;
}

public int getTaskID(){
    return 1;
}

public void setTaskID(int taskID){
    this.taskID = taskID;
}

public int getDuration(){
    return 1;
}

public void setDuration(int duration){
    this.duration = duration;
}

public String getDescription(){
    return "";
}

public void setDescription(String description){
    this.description = description;
}

public int getMaxWindow(){
    return 1;
}

public void setMaxWindow(int maxWindow){
    this.maxWindow = maxWindow;
}


}
