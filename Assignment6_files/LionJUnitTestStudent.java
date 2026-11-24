/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for the Lion class.
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
 * Student JUnit tests for Lion.
 */
public class LionJUnitTestStudent {

    private Lion animal;

    /** Creates a fresh Lion before each test. */
    @BeforeEach
    public void setUp() {
        animal = new Lion("Nala", 4, "Panthera leo", "Tan");
    }

    /** The constructor and getters store every field. */
    @Test
    public void testConstructorAndGetters() {
        assertEquals("Nala", animal.getName());
        assertEquals(4, animal.getAge());
        assertEquals("Panthera leo", animal.getSpecies());
        assertEquals("Tan", animal.getColor());
    }

    /** Lion is an Animal (interface). */
    @Test
    public void testIsAnAnimal() {
        assertTrue(animal instanceof Animal);
    }

    /** Equal when every field matches; not equal when one field differs. */
    @Test
    public void testEquals() {
        assertEquals(animal, new Lion("Nala", 4, "Panthera leo", "Tan"));
        assertEquals(animal.hashCode(), new Lion("Nala", 4, "Panthera leo", "Tan").hashCode());
        assertNotEquals(animal, new Lion("Leo", 4, "Panthera leo", "Tan"));
        assertNotEquals(animal, new Lion("Nala", 5, "Panthera leo", "Tan"));
        assertNotEquals(animal, new Lion("Nala", 4, "Panthera leo", "Purple"));
        assertNotEquals(animal, null);
        assertNotEquals(animal, "Nala");
    }

    /** toString includes every field. */
    @Test
    public void testToString() {
        assertEquals("Lion [Name: Nala, Age: 4, Species: Panthera leo, Color: Tan]", animal.toString());
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
        assertTrue(printed.contains("Nala"));
        assertEquals(2, printed.trim().split("\\R").length);
    }
}
