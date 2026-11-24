/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for the Horse class.
 * Due: 11/23/2026
 * Platform/Compiler: Eclipse
 *
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any other source, and I have
 * not given my code to another student.
 *
 * Print your name here: Aser Wondemu
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Student JUnit tests for Horse.
 */
public class HorseJUnitTestStudent {

    private Horse animal;

    /** Creates a fresh Horse before each test. */
    @BeforeEach
    public void setUp() {
        animal = new Horse("Thunder", 7, "Arabian", "Black");
    }

    /** The constructor and getters store every field. */
    @Test
    public void testConstructorAndGetters() {
        assertEquals("Thunder", animal.getName());
        assertEquals(7, animal.getAge());
        assertEquals("Arabian", animal.getSpecies());
        assertEquals("Black", animal.getColor());
    }

    /** Horse is an Animal (interface). */
    @Test
    public void testIsAnAnimal() {
        assertTrue(animal instanceof Animal);
    }

    /** Equal when every field matches; not equal when one field differs. */
    @Test
    public void testEquals() {
        assertEquals(animal, new Horse("Thunder", 7, "Arabian", "Black"));
        assertEquals(animal.hashCode(), new Horse("Thunder", 7, "Arabian", "Black").hashCode());
        assertNotEquals(animal, new Horse("Storm", 7, "Arabian", "Black"));
        assertNotEquals(animal, new Horse("Thunder", 8, "Arabian", "Black"));
        assertNotEquals(animal, new Horse("Thunder", 7, "Arabian", "Purple"));
        assertNotEquals(animal, null);
        assertNotEquals(animal, "Thunder");
    }

    /** toString includes every field. */
    @Test
    public void testToString() {
        assertEquals("Horse [Name: Thunder, Age: 7, Species: Arabian, Color: Black]", animal.toString());
    }

    /** move and makeSound print a line with the animal's name. */
    @Test
    public void testMoveAndMakeSound() {
        PrintStream original = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        animal.move();
        animal.makeSound();
        System.setOut(original);
        String printed = out.toString();
        assertTrue(printed.contains("Thunder"));
        assertEquals(2, printed.trim().split("\\R").length);
    }
}
