/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Reads ragged sales data from a text file into a 2D array
 * and writes a summary of the data to an output file.
 * Due: 11/02/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Aser Wondemu
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * File input and output for the sales data.
 *
 * @author Aser Wondemu
 */
public class SalesFileIO {

    /**
     * Reads the sales file. Each non-blank line becomes one row; the values
     * on the line are split on spaces and converted to doubles, so rows can
     * have different lengths.
     *
     * @param filename the input file name
     * @return the ragged 2D array of sales
     * @throws FileNotFoundException if the file does not exist
     * @throws NumberFormatException if a value is not a number
     */
    public static double[][] readSalesData(String filename) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        ArrayList<String> lines = new ArrayList<>();
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (!line.isEmpty()) {
                lines.add(line);
            }
        }
        input.close();

        double[][] data = new double[lines.size()][];
        for (int row = 0; row < lines.size(); row++) {
            String[] tokens = lines.get(row).split("\\s+");
            data[row] = new double[tokens.length];
            for (int col = 0; col < tokens.length; col++) {
                data[row][col] = Double.parseDouble(tokens[col]);
            }
        }
        return data;
    }

    /**
     * Writes the summary: total, average, highest and lowest sale, then
     * each row total and each column total.
     *
     * @param filename the output file name
     * @param data the ragged 2D array of sales
     * @throws IOException if the file cannot be written
     */
    public static void writeSummary(String filename, double[][] data) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(filename));
        out.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
        out.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
        out.printf("Highest sale: %.2f%n", SalesDataUtility.getHighestInArray(data));
        out.printf("Lowest sale: %.2f%n", SalesDataUtility.getLowestInArray(data));
        for (int row = 0; row < data.length; row++) {
            out.printf("Row %d total: %.2f%n", row, SalesDataUtility.getRowTotal(data, row));
        }
        int columns = SalesDataUtility.getMaxColumns(data);
        for (int col = 0; col < columns; col++) {
            out.printf("Column %d total: %.2f%n", col, SalesDataUtility.getColumnTotal(data, col));
        }
        out.println("Program written by: Aser Wondemu");
        out.close();
    }
}
