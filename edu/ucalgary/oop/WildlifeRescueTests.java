package edu.ucalgary.oop;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import java.util.regex.Matcher;

import static org.junit.Assert.*;
import org.junit.*;


public class WildlifeRescueTests {

    public WildlifeRescueTests() {}

    //Task Tests
    @Test
    public void getTaskIDTest() {
        Task newTask = new Task(1, 20, "Rebandage fox leg wound", 40);

        int taskGetID = newTask.getTaskID();
        int expectedResult = 1;
        assertEquals(expectedResult, taskGetID);
        
    }

    @Test
    public void setTaskIDTest() {
        Task newTask = new Task(1, 20, "Rebandage fox leg wound", 40);

        newTask.setTaskID(2);
        int getTaskID =  newTask.getTaskID();
        int expectedResult = 2;
        assertEquals(expectedResult, getTaskID);
        
    }

    //Treatment Tests
    @Test
    public void getStartHourTest() {
        Treatment newTreatment = new Treatment(1, 2, 3, 1);

        int getStartHour =  newTreatment.getStartHour();
        int expectedResult = 1;
        assertEquals(expectedResult, getStartHour);
        
    }

    @Test
    public void setStartHourTest() {
        Treatment newTreatment = new Treatment(1, 2, 3, 1);

        newTreatment.setStartHour(2);
        int getStartHour =  newTreatment.getStartHour();
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

    //Schedule Tests
    @Test
    public void ScheduleTest() {
        boolean correctException = false;

        Task newTask = new Task(1, 20, "Rebandage fox leg wound", 40);
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
    public void getAnimalIDTest() {
     Animal newAnimal = new Animal (1, "Eraser", "Fox" );

     int taskGetAnimalID = newAnimal.getAnimalID();
     int expectedResult = 1;
    assertEquals(expectedResult, taskGetAnimalID);
    }

    @Test
    public void setAnimalIDTest() {
        Animal newAnimal = new Animal(1, "Eraser", "Fox" );

        newAnimal.setAnimalID(2);
        int taskGetAnimalID =  newAnimal.getAnimalID();
        int expectedResult = 2;
        assertEquals(expectedResult, taskGetAnimalID);
        
    }

    @Test
    public void getAnimalNicknameTest() {
        Animal newAnimal = new Animal (1, "Eraser", "Fox" );

        String taskGetAnimalNickname = newAnimal.getAnimalNickname();
        String expectedResult = "Eraser";
       assertEquals(expectedResult, taskGetAnimalNickname);
        
    }

    @Test
    public void setAnimalNicknameTest() {
        Animal newAnimal = new Animal (1, "Eraser", "Fox" );

        newAnimal.setAnimalNickName("Slinky");
        String taskGetAnimalNickname = newAnimal.getAnimalNickname();
        String expectedResult = "Slinky";
       assertEquals(expectedResult, taskGetAnimalNickname);
        
    }

    @Test
    public void getAnimalSpeciesTest() {
        Animal newAnimal = new Animal (1, "Eraser", "Fox" );

        String taskGetAnimalSpecies = newAnimal.getAnimalSpecies();
        String expectedResult = "Fox";
       assertEquals(expectedResult, taskGetAnimalSpecies);
        
    }

    @Test
    public void setAnimalSpeciesTest() {
        Animal newAnimal = new Animal (1, "Eraser", "Fox" );

        newAnimal.setAnimalSpecies("Coyote");
        String taskGetAnimalSpecies = newAnimal.getAnimalSpecies();
        String expectedResult = "Coyote";
       assertEquals(expectedResult, taskGetAnimalSpecies);
        
    }
    
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
        assertEquals(AnimalCollection.RACOON, value5);
    }

    @Test(expected = IllegalArgumentException.class)
        public void testEnumValueOfWithInvalidValue() {
            // Arrange
            String invalid = "INVALID";

            // Act
            AnimalCollection value = AnimalCollection.valueOf(invalid);

        }

}