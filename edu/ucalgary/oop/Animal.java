package edu.ucalgary.oop;

/**
 * Class Animal: 
 * @since 1.0
 * @author Hooriya Amjad <a href="mailto:hooriya.amjad@ucalgary.ca">hooriya.amjad@ucalgary.ca</a>
 * @author Sahiti Akella <a href="mailto:sahiti.akella@ucalgary.ca">sahiti.akella@ucalgary.ca</a>
 * @author Eeman Abid <a href="mailto:eeman.abid@ucalgary.ca">eeman.abid@ucalgary.ca</a>
 * @author Hareem Khan <a href="mailto:hareem.khan@ucalgary.ca">hareem.khan@ucalgary.ca</a>
 * @version 1.2
 */
public class Animal {
    private int animalID;
    private String animalNickname;
    private String animalSpecies;
    private boolean task; // need relationship between task and animal
    private int feedTime; // added in feedTime, prepTime and cleanCageTime for setTimings()
    private int prepTime;
    private String activeType;
    private boolean feedingPrinted;
    private boolean nocturnalPrinted;
    private boolean diurnalPrinted;
    private boolean crepuscularPrinted;
    private int cleanCageTime;

    public Animal(int animalID, String animalNickname, String animalSpecies){
        this.animalID = animalID;
        this.animalNickname = animalNickname;
        this.animalSpecies = animalSpecies;
        setTimings();
    }

    // task timings for each animal species
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

    // getters
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

    public String getActiveType() {
        return this.activeType;
    }

    // setters
    public void setFeedingPrinted(boolean printed) {
        this.feedingPrinted = printed;
    }

    public void setNocturnalPrinted(boolean printed) {
        this.nocturnalPrinted = printed;
    }

    public void setDiurnalPrinted(boolean printed) {
        this.diurnalPrinted = printed;
    }

    public void setCrepuscularPrinted(boolean printed) {
        this.crepuscularPrinted = printed;
    }

    // helper functions
    public boolean isFeedingPrinted() {
        return this.feedingPrinted;
    }

    public boolean isNocturnalPrinted() {
        return this.nocturnalPrinted;
    }

    public boolean isDiurnalPrinted() {
        return this.diurnalPrinted;
    }

    public boolean isCrepuscularPrinted() {
        return this.crepuscularPrinted;
    }
}
