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

    public Animal(){
    }

    public void createConnection(){
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/treatments", "root", "Mano804007503!");
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
    }


    //public void setAnimalID(int animalID){
        //this.animalID = animalID;
    //}

    public String getAnimalNickname(){
        return "";
    }

    //public void setAnimalNickname(String animalNickname){
       // this.animalNickname = animalNickname;
    //}

    public String getAnimalSpecies(){
        return "";
    }

    //public void setAnimalSpecies(String animalSpecies){
        //this.animalSpecies = animalSpecies;
    //}

    

    
}
