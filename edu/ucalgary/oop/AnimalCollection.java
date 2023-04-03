package edu.ucalgary.oop;

public enum AnimalCollection {
    COYOTE,
    BEAVER,
    FOX,
    PORCUPINE,
    RACCOON;

    public String toString(){
        switch (this){
            case COYOTE: return "Coyote";
            case BEAVER: return "Beaver";
            case FOX: return "Fox";
            case PORCUPINE: return "Porcupine";
            case RACCOON: return "Raccoon";
            default: return "";
        }
    }
}
