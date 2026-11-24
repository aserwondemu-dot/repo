/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: Menu-driven driver for Bob's Circus. Lets the user add and display animals, persons, and buildings, sort and search animals, and generate tickets with day, customer, and seat discounts.
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
import java.util.Scanner;

/**
 * Console menu for the Bob's Circus Management System.
 */
public class CircusDriverApp {

    /** Name printed at the end of the program. */
    public static final String PROGRAMMER_NAME = "Aser Wondemu";

    /**
     * Shows the menu until the user chooses Exit.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Circus circus = new Circus();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to Bob's Circus Management System!");

        while (!exit) {
            try {
                // Display menu
                System.out.println("\nMenu:");
                System.out.println("1. Add Animal");
                System.out.println("2. Add Person");
                System.out.println("3. Add Building");
                System.out.println("4. Generate Ticket");
                System.out.println("5. Display All Animals");
                System.out.println("6. Display All Persons");
                System.out.println("7. Display All Buildings");
                System.out.println("8. Sort Animals by Age");
                System.out.println("9. Sort Animals by Name");
                System.out.println("10. Search Animal by Name");
                System.out.println("11. Exit\n");

                System.out.print("Choose an option: ");

                // Use validateInput method
                int choice = 0;
                boolean validInput = false;

                // Retry until valid input is received
                while (!validInput) {
                    try {
                        choice = validateInput(scanner);
                        validInput = true;
                    } catch (CustomInputMismatchException e) {
                        System.out.println(e.getMessage());
                        System.out.print("Choose an option: ");
                    }
                }

                switch (choice) {
                    case 1:
                        handleAddAnimal(circus, scanner);
                        break;
                    case 2:
                        handleAddPerson(circus, scanner);
                        break;
                    case 3:
                        handleAddBuilding(circus, scanner);
                        break;
                    case 4:
                        handleGenerateTicket(scanner);
                        break;
                    case 5:
                        System.out.println("Displaying all animals:");
                        System.out.println("---------------------------");
                        circus.displayAllAnimals();
                        break;
                    case 6:
                        System.out.println("Displaying all persons:");
                        System.out.println("---------------------------");
                        circus.displayAllPersons();
                        break;
                    case 7:
                        System.out.println("Displaying all buildings:");
                        System.out.println("---------------------------");
                        circus.displayAllBuildings();
                        break;
                    case 8:
                        System.out.println("Sorting animals by age...");
                        circus.sortAnimalsByAge();
                        System.out.println("Animals sorted by age.");
                        break;
                    case 9:
                        System.out.println("Sorting animals by name...");
                        circus.sortAnimalsByName();
                        System.out.println("Animals sorted by name.");
                        break;
                    case 10:
                        System.out.print("Enter the name of the animal to search: ");
                        scanner.nextLine(); // Consume the leftover newline
                        String searchName = scanner.nextLine();
                        circus.searchAnimalByName(searchName);
                        break;
                    case 11:
                        exit = true;
                        System.out.println("Exiting Bob's Circus Management System. Goodbye!\n");
                        System.out.println("Program written by: " + PROGRAMMER_NAME);
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }

            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    /**
     * Reads a whole number from the scanner.
     *
     * @param scanner where to read from
     * @return the number the user typed
     * @throws CustomInputMismatchException if the user did not type a number
     */
    private static int validateInput(Scanner scanner) throws CustomInputMismatchException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // throw away the bad input
            throw new CustomInputMismatchException("Invalid input. Please enter a number.");
        }
    }

    /**
     * Asks for an animal type and details, then adds the animal to the circus.
     *
     * @param circus the circus to add to
     * @param scanner where to read from
     */
    private static void handleAddAnimal(Circus circus, Scanner scanner) {
        scanner.nextLine(); // Consume the leftover newline
        System.out.println("Select animal type:");
        System.out.println("1. Dog");
        System.out.println("2. Horse");
        System.out.println("3. Bird");
        System.out.println("4. Lion");
        int type = readInt(scanner, "Enter your choice: ", 1, 4);

        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        int age = readInt(scanner, "Enter age: ", 0, 200);
        System.out.print("Enter species: ");
        String species = scanner.nextLine().trim();
        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim();

        Animal animal;
        if (type == 1) {
            animal = new Dog(name, age, species, color);
        } else if (type == 2) {
            animal = new Horse(name, age, species, color);
        } else if (type == 3) {
            animal = new Bird(name, age, species, color);
        } else {
            animal = new Lion(name, age, species, color);
        }
        circus.addAnimal(animal);
        System.out.println("Animal added: " + animal);
        animal.move();
        animal.makeSound();
    }

    /**
     * Asks for a person type and details, then adds the person to the circus.
     *
     * @param circus the circus to add to
     * @param scanner where to read from
     */
    private static void handleAddPerson(Circus circus, Scanner scanner) {
        scanner.nextLine(); // Consume the leftover newline
        System.out.println("Select person type:");
        System.out.println("1. Clerk");
        System.out.println("2. Acrobatic");
        int type = readInt(scanner, "Enter your choice: ", 1, 2);

        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        int age = readInt(scanner, "Enter age: ", 0, 150);
        int years = readInt(scanner, "Enter years worked: ", 0, 150);
        System.out.print("Enter job: ");
        String job = scanner.nextLine().trim();

        Person person;
        if (type == 1) {
            person = new Clerk(name, age, years, job);
        } else {
            person = new Acrobatic(name, age, years, job);
        }
        circus.addPerson(person);
        System.out.println("Person added:");
        System.out.println(person);
    }

    /**
     * Asks for a building type and details, then adds the building to the circus.
     *
     * @param circus the circus to add to
     * @param scanner where to read from
     */
    private static void handleAddBuilding(Circus circus, Scanner scanner) {
        scanner.nextLine(); // Consume the leftover newline
        System.out.println("Select building type:");
        System.out.println("1. Arena");
        System.out.println("2. Ticketing Office");
        int type = readInt(scanner, "Enter your choice: ", 1, 2);

        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim();
        double length = readDouble(scanner, "Enter length: ");
        double width = readDouble(scanner, "Enter width: ");

        Building building;
        if (type == 1) {
            building = new Arena(color, length, width);
        } else {
            building = new TicketingOffice(color, length, width);
        }
        circus.addBuilding(building);
        System.out.println("Building added: " + building);
    }

    /**
     * Calculates the price of one ticket after the day, customer, and seat
     * adjustments. T-level seats double the price; upper-level seats get 5% off.
     *
     * @param basePrice the regular ticket price
     * @param day the day of the week (gives the day discount)
     * @param customerDiscount the customer discount as a decimal (0.10 = 10%)
     * @param seatLocation 1 = lower level, 2 = T-level, 3 = upper level
     * @return the price of one ticket
     */
    public static double calculateTicketPrice(double basePrice, DayOfWeek day,
            double customerDiscount, int seatLocation) {
        double seatMultiplier = (seatLocation == 2) ? 2.0 : 1.0;
        double seatDiscount = (seatLocation == 3) ? 0.05 : 0.0;
        return basePrice * seatMultiplier
                * (1 - day.getDiscount())
                * (1 - customerDiscount)
                * (1 - seatDiscount);
    }

    /**
     * Sells one or more groups of tickets and prints an itemized total.
     *
     * @param scanner where to read from
     */
    private static void handleGenerateTicket(Scanner scanner) {
        double totalAmount = 0;
        double basePrice;
        StringBuilder ticketDetails = new StringBuilder();
        boolean addMoreTickets = true;

        scanner.nextLine(); // Consume the leftover newline
        basePrice = readDouble(scanner, "\nEnter ticket base price: ");

        ticketDetails.append(String.format("Regular ticket price: $%.2f%n%n", basePrice));

        while (addMoreTickets) {
            // Select day of the week
            System.out.println("\nSelect day of the week:");
            for (int i = 0; i < DayOfWeek.values().length; i++) {
                DayOfWeek day = DayOfWeek.values()[i];
                if (day.getDiscount() > 0) {
                    System.out.printf("%d. %s (%.0f%% discount)%n", i + 1, day, day.getDiscount() * 100);
                } else {
                    System.out.printf("%d. %s%n", i + 1, day);
                }
            }
            int dayChoice = readInt(scanner, "\nEnter your choice: ", Integer.MIN_VALUE, Integer.MAX_VALUE);

            if (dayChoice < 1 || dayChoice > DayOfWeek.values().length) {
                System.out.println("Invalid choice. Please select a valid day.");
                continue;
            }

            DayOfWeek selectedDay = DayOfWeek.values()[dayChoice - 1];
            double dayDiscount = selectedDay.getDiscount();

            // Select customer type
            System.out.println("\nEnter customer type:");
            System.out.println("1. Child (10% discount)");
            System.out.println("2. Student (10% discount)");
            System.out.println("3. Adult");
            System.out.println("4. Senior (5% discount)");
            int customerType = readInt(scanner, "\nEnter your choice: ", Integer.MIN_VALUE, Integer.MAX_VALUE);

            double customerDiscount = 0.0;
            String customerTypeName = "";
            switch (customerType) {
                case 1:
                    customerDiscount = 0.10;
                    customerTypeName = "child";
                    break;
                case 2:
                    customerDiscount = 0.10;
                    customerTypeName = "student";
                    break;
                case 3:
                    customerTypeName = "adult";
                    break;
                case 4:
                    customerDiscount = 0.05;
                    customerTypeName = "senior";
                    break;
                default:
                    System.out.println("Invalid customer type. Please try again.");
                    continue;
            }

            // Select seat location
            System.out.println("\nSeat Location in the Arena:");
            System.out.println("1. Lower level");
            System.out.println("2. T-level (double ticket price)");
            System.out.println("3. Upper level (5% discount)");
            int seatLocation = readInt(scanner, "\nEnter your choice: ", Integer.MIN_VALUE, Integer.MAX_VALUE);

            if (seatLocation < 1 || seatLocation > 3) {
                System.out.println("Invalid seat location. Please try again.");
                continue;
            }
            String seatName = (seatLocation == 1) ? "Lower level"
                    : (seatLocation == 2) ? "T-level" : "Upper level";
            double seatDiscount = (seatLocation == 3) ? 0.05 : 0.0;

            int numberOfTickets = readInt(scanner, "Enter number of tickets: ", 1, 1000);

            // Calculate discounts and total price for this batch of tickets
            double pricePerTicket = calculateTicketPrice(basePrice, selectedDay, customerDiscount, seatLocation);
            double batchTotal = pricePerTicket * numberOfTickets;

            // Add to total amount
            totalAmount += batchTotal;

            // Append details of this batch to the ticket details
            ticketDetails.append(String.format("%d %s ticket(s), %s, %s: $%.2f%n",
                    numberOfTickets, customerTypeName, seatName, selectedDay, batchTotal));

            // Append the discounts used for this batch
            ticketDetails.append(String.format("   Day discount: %.0f%%, Customer discount: %.0f%%, "
                    + "Seat: %s%n%n", dayDiscount * 100, customerDiscount * 100,
                    (seatLocation == 2) ? "double price" : String.format("%.0f%% discount", seatDiscount * 100)));

            // Ask user to add more tickets
            System.out.print("\nDo you want to add more tickets? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            addMoreTickets = response.equals("y");
        }

        // Display ticket calculation details
        System.out.println("\nTicket Calculation Details:");
        System.out.println("---------------------------");
        System.out.println(ticketDetails);

        // Display final total amount
        System.out.printf("Final Total Amount: $%.2f%n", totalAmount);
        System.out.println("Enjoy the show!");
    }

    // Reads a whole number on its own line, asking again until it is a number in [min, max]
    private static int readInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a number from " + min + " to " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    // Reads a non-negative decimal number on its own line, asking again until it is valid
    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(line);
                if (value >= 0) {
                    return value;
                }
                System.out.println("Please enter a number that is not negative.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
