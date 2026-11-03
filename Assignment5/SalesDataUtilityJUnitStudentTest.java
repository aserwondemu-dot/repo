/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for every SalesDataUtility method, using
 * known ragged arrays.
 * Due: 11/02/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Aser Wondemu
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Student JUnit tests for SalesDataUtility.
 */
public class SalesDataUtilityJUnitStudentTest {

    // Ragged array: row lengths 2, 4, and 1
    private double[][] data = {
        {12.5, 40.0},
        {5.0, 30.0, 22.5, 7.5},
        {60.0}
    };

    /** Total of all 7 values. */
    @Test
    public void testGetTotal() {
        assertEquals(177.5, SalesDataUtility.getTotal(data), 0.001);
    }

    /** Average divides by the number of values (7), not the number of rows. */
    @Test
    public void testGetAverage() {
        assertEquals(177.5 / 7, SalesDataUtility.getAverage(data), 0.001);
    }

    /** Each row total. */
    @Test
    public void testGetRowTotal() {
        assertEquals(52.5, SalesDataUtility.getRowTotal(data, 0), 0.001);
        assertEquals(65.0, SalesDataUtility.getRowTotal(data, 1), 0.001);
        assertEquals(60.0, SalesDataUtility.getRowTotal(data, 2), 0.001);
    }

    /** Column totals skip rows that are too short. */
    @Test
    public void testGetColumnTotal() {
        assertEquals(77.5, SalesDataUtility.getColumnTotal(data, 0), 0.001); // 12.5 + 5 + 60
        assertEquals(70.0, SalesDataUtility.getColumnTotal(data, 1), 0.001); // 40 + 30
        assertEquals(22.5, SalesDataUtility.getColumnTotal(data, 2), 0.001); // row 1 only
        assertEquals(7.5, SalesDataUtility.getColumnTotal(data, 3), 0.001);  // row 1 only
    }

    /** Highest and lowest within a row. */
    @Test
    public void testHighestAndLowestInRow() {
        assertEquals(40.0, SalesDataUtility.getHighestInRow(data, 0), 0.001);
        assertEquals(12.5, SalesDataUtility.getLowestInRow(data, 0), 0.001);
        assertEquals(30.0, SalesDataUtility.getHighestInRow(data, 1), 0.001);
        assertEquals(5.0, SalesDataUtility.getLowestInRow(data, 1), 0.001);
        assertEquals(60.0, SalesDataUtility.getHighestInRow(data, 2), 0.001);
        assertEquals(60.0, SalesDataUtility.getLowestInRow(data, 2), 0.001);
    }

    /** Highest and lowest in the whole array. */
    @Test
    public void testHighestAndLowestInArray() {
        assertEquals(60.0, SalesDataUtility.getHighestInArray(data), 0.001);
        assertEquals(5.0, SalesDataUtility.getLowestInArray(data), 0.001);
    }

    /** An empty array returns 0 instead of crashing. */
    @Test
    public void testEmptyArray() {
        double[][] empty = new double[0][];
        assertEquals(0.0, SalesDataUtility.getTotal(empty), 0.001);
        assertEquals(0.0, SalesDataUtility.getAverage(empty), 0.001);
        assertEquals(0.0, SalesDataUtility.getHighestInArray(empty), 0.001);
    }
}
