package edu.ucalgary.oop;

public class Treatment {
    private int treatmentID; 
    private int animalID; 
    private int taskID; 
    private int startHour;  

    public Treatment(int animalID, int taskID, int startHour){
        this.animalID = animalID;
        this.taskID = taskID;
        this.startHour = startHour;
    }

    public int getTreatmentID(){
        return 1;
    }

    public void setTreatmentID(int treatmentID){
        this.treatmentID = treatmentID;
    }

    public int getAnimalID(){
        return this.animalID;
    }

    public void setAnimalID(int animalID){
        this.animalID = animalID;
    }

    public int getTaskID(){
        return 1;
    }

    public void setTaskID(int taskID){
        this.taskID = taskID;
    }

    public int getStartHour(){
        return 1;
    }

    public void setStartHour(int startHour){
        this.startHour = startHour;
    }


}
