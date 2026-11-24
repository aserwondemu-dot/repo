/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for the TicketingOffice class.
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
 * Student JUnit tests for TicketingOffice.
 */
public class TicketingOfficeJUnitTestStudent {

    private TicketingOffice building;

    /** Creates a fresh TicketingOffice before each test. */
    @BeforeEach
    public void setUp() {
        building = new TicketingOffice("Yellow", 15.0, 8.0);
    }

    /** The constructor sets color, size, and the default building type. */
    @Test
    public void testConstructor() {
        assertEquals("Yellow", building.getColor());
        assertEquals(15.0, building.getLength(), 0.001);
        assertEquals(8.0, building.getWidth(), 0.001);
        assertEquals("Ticketing Office", building.getBuildingType());
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
        assertEquals(String.format("Ticketing Office [Color: Yellow, Length: %.2f, Width: %.2f]", 15.0, 8.0),
                building.toString());
    }
}
