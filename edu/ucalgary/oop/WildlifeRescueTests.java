package edu.ucalgary.oop;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import static org.junit.Assert.*;
import org.junit.*;

public class WildlifeRescueTests {

    public WildlifeRescueTests() {}

    //Task Tests
    @Test
    public void getTaskIDTest() {
        Task newTask = new Task(1, 20, "Rebandage fox leg wound", 40);

        int taskGetID = newTask.getTaskID;
        int expectedResult = 1;
        assertEquals(expectedResult, taskGetID);
        
    }

    @Test
    public void setTaskIDTest() {
        Task newTask = new Task(1, 20, "Rebandage fox leg wound", 40);

        newTask.setTaskID(2);
        int getTaskID =  newTask.getTaskID;
        int expectedResult = 2;
        assertEquals(expectedResult, getTaskID);
        
    }

    //Treatment Tests
    @Test
    public void getStartHourTest() {
        Treatment newTreatment = new Treatment(1, 2, 3, 1);

        int getStartHour =  newTreatment.getStartHour;
        int expectedResult = 1;
        assertEquals(expectedResult, getStartHour);
        
    }

    @Test
    public void setStartHourTest() {
        Treatment newTreatment = new Treatment(1, 2, 3, 1);

        newTreatment.setStartHour(2);
        int getStartHour =  newTreatment.getStartHour;
        int expectedResult = 2;
        assertEquals(expectedResult, getStartHour);
        
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
    // Create an object to be cloned
    Animal obj1 = new Animal();
    obj1.setAnimalNickname("Eraser");

    // Clone the object
    Animal obj2 = (Animal) obj1.clone();

    // Verify that the cloned object is a separate object from the original
    assertNotSame(obj1, obj2);

    // Verify that the properties of the cloned object match those of the original
    assertEquals(obj1.getAnimalNickname(), obj2.getAnimalNickname());

    // Modify the cloned object
    obj2.setAnimalNickname("Gatekeeper");

    // Verify that the modification of the cloned object did not affect the original
    assertNotEquals(obj1.getAnimalNickname(), obj2.getAnimalNickname());
    }

}