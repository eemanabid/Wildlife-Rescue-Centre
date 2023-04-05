package edu.ucalgary.oop;

import java.util.*;
import java.sql.*;

public class RescueCenter {

    private ArrayList<Animal> animals = new ArrayList<Animal>(); 
    private ArrayList<Task> tasks = new ArrayList<Task>(); 
    private ArrayList<Treatment> treatments = new ArrayList<Treatment>();
    private Connection dbConnect;
    private ResultSet results;
    private final String DBURL = "jdbc:mysql://localhost/EWR";
    private final String USERNAME = "root";
    private final String PASSWORD = "Mano804007503!";

    public RescueCenter(){
        createConnection();
        
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

    public void createConnection(){
        try{
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
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

    public static void main(String[] args) {
        RescueCenter rescueCenter = new RescueCenter();
        //rescueCenter.createConnection();
    
        ArrayList<Animal> animals = rescueCenter.getAnimalList();
        for (Animal animal : animals) {
            System.out.println(animal.getAnimalID());
        }
    
        ArrayList<Task> tasks = rescueCenter.getTaskList();
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }
    
}
