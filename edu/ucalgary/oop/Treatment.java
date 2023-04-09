package edu.ucalgary.oop;

/**
 * Class Treatment: 
 * @since 1.0
 * @author Hooriya Amjad <a href="mailto:hooriya.amjad@ucalgary.ca">hooriya.amjad@ucalgary.ca</a>
 * @author Sahiti Akella <a href="mailto:sahiti.akella@ucalgary.ca">sahiti.akella@ucalgary.ca</a>
 * @author Eeman Abid <a href="mailto:eeman.abid@ucalgary.ca">eeman.abid@ucalgary.ca</a>
 * @author Hareem Khan <a href="mailto:hareem.khan@ucalgary.ca">hareem.khan@ucalgary.ca</a>
 * @version 1.2
 */

public class Treatment {
    private static int nextTreatmentID = 1;
    private int treatmentID; 
    private int animalID; 
    private int taskID; 
    private int startHour;  

    // constructor
    public Treatment(int animalID, int taskID, int startHour){
        this.treatmentID = nextTreatmentID++;
        this.animalID = animalID;
        this.taskID = taskID;
        this.startHour = startHour;
    }

    // getters
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
