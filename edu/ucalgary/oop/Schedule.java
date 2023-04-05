package edu.ucalgary.oop;


import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Schedule {


   private Task task;
   private Animal animal;
   private int volunteerID;
   private boolean backupVolunteer;
   private final String REGEX = "\"([A-Z]+) - ([A-Z]{1,2})"; // CHANGE
   private final Pattern PATTERN = Pattern.compile(REGEX);
   LocalDate currentDate = LocalDate.now();
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
   String formattedDate = currentDate.format(formatter);


   public Schedule(Task task, Animal animal, int volunteerID, boolean backupVolunteer){
       this.task = task;
       this.animal = animal;
       this.volunteerID = volunteerID;
       this.backupVolunteer = backupVolunteer;
   }


   public Task getTask(){
       return task;
   }


   public void setTask (Task task){
       this.task = task;
   }


   public Animal getAnimal(){
       return animal;
   }


   public void setAnimal(Animal animal){
       this.animal = animal;
   }


   public int getVolunteerID (){
      return volunteerID;
   }


   public void setTask (int volunteerID){
       this.volunteerID = volunteerID;
   }


   public String printSchedule(){
       StringBuilder sb = new StringBuilder();
       sb.append("Schedule for" + formattedDate);


   }


  
}