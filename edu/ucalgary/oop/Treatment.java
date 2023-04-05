package edu.ucalgary.oop;

public class Treatment {
    private static int nextTreatmentID = 1;
    private int treatmentID; 
    private int animalID; 
    private int taskID; 
    private int startHour;  

    public Treatment(int animalID, int taskID, int startHour){
        this.treatmentID = nextTreatmentID++;
        this.animalID = animalID;
        this.taskID = taskID;
        this.startHour = startHour;
    }

    public int getTreatmentID(){
        return this.treatmentID;
    }

    public int getAnimalID(){
        return this.animalID;
    }

    public int getTaskID(){
        return this.taskID;
    }

    public int getStartHour(){
        return this.startHour;
    }
}
