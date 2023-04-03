package edu.ucalgary.oop;

import java.sql.*;

public class Animal {
    private int animalID;
    private String animalNickname;
    private String animalSpecies;
    private boolean isNocturnal;
    private boolean isDiurnal;
    private boolean isCrepuscular;
    private Connection dbConnect;
    private ResultSet results;

    private boolean task; //need relationship between task and animal
    private int feedTime; //added in feedTime, prepTime and cleanCageTime for setTimings()
    private int prepTime;
    private int cleanCageTime;

    public Animal(){

    }

    public void createConnection(){
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/treatments", "mano", "804007503");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getAnimalID(String animalNickname){
        this.animalID = -1;

        try {
            PreparedStatement myStmt = dbConnect.prepareStatement("SELECT AnimalID FROM Animals WHERE AnimalNickname = ?");
            myStmt.setString(1, animalNickname);
            results = myStmt.executeQuery();

            while (results.next()){
                animalID = results.getInt("AnimalID");
            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return animalID;
        this.animalID = animalID;
        this.animalNickname = animalNickname;
        this.animalSpecies = animalSpecies;
        this.task = false;
        setTimings();
    }

    //task timings for each animal species
    public void setTimings() {
        switch (animalSpecies) {
            case "fox":
                this.feedTime = 5;
                this.prepTime = 5;
                this.cleanCageTime = 5;
                break;
            case "porcupine":
                this.feedTime = 5;
                this.prepTime = 0;
                this.cleanCageTime = 10;
                break;
            case "coyote":
                this.feedTime = 5;
                this.prepTime = 10;
                this.cleanCageTime = 5;
                break;
            case "beaver":
                this.feedTime = 5;
                this.prepTime = 0;
                this.cleanCageTime = 5;
                break;
            case "raccoon":
                this.feedTime = 5;
                this.prepTime = 0;
                this.cleanCageTime = 5;
                break;
            default:
                System.out.println("Error: Animal species not found");
                break;

        }
    }

    //getters
    public int getAnimalID(){
        return this.animalID;
    }

    public String getAnimalNickname(){
        return this.animalNickname;
    }

    //public void setAnimalNickname(String animalNickname){
       // this.animalNickname = animalNickname;
    //}
        //return this.animalNickname;
    //}


    public String getAnimalSpecies(){
        return this.animalSpecies;
    }

    public Boolean getTask() {
        return this.task;
    }

    public int getFeedTime() {
        return this.feedTime;
    }

    public int getPrepTime() {
        return this.prepTime;
    }

    public int getCageCleanTime() {
        return this.cleanCageTime;
    }

    //setters
    public void setAnimalNickname(String animalNickname){
        this.animalNickname = animalNickname;
    }

    //public void setAnimalSpecies(String animalSpecies){
        //this.animalSpecies = animalSpecies;
    //}

    public void setTask(boolean task) {
        this.task = task;
    }

    public void setAnimalID(int animalID){
        this.animalID = animalID;
    }

    //public void setAnimalID(int animalID){
        //this.animalID = animalID;
    //}
    

    
}
