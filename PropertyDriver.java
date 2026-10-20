/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Console driver for the Property Management application.
 * Shows a menu that lets the user add properties to a ManagementCompany,
 * display all properties, and show the total rent.
 * Due: 10/19/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Aser Wondemu
 */

import java.util.Scanner;

/**
 * Menu-driven console program for managing properties.
 *
 * @author Aser Wondemu
 */
public class PropertyDriver {

    /** Name printed at the end of the program. */
    public static final String PROGRAMMER_NAME = "Aser Wondemu";

    /**
     * Creates the company and starts the menu.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManagementCompany company = new ManagementCompany("Campus Realty", "123-45-6789");
        run(input, company);
        input.close();
    }

    /**
     * Shows the menu over and over until the user chooses 4 (Exit).
     * Kept separate from main so it can be tested with JUnit.
     *
     * @param input where the user's answers are read from
     * @param company the company that properties are added to
     */
    public static void run(Scanner input, ManagementCompany company) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = input.hasNextLine() ? input.nextLine().trim() : "4";

            if (choice.equals("1")) {
                addPropertyFromUser(input, company);
            } else if (choice.equals("2")) {
                System.out.println(company.toString());
            } else if (choice.equals("3")) {
                System.out.printf("Total rent: $%.2f%n", company.totalRent());
            } else if (choice.equals("4")) {
                running = false;
            } else {
                System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        }

        // Copy constructor demo: back up the company before exiting
        ManagementCompany backup = new ManagementCompany(company);
        System.out.printf("Backup copy made: %d properties, total rent $%.2f%n",
                backup.getPropertyCount(), backup.totalRent());
        System.out.println("Program written by: " + PROGRAMMER_NAME);
    }

    /**
     * Prints the main menu.
     */
    public static void printMenu() {
        System.out.println("====================================");
        System.out.println("Assignment 4: Property Manager");
        System.out.println("====================================");
        System.out.println("1 - Add Property");
        System.out.println("2 - Display All Properties");
        System.out.println("3 - Show Total Rent");
        System.out.println("4 - Exit");
        System.out.print("Enter choice (1-4): ");
    }

    /**
     * Asks the user for a property's details, then adds it to the company.
     * Re-asks for the rent until a valid, non-negative number is entered.
     *
     * @param input where the user's answers are read from
     * @param company the company to add the property to
     */
    public static void addPropertyFromUser(Scanner input, ManagementCompany company) {
        if (company.getPropertyCount() >= ManagementCompany.MAX_PROPERTIES) {
            System.out.println("Cannot add property: the company is full (max "
                    + ManagementCompany.MAX_PROPERTIES + ").");
            return;
        }

        System.out.print("Enter property name: ");
        String name = input.nextLine();
        System.out.print("Enter city: ");
        String city = input.nextLine();

        double rent = -1;
        while (rent < 0) {
            System.out.print("Enter monthly rent: ");
            String rentText = input.nextLine().trim();
            try {
                rent = Double.parseDouble(rentText);
                if (rent < 0) {
                    System.out.println("Rent cannot be negative. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid rent. Please enter a number.");
                rent = -1;
            }
        }

        System.out.print("Enter owner name: ");
        String owner = input.nextLine();

        int index = company.addProperty(new Property(name, city, rent, owner));
        System.out.println("Property added at index " + index + ".");
    }
}
