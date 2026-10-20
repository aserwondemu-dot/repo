/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for PropertyDriver: menu choices, adding
 * through the menu, invalid input, and the programmer name.
 * Due: 10/19/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Aser Wondemu
 */

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Student JUnit tests for PropertyDriver. Typed input is simulated with a
 * Scanner over a String, and console output is captured.
 */
public class PropertyDriverJUnitTestStudent {

    private ByteArrayOutputStream output;
    private PrintStream originalOut;
    private ManagementCompany company;

    /**
     * Captures System.out and creates an empty company before each test.
     */
    @BeforeEach
    public void setUp() {
        originalOut = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        company = new ManagementCompany("Campus Realty", "123-45-6789");
    }

    /**
     * Restores System.out after each test.
     */
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    /** Choosing 1 adds a property, then 4 exits. */
    @Test
    public void testAddThroughMenu() {
        Scanner in = new Scanner("1\nCedar Court\nRockville\n2100\nJoe\n4\n");
        PropertyDriver.run(in, company);
        assertEquals(1, company.getPropertyCount());
        assertEquals(2100.0, company.totalRent(), 0.001);
        assertTrue(output.toString().contains("Property added at index 0."));
    }

    /** Choosing 3 shows the total rent. */
    @Test
    public void testShowTotalRent() {
        company.addProperty(new Property("A", "X", 1000.0, "O"));
        company.addProperty(new Property("B", "Y", 500.0, "P"));
        PropertyDriver.run(new Scanner("3\n4\n"), company);
        assertTrue(output.toString().contains("Total rent: $1500.00"));
    }

    /** An invalid menu choice prints an error and the program keeps going. */
    @Test
    public void testInvalidChoice() {
        PropertyDriver.run(new Scanner("9\n4\n"), company);
        assertTrue(output.toString().contains("Invalid choice"));
    }

    /** A non-numeric rent is rejected, then a valid rent is accepted. */
    @Test
    public void testInvalidRentThenValid() {
        Scanner in = new Scanner("1\nPine Flat\nOlney\nabc\n1750\nAmy\n4\n");
        PropertyDriver.run(in, company);
        assertTrue(output.toString().contains("Invalid rent"));
        assertEquals(1750.0, company.totalRent(), 0.001);
    }

    /** Exiting prints the programmer's name. */
    @Test
    public void testProgrammerNamePrinted() {
        PropertyDriver.run(new Scanner("4\n"), company);
        assertTrue(output.toString().contains("Program written by: Aser Wondemu"));
    }
}
