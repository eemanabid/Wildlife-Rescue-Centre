package edu.ucalgary.oop;

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
