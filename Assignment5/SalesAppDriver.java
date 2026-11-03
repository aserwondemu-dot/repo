/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Console driver for the Store Sales Data Processor. Asks for
 * the input and output file names, reads and processes the sales data,
 * prints the results, and writes a summary file.
 * Due: 11/02/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Aser Wondemu
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Console driver for the sales data processor.
 *
 * @author Aser Wondemu
 */
public class SalesAppDriver {

    /**
     * Asks for an input file until one is read successfully, prints the
     * statistics, then asks for an output file and writes the summary.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Store Sales Data Processor");
        System.out.println("==========================");

        double[][] data = null;
        while (data == null) {
            System.out.print("Enter input file name: ");
            String inFile = keyboard.nextLine().trim();
            try {
                data = SalesFileIO.readSalesData(inFile);
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: File not found: " + inFile + ". Try again.");
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid number in " + inFile + ". Try again.");
            }
        }

        printResults(data);

        System.out.print("Enter output file name: ");
        String outFile = keyboard.nextLine().trim();
        try {
            SalesFileIO.writeSummary(outFile, data);
            System.out.println("Summary written to " + outFile);
        } catch (IOException e) {
            System.out.println("ERROR: Could not write " + outFile + ": " + e.getMessage());
        }

        System.out.println("Program written by: Aser Wondemu");
        keyboard.close();
    }

    /**
     * Prints the overall statistics, then each row's total, highest, and
     * lowest value, then each column's total.
     *
     * @param data the ragged 2D array of sales
     */
    public static void printResults(double[][] data) {
        System.out.println();
        System.out.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
        System.out.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
        System.out.printf("Highest sale: %.2f%n", SalesDataUtility.getHighestInArray(data));
        System.out.printf("Lowest sale: %.2f%n", SalesDataUtility.getLowestInArray(data));
        System.out.println();
        for (int row = 0; row < data.length; row++) {
            System.out.printf("Row %d total: %.2f (highest %.2f, lowest %.2f)%n", row,
                    SalesDataUtility.getRowTotal(data, row),
                    SalesDataUtility.getHighestInRow(data, row),
                    SalesDataUtility.getLowestInRow(data, row));
        }
        int columns = SalesDataUtility.getMaxColumns(data);
        for (int col = 0; col < columns; col++) {
            System.out.printf("Column %d total: %.2f%n", col, SalesDataUtility.getColumnTotal(data, col));
        }
        System.out.println();
    }
}
