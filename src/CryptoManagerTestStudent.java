package BobsCircus;
 
/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Student JUnit tests for every public method of CryptoManager.
 * Due: 10/05/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Aser Wondemu
 */
 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
 
public class CryptoManagerTestStudent {
 
    private static final String ERROR = "The selected string is not in bounds, Try again.";
 
    // isStringInBounds
    @Test
    public void testIsStringInBoundsValid() {
        assertTrue(CryptoManager.isStringInBounds("MONTGOMERY COLLEGE 2026"));
    }
 
    @Test
    public void testIsStringInBoundsLowercase() {
        assertFalse(CryptoManager.isStringInBounds("Rockville"));
    }
 
    @Test
    public void testIsStringInBoundsCurlyBrace() {
        assertFalse(CryptoManager.isStringInBounds("ABC{"));
    }
 
    // vigenereEncryption
    @Test
    public void testVigenereEncryptionKnownValue() {
        // M(12) + D(3) = P(15)
        assertEquals("P", CryptoManager.vigenereEncryption("M", "D"));
    }
 
    @Test
    public void testVigenereEncryptionOutOfBounds() {
        assertEquals(ERROR, CryptoManager.vigenereEncryption("lowercase", "KEY"));
    }
 
    // vigenereDecryption
    @Test
    public void testVigenereDecryptionKnownValue() {
        assertEquals("M", CryptoManager.vigenereDecryption("P", "D"));
    }
 
    @Test
    public void testVigenereRoundTrip() {
        String text = "MEET AT NOON!";
        String key = "LEMON";
        assertEquals(text, CryptoManager.vigenereDecryption(
                CryptoManager.vigenereEncryption(text, key), key));
    }
 
    // playfairEncryption
    @Test
    public void testPlayfairEncryptionClarificationExample() {
        // Example from the assignment clarification document
        assertEquals("ORRGMN", CryptoManager.playfairEncryption("MEETYO", "MONTGOMERY"));
    }
 
    @Test
    public void testPlayfairEncryptionOutOfBounds() {
        assertEquals(ERROR, CryptoManager.playfairEncryption("hello", "KEY"));
    }
 
    // playfairDecryption
    @Test
    public void testPlayfairDecryptionClarificationExample() {
        assertEquals("MEETYO", CryptoManager.playfairDecryption("ORRGMN", "MONTGOMERY"));
    }
 
    @Test
    public void testPlayfairRoundTripOddLength() {
        String text = "DOG";
        String key = "ANIMAL";
        assertEquals(text, CryptoManager.playfairDecryption(
                CryptoManager.playfairEncryption(text, key), key));
    }
 
    // caesarEncryption
    @Test
    public void testCaesarEncryptionKnownValue() {
        assertEquals("E", CryptoManager.caesarEncryption("A", 4));
    }
 
    @Test
    public void testCaesarEncryptionOutOfBounds() {
        assertEquals(ERROR, CryptoManager.caesarEncryption("abc", 2));
    }
 
    @Test
    public void testCaesarEncryptionLargeKey() {
        // A shift of 64 wraps all the way around
        assertEquals("WRAP", CryptoManager.caesarEncryption("WRAP", 64));
    }
 
    // caesarDecryption
    @Test
    public void testCaesarDecryptionKnownValue() {
        assertEquals("A", CryptoManager.caesarDecryption("E", 4));
    }
 
    @Test
    public void testCaesarRoundTrip() {
        String text = "CMSC 203 RULES";
        assertEquals(text, CryptoManager.caesarDecryption(
                CryptoManager.caesarEncryption(text, 17), 17));
    }
}
 
