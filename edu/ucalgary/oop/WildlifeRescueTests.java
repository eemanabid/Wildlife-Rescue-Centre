package edu.ucalgary.oop;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import static org.junit.Assert.*;
import org.junit.*;

public class WildlifeRescueTests {

    public WildlifeRescueTests() {}

    @Test
    public void getTaskIDTest() {
        Task newTask = new Task(1, 20, "Rebandage fox leg wound", 40);

        int taskGetID = newTask.getTaskID;
        int expectedResult = 1;
        assertEquals(expectedResult, taskGetID);
        
    }

    public void setTaskIDTest() {
        
        
    }









}