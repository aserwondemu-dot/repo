/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: Custom exception thrown when the user types something that is not a number where a number is expected.
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

/**
 * Thrown when the user enters input that does not match the expected type.
 */
public class CustomInputMismatchException extends InputMismatchException {

    /**
     * Creates the exception with a message.
     *
     * @param message the error message to show the user
     */
    public CustomInputMismatchException(String message) {
        super(message);
    }
}
