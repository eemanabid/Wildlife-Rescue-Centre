package edu.ucalgary.oop;

/**
 * Class AnimalCollection: 
 * @since 1.0
 * @author Hooriya Amjad <a href="mailto:hooriya.amjad@ucalgary.ca">hooriya.amjad@ucalgary.ca</a>
 * @author Sahiti Akella <a href="mailto:sahiti.akella@ucalgary.ca">sahiti.akella@ucalgary.ca</a>
 * @author Eeman Abid <a href="mailto:eeman.abid@ucalgary.ca">eeman.abid@ucalgary.ca</a>
 * @author Hareem Khan <a href="mailto:hareem.khan@ucalgary.ca">hareem.khan@ucalgary.ca</a>
 * @version 1.2
 */

public enum AnimalCollection {
    COYOTE,
    BEAVER,
    FOX,
    PORCUPINE,
    RACCOON;

    public String toString(){
        switch (this){
            case COYOTE: return "coyote";
            case BEAVER: return "beaver";
            case FOX: return "fox";
            case PORCUPINE: return "porcupine";
            case RACCOON: return "raccoon";
            default: return "";
        }
    }
}
