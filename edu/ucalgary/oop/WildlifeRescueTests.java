package edu.ucalgary.oop;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import java.util.regex.Matcher;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Class WidlifeRescueTests: 
 * @since 1.0
 * @author Hooriya Amjad <a href="mailto:hooriya.amjad@ucalgary.ca">hooriya.amjad@ucalgary.ca</a>
 * @author Sahiti Akella <a href="mailto:sahiti.akella@ucalgary.ca">sahiti.akella@ucalgary.ca</a>
 * @author Eeman Abid <a href="mailto:eeman.abid@ucalgary.ca">eeman.abid@ucalgary.ca</a>
 * @author Hareem Khan <a href="mailto:hareem.khan@ucalgary.ca">hareem.khan@ucalgary.ca</a>
 * @version 1.2
 */

public class WildlifeRescueTests {

    public WildlifeRescueTests() {}

    //Task Tests
    /*
     * Test case for testing the getTaskID() method of the Task class.
     * It creates a new Task object with specific values using the constructor,
     * then calls getTaskID() method and compares the returned value with the expected result.
     */
    @Test
    public void getTaskIDTest() {
        Task newTask = new Task(1,"Rebandage fox leg wound", 20, 40);

        int taskGetID = newTask.getTaskID();
        int expectedResult = 1;
        assertEquals("Incorrect Task ID", expectedResult, taskGetID);
        
    }

    /*
     * Test case for testing the getDuration() method of the Task class.
     * It creates a new Task object with specific values using the constructor,
     * then calls getDuration() method and compares the returned value with the expected result.
     */
    @Test
    public void getDurationTest() {
        Task newTask = new Task(1,"Rebandage fox leg wound", 20, 40);

        int taskGetDuration = newTask.getDuration();
        int expectedResult = 20;
        assertEquals("Incorrect Duration", expectedResult, taskGetDuration);
        
    }

    /*
     * Test case for testing the getDescription() method of the Task class.
     * It creates a new Task object with specific values using the constructor,
     * then calls getDescription() method and compares the returned value with the expected result.
     */
    @Test
    public void getDescriptionTest() {
        Task newTask = new Task(1,"Rebandage fox leg wound", 20, 40);

        String taskGetDescription = newTask.getDescription();
        String expectedResult = "Rebandage fox leg wound";
        assertEquals("Incorrect Description", expectedResult, taskGetDescription);
        
    }

    /*
     * Test case for testing the getMaxWindow() method of the Task class.
     * It creates a new Task object with specific values using the constructor,
     * then calls getMaxWindow() method and compares the returned value with the expected result.
     */
    @Test
    public void getMaxWindow() {
        Task newTask = new Task(1,"Rebandage fox leg wound", 20, 40);

        int taskGetMaxWindow = newTask.getMaxWindow();
        int expectedResult = 40;
        assertEquals("Incorrect Max Window", expectedResult, taskGetMaxWindow);
        
    }

    /*
     * Test case for testing the constructor of the Task class.
     * It creates a new Task object with specific values using the constructor,
     * then calls getter methods to check if the values are properly set in the object.
     */
    @Test
    public void testTaskConstructor() {
        int taskID = 1;
        String description = "Rebandage fox leg wound";
        int duration = 20;
        int maxWindow = 40;

        Task newTask = new Task(taskID, description, duration, maxWindow);

        // Check if the values are properly set in the constructor
        assertEquals("Incorrect Task ID", taskID, newTask.getTaskID());
        assertEquals("Incorrect Description", description, newTask.getDescription());
        assertEquals("Incorrect Duration", duration, newTask.getDuration());
        assertEquals("Incorrect Max Window", maxWindow, newTask.getMaxWindow());
    }


    //Treatment Tests
    @Test
    public void getStartHourTest() {
        Treatment newTreatment = new Treatment(1, 2, 3);

        int getStartHour =  newTreatment.getStartHour();
        int expectedResult = 3;
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

    //Schedule Tests
    @Test
    public void ScheduleTest() {
        boolean correctException = false;

        Task newTask = new Task(1, "Rebandage fox leg wound", 20, 40);
        Animal newAnimal = new Animal(1, "Gatekeeper", "fox", true, false, true);

        try {
            Schedule newSchedule = new Schedule(newTask, newAnimal, "abc", true);

        } catch (IllegalArgumentException e) {
            correctException = true;
        }

        assertEquals(true, correctException);
        
    }


//ANIMAL TESTS
    @Test
    public void testAnimalConstructor() {
        int animalID = 1;
        String animalNickname = "Eraser";
        String animalSpecies = "Fox";
    
        Animal animal = new Animal(animalID, animalNickname, animalSpecies);
    
        assertEquals(animalID, animal.getAnimalID());
        assertEquals(animalNickname, animal.getAnimalNickname());
        assertEquals(animalSpecies, animal.getAnimalSpecies());
}

    @Test
    public void getAnimalIDTest() {
     Animal newAnimal = new Animal (1, "Eraser", "Fox" );

     int taskGetAnimalID = newAnimal.getAnimalID();
     int expectedResult = 1;
    assertEquals(expectedResult, taskGetAnimalID);
    }

    /*
     * 
     @Test
     public void setAnimalIDTest() {
         Animal newAnimal = new Animal(1, "Eraser", "Fox" );
 
         newAnimal.setAnimalID(2);
         int taskGetAnimalID =  newAnimal.getAnimalID();
         int expectedResult = 2;
         assertEquals(expectedResult, taskGetAnimalID);
         
     }
     */

    @Test
    public void getAnimalNicknameTest() {
        Animal newAnimal = new Animal (1, "Eraser", "Fox" );

        String taskGetAnimalNickname = newAnimal.getAnimalNickname();
        String expectedResult = "Eraser";
       assertEquals(expectedResult, taskGetAnimalNickname);
        
    }

    /*
     * 
     @Test
     public void setAnimalNicknameTest() {
         Animal newAnimal = new Animal (1, "Eraser", "Fox" );
 
         newAnimal.setAnimalNickName("Slinky");
         String taskGetAnimalNickname = newAnimal.getAnimalNickname();
         String expectedResult = "Slinky";
        assertEquals(expectedResult, taskGetAnimalNickname);
         
     }
     */

    @Test
    public void getAnimalSpeciesTest() {
        Animal newAnimal = new Animal (1, "Eraser", "Fox" );

        String taskGetAnimalSpecies = newAnimal.getAnimalSpecies();
        String expectedResult = "Fox";
       assertEquals(expectedResult, taskGetAnimalSpecies);
        
    }

    /*
     * 
     @Test
     public void setAnimalSpeciesTest() {
         Animal newAnimal = new Animal (1, "Eraser", "Fox" );
 
         newAnimal.setAnimalSpecies("Coyote");
         String taskGetAnimalSpecies = newAnimal.getAnimalSpecies();
         String expectedResult = "Coyote";
        assertEquals(expectedResult, taskGetAnimalSpecies);
         
     }
     */
    
    @Test
    public void testAnimalCollectionEnumValueOf() {
        // Arrange
        String coyote = "COYOTE";
        String beaver = "BEAVER";
        String fox = "FOX";
        String porcupine = "PORCUPINE";
        String racoon = "RACOON";

        // Act
        AnimalCollection value1 = AnimalCollection.valueOf(coyote);
        AnimalCollection value2 = AnimalCollection.valueOf(beaver);
        AnimalCollection value3 = AnimalCollection.valueOf(fox);
        AnimalCollection value4 = AnimalCollection.valueOf(porcupine);
        AnimalCollection value5 = AnimalCollection.valueOf(racoon);

        // Assert
        assertEquals(AnimalCollection.COYOTE, value1);
        assertEquals(AnimalCollection.BEAVER, value2);
        assertEquals(AnimalCollection.FOX, value3);
        assertEquals(AnimalCollection.PORCUPINE, value4);
        assertEquals(AnimalCollection.RACCOON, value5);
    }

    @Test(expected = IllegalArgumentException.class)
        public void testEnumValueOfWithInvalidValue() {
            // Arrange
            String invalid = "INVALID";

            // Act
            AnimalCollection value = AnimalCollection.valueOf(invalid);

        }
}