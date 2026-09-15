import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Class: CMSC203
 * Instructor: 
 * Description: Grade Calculator program. Reads a course configuration file
 * and a student scores file, validates the data, calculates the overall
 * average and letter grade, and writes a summary report to the console
 * and to a file.
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 */
public class GradeCalculator {

    public static void main(String[] args) {

        String programmerName = "Aser Wondemu";

        System.out.println("========================================");
        System.out.println("CMSC203 Project 1 - Grade Calculator");
        System.out.println("========================================");

        String configFileName = "gradeconfig.txt";
        String inputFileName = "grades_input.txt";
        String outputFileName = "grades_report.txt";

        String courseName = "";
        int numCategories = 0;
        boolean usedDefault = false;

        System.out.println("Loading configuration from " + configFileName + " ...");

        File configFile = new File(configFileName);
        boolean configOk = true;

        if (!configFile.exists()) {
            configOk = false;
        } else {
            try {
                Scanner checkConfig = new Scanner(configFile);
                courseName = checkConfig.nextLine().trim();
                numCategories = Integer.parseInt(checkConfig.nextLine().trim());

                int weightTotal = 0;
                for (int i = 1; i <= numCategories; i++) {
                    if (!checkConfig.hasNext()) {
                        configOk = false;
                        break;
                    }
                    checkConfig.next();
                    if (!checkConfig.hasNextInt()) {
                        configOk = false;
                        break;
                    }
                    weightTotal += checkConfig.nextInt();
                }
                if (weightTotal != 100) {
                    configOk = false;
                }
                checkConfig.close();
            } catch (Exception e) {
                configOk = false;
            }
        }

        if (!configOk) {
            courseName = "Default Course";
            numCategories = 3;
            usedDefault = true;
            System.out.println("Configuration file missing or invalid.");
            System.out.println("Using default configuration: Projects 40, Quizzes 30, Exams 30.");
        } else {
            System.out.println("Configuration loaded successfully.");
        }

        Scanner configScanner = null;
        if (!usedDefault) {
            try {
                configScanner = new Scanner(configFile);
                configScanner.nextLine();
                configScanner.nextLine();
            } catch (FileNotFoundException e) {
                usedDefault = true;
                courseName = "Default Course";
                numCategories = 3;
            }
        }

        System.out.println("Using input file: " + inputFileName);
        System.out.println("Using output file: " + outputFileName);

        Scanner inputScanner;
        try {
            inputScanner = new Scanner(new File(inputFileName));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Cannot find or read " + inputFileName + ". Exiting program.");
            return;
        }

        System.out.println("Reading student scores...");

        if (!inputScanner.hasNext()) {
            System.out.println("ERROR: Input file is empty. Exiting program.");
            inputScanner.close();
            return;
        }
        String firstName = inputScanner.next();
        String lastName = inputScanner.next();

        System.out.println();
        System.out.println("Student: " + firstName + " " + lastName);
        System.out.println("Course: " + courseName);
        System.out.println();
        System.out.println("Category Results:");

        double overallAverage = 0.0;

        for (int i = 1; i <= numCategories; i++) {

            String expectedName;
            int expectedWeight;

            if (usedDefault) {
                if (i == 1) {
                    expectedName = "Projects";
                    expectedWeight = 40;
                } else if (i == 2) {
                    expectedName = "Quizzes";
                    expectedWeight = 30;
                } else {
                    expectedName = "Exams";
                    expectedWeight = 30;
                }
            } else if (configScanner.hasNext()) {
                expectedName = configScanner.next();
                expectedWeight = configScanner.hasNextInt() ? configScanner.nextInt() : 0;
            } else {
                expectedName = "Unknown";
                expectedWeight = 0;
            }

            if (!inputScanner.hasNext()) {
                System.out.println("ERROR: Ran out of data while reading categories.");
                break;
            }
            String actualName = inputScanner.next();

            int scoreCount = inputScanner.hasNextInt() ? inputScanner.nextInt() : 0;

            double sum = 0.0;
            int count = 0;
            for (int j = 1; j <= scoreCount; j++) {
                if (inputScanner.hasNextDouble()) {
                    sum += inputScanner.nextDouble();
                    count++;
                } else if (inputScanner.hasNext()) {
                    System.out.println("WARNING: Invalid score in " + actualName + ", skipping value.");
                    inputScanner.next();
                }
            }

            if (!actualName.equalsIgnoreCase(expectedName)) {
                System.out.println("ERROR: Category \"" + actualName + "\" does not match configuration. Skipping.");
                continue;
            }

            double average = (count > 0) ? (sum / count) : 0.0;
            overallAverage += average * expectedWeight / 100.0;

            System.out.printf("%s (%d%%): average = %.2f%n", actualName, expectedWeight, average);
        }

        inputScanner.close();
        if (configScanner != null) {
            configScanner.close();
        }

        int gradeBand = (int) (overallAverage / 10);
        String letterGrade;

        switch (gradeBand) {
            case 10:
            case 9:
                letterGrade = "A";
                break;
            case 8:
                letterGrade = "B";
                break;
            case 7:
                letterGrade = "C";
                break;
            case 6:
                letterGrade = "D";
                break;
            default:
                letterGrade = "F";
                break;
        }

        Scanner keyboard = new Scanner(System.in);
        String answer = "";
        boolean validAnswer = false;

        while (!validAnswer) {
            System.out.print("Apply +/- grading? (Y/N): ");
            answer = keyboard.next();
            if (answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")) {
                validAnswer = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }

        String finalGrade = letterGrade;

        if (answer.equalsIgnoreCase("Y") && !letterGrade.equals("F")) {
            double position = overallAverage - (gradeBand * 10);
            if (position >= 8.0) {
                finalGrade = letterGrade + "+";
            } else if (position < 2.0) {
                finalGrade = letterGrade + "-";
            }
        }

        System.out.println();
        System.out.printf("Overall numeric average: %.2f%n", overallAverage);
        System.out.println("Base letter grade: " + letterGrade);
        System.out.println("Final letter grade: " + finalGrade);

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(outputFileName));
            writer.println("CMSC203 Project 1 - Grade Calculator Report");
            writer.println("Course: " + courseName);
            writer.println("Student: " + firstName + " " + lastName);
            writer.println("Default configuration used: " + (usedDefault ? "Yes" : "No"));
            writer.printf("Overall numeric average: %.2f%n", overallAverage);
            writer.println("Base letter grade: " + letterGrade);
            writer.println("Final letter grade: " + finalGrade);
            writer.println("Program by " + programmerName);
            writer.close();
            System.out.println("Summary written to " + outputFileName);
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to " + outputFileName);
        }

        System.out.println("Program by " + programmerName);
        System.out.println("Program complete. Goodbye!");

        keyboard.close();
    }
}
