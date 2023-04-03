package edu.ucalgary.oop;

import java.util.*;
import java.sql.*;

public class RescueCenter {

    private ArrayList<Animal> animals; 
    private ArrayList<Task> tasks; 
    private ArrayList<Treatment> treatments;
    private Connection dbConnect;
    private ResultSet results;

    public RescueCenter(){
        try {
            PreparedStatement myStmt = dbConnect.prepareStatement("SELECT * FROM Animals");
            results = myStmt.executeQuery();

            while (results.next()){
                Animal animal = new Animal(results.getInt("AnimalID"), results.getString("AnimalNickname"), results.getString("AnimalSpecies"));
                animals.add(animal);
            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            PreparedStatement myStmt = dbConnect.prepareStatement("SELECT * FROM Tasks");
            results = myStmt.executeQuery();

            while (results.next()){
                Task task = new Animal(results.getInt("TaskID"), results.getString("Description"), results.getInt("Duration"), results.getInt("MaxWindow"));
                tasks.add(task);
            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void createConnection(){
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/treatments", "root", "Mano804007503!");
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

    public void removeAnimal(String deleteAnimal){
        try {
            String query = "DELETE FROM Animals WHERE name = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, deleteAnimal);

            int rowCount = myStmt.executeUpdate();
            System.out.println("Rows affected: " + rowCount);

            myStmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void changeTask(Task newTask){
        
    }
}
