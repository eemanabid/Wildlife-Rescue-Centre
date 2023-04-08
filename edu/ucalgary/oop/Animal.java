package edu.ucalgary.oop;


public class Animal {
    private int animalID;
    private String animalNickname;
    private String animalSpecies;
    private boolean task; //need relationship between task and animal
    private int feedTime; //added in feedTime, prepTime and cleanCageTime for setTimings()
    private int prepTime;
    private String activeType;
    private int cleanCageTime;

    public Animal(int animalID, String animalNickname, String animalSpecies){
        this.animalID = animalID;
        this.animalNickname = animalNickname;
        this.animalSpecies = animalSpecies;
        setTimings();
    }

    //task timings for each animal species
    public void setTimings() {
        switch (animalSpecies) {
            case "fox":
                this.feedTime = 5;
                this.prepTime = 5;
                this.cleanCageTime = 5;
                this.activeType = "nocturnal";
                break;
            case "porcupine":
                this.feedTime = 5;
                this.prepTime = 0;
                this.cleanCageTime = 10;
                this.activeType = "crepuscular";
                break;
            case "coyote":
                this.feedTime = 5;
                this.prepTime = 10;
                this.cleanCageTime = 5;
                this.activeType = "crepuscular";
                break;
            case "beaver":
                this.feedTime = 5;
                this.prepTime = 0;
                this.cleanCageTime = 5;
                this.activeType = "diurnal";
                break;
            case "raccoon":
                this.feedTime = 5;
                this.prepTime = 0;
                this.cleanCageTime = 5;
                this.activeType = "nocturnal";
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
}
