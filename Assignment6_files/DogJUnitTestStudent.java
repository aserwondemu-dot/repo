/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for the Dog class.
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
 * Student JUnit tests for Dog.
 */
public class DogJUnitTestStudent {

    private Dog animal;

    /** Creates a fresh Dog before each test. */
    @BeforeEach
    public void setUp() {
        animal = new Dog("Rex", 3, "Beagle", "White");
    }

    /** The constructor and getters store every field. */
    @Test
    public void testConstructorAndGetters() {
        assertEquals("Rex", animal.getName());
        assertEquals(3, animal.getAge());
        assertEquals("Beagle", animal.getSpecies());
        assertEquals("White", animal.getColor());
    }

    /** Dog is an Animal (interface). */
    @Test
    public void testIsAnAnimal() {
        assertTrue(animal instanceof Animal);
    }

    /** Equal when every field matches; not equal when one field differs. */
    @Test
    public void testEquals() {
        assertEquals(animal, new Dog("Rex", 3, "Beagle", "White"));
        assertEquals(animal.hashCode(), new Dog("Rex", 3, "Beagle", "White").hashCode());
        assertNotEquals(animal, new Dog("Max", 3, "Beagle", "White"));
        assertNotEquals(animal, new Dog("Rex", 4, "Beagle", "White"));
        assertNotEquals(animal, new Dog("Rex", 3, "Beagle", "Purple"));
        assertNotEquals(animal, null);
        assertNotEquals(animal, "Rex");
    }

    /** toString includes every field. */
    @Test
    public void testToString() {
        assertEquals("Dog [Name: Rex, Age: 3, Species: Beagle, Color: White]", animal.toString());
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
        assertTrue(printed.contains("Rex"));
        assertEquals(2, printed.trim().split("\\R").length);
    }

    /** clone makes a separate object with the same fields. */
    @Test
    public void testClone() {
        Dog copy = animal.clone();
        assertNotSame(animal, copy);
        assertEquals(animal, copy);
    }
}
