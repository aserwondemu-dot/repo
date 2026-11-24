/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for the Bird class.
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
 * Student JUnit tests for Bird.
 */
public class BirdJUnitTestStudent {

    private Bird animal;

    /** Creates a fresh Bird before each test. */
    @BeforeEach
    public void setUp() {
        animal = new Bird("Kiwi", 1, "Parrot", "Green");
    }

    /** The constructor and getters store every field. */
    @Test
    public void testConstructorAndGetters() {
        assertEquals("Kiwi", animal.getName());
        assertEquals(1, animal.getAge());
        assertEquals("Parrot", animal.getSpecies());
        assertEquals("Green", animal.getColor());
    }

    /** Bird is an Animal (interface). */
    @Test
    public void testIsAnAnimal() {
        assertTrue(animal instanceof Animal);
    }

    /** Equal when every field matches; not equal when one field differs. */
    @Test
    public void testEquals() {
        assertEquals(animal, new Bird("Kiwi", 1, "Parrot", "Green"));
        assertEquals(animal.hashCode(), new Bird("Kiwi", 1, "Parrot", "Green").hashCode());
        assertNotEquals(animal, new Bird("Sunny", 1, "Parrot", "Green"));
        assertNotEquals(animal, new Bird("Kiwi", 2, "Parrot", "Green"));
        assertNotEquals(animal, new Bird("Kiwi", 1, "Parrot", "Purple"));
        assertNotEquals(animal, null);
        assertNotEquals(animal, "Kiwi");
    }

    /** toString includes every field. */
    @Test
    public void testToString() {
        assertEquals("Bird [Name: Kiwi, Age: 1, Species: Parrot, Color: Green]", animal.toString());
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
        assertTrue(printed.contains("Kiwi"));
        assertEquals(2, printed.trim().split("\\R").length);
    }
}
