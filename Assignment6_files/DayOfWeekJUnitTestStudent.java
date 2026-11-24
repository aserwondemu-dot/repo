/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for the DayOfWeek enumeration.
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
import org.junit.jupiter.api.Test;

/**
 * Student JUnit tests for DayOfWeek.
 */
public class DayOfWeekJUnitTestStudent {

    /** There are seven days, Monday first and Sunday last. */
    @Test
    public void testValues() {
        assertEquals(7, DayOfWeek.values().length);
        assertEquals(DayOfWeek.MONDAY, DayOfWeek.values()[0]);
        assertEquals(DayOfWeek.SUNDAY, DayOfWeek.values()[6]);
    }

    /** Monday through Friday have a 10% discount. */
    @Test
    public void testWeekdayDiscount() {
        assertEquals(0.10, DayOfWeek.MONDAY.getDiscount(), 0.0001);
        assertEquals(0.10, DayOfWeek.TUESDAY.getDiscount(), 0.0001);
        assertEquals(0.10, DayOfWeek.WEDNESDAY.getDiscount(), 0.0001);
        assertEquals(0.10, DayOfWeek.THURSDAY.getDiscount(), 0.0001);
        assertEquals(0.10, DayOfWeek.FRIDAY.getDiscount(), 0.0001);
    }

    /** Saturday and Sunday have no discount. */
    @Test
    public void testWeekendDiscount() {
        assertEquals(0.0, DayOfWeek.SATURDAY.getDiscount(), 0.0001);
        assertEquals(0.0, DayOfWeek.SUNDAY.getDiscount(), 0.0001);
    }

    /** valueOf finds a day by its name. */
    @Test
    public void testValueOf() {
        assertEquals(DayOfWeek.FRIDAY, DayOfWeek.valueOf("FRIDAY"));
    }
}
