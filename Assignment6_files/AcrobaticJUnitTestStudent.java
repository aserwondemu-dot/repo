/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for the Acrobatic class.
 * Due: 11/23/2026
 * Platform/Compiler: Eclipse
 *
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any other source, and I have
 * not given my code to another student.
 *
 * Print your name here: Aser Wondemu
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Student JUnit tests for Acrobatic.
 */
public class AcrobaticJUnitTestStudent {

    private Acrobatic person;

    /** Creates a fresh Acrobatic before each test. */
    @BeforeEach
    public void setUp() {
        person = new Acrobatic("Maya Lopez", 28, 4, "Tightrope Walker");
    }

    /** The constructor passes name, age, and years worked to Person. */
    @Test
    public void testConstructorAndInheritedGetters() {
        assertEquals("Maya Lopez", person.getName());
        assertEquals(28, person.getAge());
        assertEquals(4, person.getYearsWorked());
    }

    /** getJob returns the job title. */
    @Test
    public void testGetJob() {
        assertEquals("Tightrope Walker", person.getJob());
    }

    /** Acrobatic is a Person (inheritance). */
    @Test
    public void testIsAPerson() {
        assertTrue(person instanceof Person);
    }

    /** toString prints each field on its own line. */
    @Test
    public void testToString() {
        assertEquals("Name: Maya Lopez\nAge: 28\nYears Worked: 4\nJob: Tightrope Walker", person.toString());
    }

    /** Boundary case: a brand-new employee with 0 years worked. */
    @Test
    public void testZeroYearsWorked() {
        Acrobatic newHire = new Acrobatic("Sam Lee", 18, 0, "Trainee");
        assertEquals(0, newHire.getYearsWorked());
        assertTrue(newHire.toString().contains("Years Worked: 0"));
    }
}
