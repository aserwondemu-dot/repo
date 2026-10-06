package BobsCircus;
 
/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Utility class that encrypts and decrypts a phrase using the
 * Vigenere, Playfair, and Caesar ciphers over a 64-character alphabet
 * (ASCII space through underscore).
 * Due: 10/05/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Aser Wondemu
 */
 
/**
 * This is a utility class that encrypts and decrypts a phrase using three
 * different approaches: Vigenere Cipher, Playfair Cipher, and Caesar Cipher.
 *
 * @author Aser Wondemu
 */
public class CryptoManager {
 
    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
    // Use 64-character matrix (8X8) for Playfair cipher
    private static final String ALPHABET64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !\"#$%&'()*+,-./:;<=>?@[\\]^_";
    private static final int MATRIX_SIZE = 8;
    private static final String OUT_OF_BOUNDS = "The selected string is not in bounds, Try again.";
 
    /**
     * Determines if every character of a string is within LOWER_RANGE and UPPER_RANGE.
     *
     * @param plainText the string to check
     * @return true if all characters are in bounds, false otherwise
     */
    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            if (!(plainText.charAt(i) >= LOWER_RANGE && plainText.charAt(i) <= UPPER_RANGE)) {
                return false;
            }
        }
        return true;
    }
 
    /**
     * Encrypts a string using the Vigenere Cipher. Each character is shifted by
     * the position of the matching key character (key repeats as needed).
     *
     * @param plainText uppercase string to encrypt
     * @param key keyword used to encrypt
     * @return the encrypted string, or an error message if out of bounds
     */
    public static String vigenereEncryption(String plainText, String key) {
        if (!isStringInBounds(plainText) || !isStringInBounds(key) || key.length() == 0) {
            return OUT_OF_BOUNDS;
        }
 
        String result = "";
        for (int i = 0; i < plainText.length(); i++) {
            int plainIndex = ALPHABET64.indexOf(plainText.charAt(i));
            int keyIndex = ALPHABET64.indexOf(key.charAt(i % key.length()));
            result += ALPHABET64.charAt((plainIndex + keyIndex) % RANGE);
        }
        return result;
    }
 
    /**
     * Decrypts a string that was encrypted with the Vigenere Cipher.
     *
     * @param encryptedText the encrypted string
     * @param key keyword used to encrypt the original text
     * @return the original plain text, or an error message if out of bounds
     */
    public static String vigenereDecryption(String encryptedText, String key) {
        if (!isStringInBounds(encryptedText) || !isStringInBounds(key) || key.length() == 0) {
            return OUT_OF_BOUNDS;
        }
 
        String result = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            int encryptedIndex = ALPHABET64.indexOf(encryptedText.charAt(i));
            int keyIndex = ALPHABET64.indexOf(key.charAt(i % key.length()));
            result += ALPHABET64.charAt((encryptedIndex - keyIndex + RANGE) % RANGE);
        }
        return result;
    }
 
    /**
     * Encrypts a string using the Playfair Cipher with an 8x8 matrix built from the key.
     * Text is split into pairs; an odd length is padded with 'X'.
     *
     * @param plainText uppercase string to encrypt
     * @param key keyword used to build the matrix
     * @return the encrypted string, or an error message if out of bounds
     */
    public static String playfairEncryption(String plainText, String key) {
        if (!isStringInBounds(plainText) || !isStringInBounds(key)) {
            return OUT_OF_BOUNDS;
        }
 
        char[][] matrix = buildMatrix(key);
        String text = plainText;
        if (text.length() % 2 != 0) {
            text += "X";
        }
 
        String result = "";
        for (int i = 0; i < text.length(); i += 2) {
            int[] first = findPosition(matrix, text.charAt(i));
            int[] second = findPosition(matrix, text.charAt(i + 1));
 
            if (first[0] == second[0]) {
                // Same row: move each one to the right (wrap around)
                result += matrix[first[0]][(first[1] + 1) % MATRIX_SIZE];
                result += matrix[second[0]][(second[1] + 1) % MATRIX_SIZE];
            } else if (first[1] == second[1]) {
                // Same column: move each one down (wrap around)
                result += matrix[(first[0] + 1) % MATRIX_SIZE][first[1]];
                result += matrix[(second[0] + 1) % MATRIX_SIZE][second[1]];
            } else {
                // Rectangle: keep the row, take the other letter's column
                result += matrix[first[0]][second[1]];
                result += matrix[second[0]][first[1]];
            }
        }
        return result;
    }
 
    /**
     * Decrypts a string that was encrypted with the Playfair Cipher.
     * A trailing padding 'X' is removed.
     *
     * @param encryptedText the encrypted string
     * @param key keyword used to build the matrix
     * @return the original plain text, or an error message if out of bounds
     */
    public static String playfairDecryption(String encryptedText, String key) {
        if (!isStringInBounds(encryptedText) || !isStringInBounds(key)) {
            return OUT_OF_BOUNDS;
        }
 
        char[][] matrix = buildMatrix(key);
        String result = "";
        int i = 0;
        while (i + 1 < encryptedText.length()) {
            int[] first = findPosition(matrix, encryptedText.charAt(i));
            int[] second = findPosition(matrix, encryptedText.charAt(i + 1));
 
            if (first[0] == second[0]) {
                // Same row: move each one to the left (wrap around)
                result += matrix[first[0]][(first[1] - 1 + MATRIX_SIZE) % MATRIX_SIZE];
                result += matrix[second[0]][(second[1] - 1 + MATRIX_SIZE) % MATRIX_SIZE];
            } else if (first[1] == second[1]) {
                // Same column: move each one up (wrap around)
                result += matrix[(first[0] - 1 + MATRIX_SIZE) % MATRIX_SIZE][first[1]];
                result += matrix[(second[0] - 1 + MATRIX_SIZE) % MATRIX_SIZE][second[1]];
            } else {
                // Rectangle: same swap as encryption
                result += matrix[first[0]][second[1]];
                result += matrix[second[0]][first[1]];
            }
            i += 2;
        }
 
        // Keep a leftover single character as-is
        if (i < encryptedText.length()) {
            result += encryptedText.charAt(i);
        }
 
        // Remove the 'X' that was added to pad an odd-length message
        if (result.length() > 0 && result.charAt(result.length() - 1) == 'X') {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
 
    /**
     * Encrypts a string using the Caesar Cipher by shifting each character
     * key positions forward, wrapping within LOWER_RANGE to UPPER_RANGE.
     *
     * @param plainText uppercase string to encrypt
     * @param key number of positions to shift
     * @return the encrypted string, or an error message if out of bounds
     */
    public static String caesarEncryption(String plainText, int key) {
        if (!isStringInBounds(plainText)) {
            return OUT_OF_BOUNDS;
        }
 
        int shift = ((key % RANGE) + RANGE) % RANGE;
        String result = "";
        for (int i = 0; i < plainText.length(); i++) {
            int offset = plainText.charAt(i) - LOWER_RANGE;
            result += (char) (LOWER_RANGE + (offset + shift) % RANGE);
        }
        return result;
    }
 
    /**
     * Decrypts a string that was encrypted with the Caesar Cipher.
     *
     * @param encryptedText the encrypted string
     * @param key number of positions used to encrypt the original text
     * @return the original plain text, or an error message if out of bounds
     */
    public static String caesarDecryption(String encryptedText, int key) {
        if (!isStringInBounds(encryptedText)) {
            return OUT_OF_BOUNDS;
        }
 
        int shift = ((key % RANGE) + RANGE) % RANGE;
        String result = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            int offset = encryptedText.charAt(i) - LOWER_RANGE;
            result += (char) (LOWER_RANGE + (offset - shift + RANGE) % RANGE);
        }
        return result;
    }
 
    // Builds the 8x8 Playfair matrix: key characters first (no repeats),
    // then the rest of the 64-character alphabet in order.
    private static char[][] buildMatrix(String key) {
        String order = "";
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (order.indexOf(c) == -1) {
                order += c;
            }
        }
        for (int i = 0; i < ALPHABET64.length(); i++) {
            char c = ALPHABET64.charAt(i);
            if (order.indexOf(c) == -1) {
                order += c;
            }
        }
 
        char[][] matrix = new char[MATRIX_SIZE][MATRIX_SIZE];
        for (int i = 0; i < order.length(); i++) {
            matrix[i / MATRIX_SIZE][i % MATRIX_SIZE] = order.charAt(i);
        }
        return matrix;
    }
 
    // Returns {row, column} of a character in the matrix.
    private static int[] findPosition(char[][] matrix, char c) {
        for (int row = 0; row < MATRIX_SIZE; row++) {
            for (int col = 0; col < MATRIX_SIZE; col++) {
                if (matrix[row][col] == c) {
                    return new int[] {row, col};
                }
            }
        }
        return new int[] {0, 0};
    }
}
 
