/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for the CustomInputMismatchException class.
 * Due: 11/23/2026
 * Platform/Compiler: Eclipse
 *
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any other source, and I have
 * not given my code to another student.
 *
 * Print your name here: Aser Wondemu
 */

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Student JUnit tests for CustomInputMismatchException.
 */
public class CustomInputMismatchExceptionJUnitTestStudent {

    /** The message passed in is the message returned. */
    @Test
    public void testMessage() {
        CustomInputMismatchException e = new CustomInputMismatchException("Please enter a number.");
        assertEquals("Please enter a number.", e.getMessage());
    }

    /** It is an InputMismatchException, so it can be caught as one. */
    @Test
    public void testIsInputMismatchException() {
        assertTrue(new CustomInputMismatchException("x") instanceof InputMismatchException);
    }

    /** It can be thrown and caught. */
    @Test
    public void testThrowAndCatch() {
        boolean caught = false;
        try {
            throw new CustomInputMismatchException("bad input");
        } catch (CustomInputMismatchException e) {
            caught = true;
            assertEquals("bad input", e.getMessage());
        }
        assertTrue(caught);
    }
}
