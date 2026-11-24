/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for CircusDriverApp: the ticket price calculation and a full run of the menu.
 * Due: 11/23/2026
 * Platform/Compiler: Eclipse
 *
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any other source, and I have
 * not given my code to another student.
 *
 * Print your name here: Aser Wondemu
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Student JUnit tests for CircusDriverApp.
 */
public class CircusDriverAppJUnitTestStudent {

    private PrintStream originalOut;
    private InputStream originalIn;
    private ByteArrayOutputStream out;

    /** Saves System.in and System.out and captures printed output. */
    @BeforeEach
    public void setUp() {
        originalOut = System.out;
        originalIn = System.in;
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    /** Restores System.in and System.out. */
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // Runs main with the given typed input and returns everything it printed
    private String run(String typed) {
        System.setIn(new ByteArrayInputStream(typed.getBytes()));
        CircusDriverApp.main(new String[0]);
        return out.toString();
    }

    /** Weekday, adult, lower level: only the 10% day discount. */
    @Test
    public void testPriceWeekdayAdultLower() {
        assertEquals(18.0, CircusDriverApp.calculateTicketPrice(20.0, DayOfWeek.MONDAY, 0.0, 1), 0.001);
    }

    /** Weekend, child, T-level: double price with 10% child discount. */
    @Test
    public void testPriceWeekendChildTLevel() {
        assertEquals(36.0, CircusDriverApp.calculateTicketPrice(20.0, DayOfWeek.SATURDAY, 0.10, 2), 0.001);
    }

    /** Weekday, senior, upper level: all three discounts stack. */
    @Test
    public void testPriceAllDiscounts() {
        double expected = 100.0 * 0.90 * 0.95 * 0.95;
        assertEquals(expected, CircusDriverApp.calculateTicketPrice(100.0, DayOfWeek.FRIDAY, 0.05, 3), 0.001);
    }

    /** Boundary case: a free ticket stays free. */
    @Test
    public void testPriceZeroBase() {
        assertEquals(0.0, CircusDriverApp.calculateTicketPrice(0.0, DayOfWeek.SUNDAY, 0.0, 2), 0.001);
    }

    /** Generating two ticket groups prints each group and the final total. */
    @Test
    public void testGenerateTicketThroughMenu() {
        String printed = run("4\n20\n1\n1\n2\n2\ny\n6\n3\n3\n1\nn\n11\n");
        assertTrue(printed.contains("Regular ticket price: $20.00"));
        assertTrue(printed.contains("2 child ticket(s), T-level, MONDAY: $64.80"));
        assertTrue(printed.contains("1 adult ticket(s), Upper level, SATURDAY: $19.00"));
        assertTrue(printed.contains("Final Total Amount: $83.80"));
    }

    /** Invalid menu input is rejected and the program keeps running. */
    @Test
    public void testInvalidMenuInput() {
        String printed = run("abc\n99\n11\n");
        assertTrue(printed.contains("Invalid input. Please enter a number."));
        assertTrue(printed.contains("Invalid option. Please choose again."));
        assertTrue(printed.contains("Program written by: Aser Wondemu"));
    }

    /** Adding an animal through the menu, then searching for it, finds it. */
    @Test
    public void testAddAndSearchAnimal() {
        String printed = run("1\n2\nSpirit\n4\nMustang\nBrown\n10\nspirit\n11\n");
        assertTrue(printed.contains("Animal added: Horse [Name: Spirit"));
        assertTrue(printed.contains("Animal found: Horse [Name: Spirit"));
    }

    /** An invalid day choice is rejected inside ticketing. */
    @Test
    public void testInvalidDayChoice() {
        String printed = run("4\n10\n9\n7\n3\n1\n1\nn\n11\n");
        assertTrue(printed.contains("Invalid choice. Please select a valid day."));
        assertTrue(printed.contains("Final Total Amount: $10.00"));
    }
}
