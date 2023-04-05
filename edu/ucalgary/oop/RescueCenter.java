package edu.ucalgary.oop;

import java.util.*;
import java.sql.*;

public class RescueCenter {

    private ArrayList<Animal> animals; 
    private ArrayList<Task> tasks; 
    private ArrayList<Treatment> treatments;
    private Connection dbConnect;
    private ResultSet results;

    public void createConnection(){
        try{
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/treatments", "mano", "804007503");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
                Task task = new Task(results.getInt("TaskID"), results.getString("Description"), results.getInt("Duration"), results.getInt("MaxWindow"));
                tasks.add(task);
            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Animal> getAnimalList() {
        return this.animals;
    }

    public ArrayList<Task> getTaskList() {
        return this.tasks;
    }

    public ArrayList<Treatment> getFurnitureList() {
        return this.treatments;
    }
}
