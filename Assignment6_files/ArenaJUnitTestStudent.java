/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for the Arena class.
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
 * Student JUnit tests for Arena.
 */
public class ArenaJUnitTestStudent {

    private Arena building;

    /** Creates a fresh Arena before each test. */
    @BeforeEach
    public void setUp() {
        building = new Arena("Green", 120.5, 60.25);
    }

    /** The constructor sets color, size, and the default building type. */
    @Test
    public void testConstructor() {
        assertEquals("Green", building.getColor());
        assertEquals(120.5, building.getLength(), 0.001);
        assertEquals(60.25, building.getWidth(), 0.001);
        assertEquals("Arena", building.getBuildingType());
        assertTrue(building instanceof Building);
    }

    /** setSize changes both length and width. */
    @Test
    public void testSetSize() {
        building.setSize(200.0, 75.5);
        assertEquals(200.0, building.getLength(), 0.001);
        assertEquals(75.5, building.getWidth(), 0.001);
    }

    /** Boundary case: a size of zero. */
    @Test
    public void testSetSizeZero() {
        building.setSize(0, 0);
        assertEquals(0.0, building.getLength(), 0.001);
        assertEquals(0.0, building.getWidth(), 0.001);
    }

    /** setColor changes the color. */
    @Test
    public void testSetColor() {
        building.setColor("Silver");
        assertEquals("Silver", building.getColor());
    }

    /** setBuildingType changes the type. */
    @Test
    public void testSetBuildingType() {
        building.setBuildingType("Storage");
        assertEquals("Storage", building.getBuildingType());
    }

    /** toString shows type, color, and size with two decimals. */
    @Test
    public void testToString() {
        assertEquals(String.format("Arena [Color: Green, Length: %.2f, Width: %.2f]", 120.5, 60.25),
                building.toString());
    }
}
