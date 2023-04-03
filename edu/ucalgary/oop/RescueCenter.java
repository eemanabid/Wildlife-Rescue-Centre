package edu.ucalgary.oop;

import java.util.*;
import java.sql.*;

public class RescueCenter {

    private ArrayList<Animal> animals; 
    private ArrayList<Task> tasks; 
    private ArrayList<Treatment> treatments; 
    private ArrayList<Schedule> schedule;
    private Connection dbConnect;
    private ResultSet results;
     
    public RescueCenter(ArrayList<Animal> animals, ArrayList<Task> tasks, ArrayList<Treatment> treatments, ArrayList<Schedule> schedule){
        this.animals = animals;
        this.tasks = tasks;
        this.treatments = treatments;
        this.schedule = schedule;
    }

    public void createConnection(){

        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/pets", "root", "Mano804007503!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAnimal(int animalID, String animalNickname, String animalSpecies){
        try {

            String query = "INSERT INTO Animals (animalID, animalNickname, animalSpecies) VALUES (?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, String.valueOf(animalID));
            myStmt.setString(2, animalNickname);
            myStmt.setString(3, animalSpecies);

            int rowCount = myStmt.executeUpdate();
            System.out.println("Rows affected: " + rowCount);

            myStmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void removeAnimal(Animal deleteAnimal){
        
    }

    public void changeTask(Task newTask){
        
    }
}
