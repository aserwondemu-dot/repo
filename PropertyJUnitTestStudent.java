/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for the Property class constructors, copy
 * constructor, setters, and toString.
 * Due: 10/19/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Aser Wondemu
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Student JUnit tests for Property.
 */
public class PropertyJUnitTestStudent {

    private Property property;

    /**
     * Creates a fresh Property before each test.
     */
    @BeforeEach
    public void setUp() {
        property = new Property("Maple House", "Bethesda", 2250.50, "Dana Lee");
    }

    /** Default constructor sets empty values. */
    @Test
    public void testDefaultConstructor() {
        Property empty = new Property();
        assertEquals("", empty.getPropertyName());
        assertEquals("", empty.getCity());
        assertEquals(0.0, empty.getRentAmount(), 0.001);
        assertEquals("", empty.getOwner());
    }

    /** Parameterized constructor stores every field. */
    @Test
    public void testParameterizedConstructor() {
        assertEquals("Maple House", property.getPropertyName());
        assertEquals("Bethesda", property.getCity());
        assertEquals(2250.50, property.getRentAmount(), 0.001);
        assertEquals("Dana Lee", property.getOwner());
    }

    /** Copy constructor copies values into a separate object. */
    @Test
    public void testCopyConstructor() {
        Property copy = new Property(property);
        assertNotSame(property, copy);
        assertEquals(property.toString(), copy.toString());

        // Changing the copy must not change the original
        copy.setRentAmount(999.0);
        assertEquals(2250.50, property.getRentAmount(), 0.001);
    }

    /** Setters change the fields. */
    @Test
    public void testSetters() {
        property.setPropertyName("Oak Loft");
        property.setCity("Silver Spring");
        property.setRentAmount(1800.0);
        property.setOwner("Sam Park");
        assertEquals("Oak Loft, Silver Spring, Rent: $1800.00, Owner: Sam Park", property.toString());
    }

    /** toString uses the required format with two decimal places. */
    @Test
    public void testToString() {
        assertEquals("Maple House, Bethesda, Rent: $2250.50, Owner: Dana Lee", property.toString());
    }
}
