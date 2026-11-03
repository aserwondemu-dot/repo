/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Static utility methods for a ragged 2D array of sales
 * data: totals, averages, row and column totals, and highest/lowest values.
 * Due: 11/02/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Aser Wondemu
 */

/**
 * Static utility methods for ragged 2D arrays of sales data.
 * Each row is a department, and each column is a day.
 *
 * @author Aser Wondemu
 */
public class SalesDataUtility {

    /**
     * Adds up every value in the array.
     *
     * @param data ragged 2D array of sales
     * @return the total of all values
     */
    public static double getTotal(double[][] data) {
        double total = 0.0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                total += data[row][col];
            }
        }
        return total;
    }

    /**
     * Finds the average of every value in the array.
     *
     * @param data ragged 2D array of sales
     * @return the average, or 0 if the array has no values
     */
    public static double getAverage(double[][] data) {
        int count = 0;
        for (int row = 0; row < data.length; row++) {
            count += data[row].length;
        }
        if (count == 0) {
            return 0.0;
        }
        return getTotal(data) / count;
    }

    /**
     * Adds up the values in one row.
     *
     * @param data ragged 2D array of sales
     * @param row the row index
     * @return the row total
     */
    public static double getRowTotal(double[][] data, int row) {
        double total = 0.0;
        for (int col = 0; col < data[row].length; col++) {
            total += data[row][col];
        }
        return total;
    }

    /**
     * Adds up the values in one column. Rows that are too short to
     * have that column are skipped.
     *
     * @param data ragged 2D array of sales
     * @param col the column index
     * @return the column total
     */
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0.0;
        for (int row = 0; row < data.length; row++) {
            if (col < data[row].length) {
                total += data[row][col];
            }
        }
        return total;
    }

    /**
     * Finds the highest value in one row.
     *
     * @param data ragged 2D array of sales
     * @param row the row index
     * @return the highest value in the row, or 0 if the row is empty
     */
    public static double getHighestInRow(double[][] data, int row) {
        if (data[row].length == 0) {
            return 0.0;
        }
        double highest = data[row][0];
        for (int col = 1; col < data[row].length; col++) {
            if (data[row][col] > highest) {
                highest = data[row][col];
            }
        }
        return highest;
    }

    /**
     * Finds the lowest value in one row.
     *
     * @param data ragged 2D array of sales
     * @param row the row index
     * @return the lowest value in the row, or 0 if the row is empty
     */
    public static double getLowestInRow(double[][] data, int row) {
        if (data[row].length == 0) {
            return 0.0;
        }
        double lowest = data[row][0];
        for (int col = 1; col < data[row].length; col++) {
            if (data[row][col] < lowest) {
                lowest = data[row][col];
            }
        }
        return lowest;
    }

    /**
     * Finds the highest value in the whole array.
     *
     * @param data ragged 2D array of sales
     * @return the highest value, or 0 if the array has no values
     */
    public static double getHighestInArray(double[][] data) {
        boolean found = false;
        double highest = 0.0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (!found || data[row][col] > highest) {
                    highest = data[row][col];
                    found = true;
                }
            }
        }
        return highest;
    }

    /**
     * Finds the lowest value in the whole array.
     *
     * @param data ragged 2D array of sales
     * @return the lowest value, or 0 if the array has no values
     */
    public static double getLowestInArray(double[][] data) {
        boolean found = false;
        double lowest = 0.0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (!found || data[row][col] < lowest) {
                    lowest = data[row][col];
                    found = true;
                }
            }
        }
        return lowest;
    }

    /**
     * Finds the length of the longest row, which is the number of
     * columns the column totals need to cover.
     *
     * @param data ragged 2D array of sales
     * @return the length of the longest row
     */
    public static int getMaxColumns(double[][] data) {
        int max = 0;
        for (int row = 0; row < data.length; row++) {
            if (data[row].length > max) {
                max = data[row].length;
            }
        }
        return max;
    }
}
