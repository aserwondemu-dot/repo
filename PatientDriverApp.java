import java.util.Scanner;

/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Driver class for the Patient Application. Reads a
 * patient's information from the keyboard, builds three Procedure
 * objects (one with each constructor style), displays the patient and
 * procedure information, and calculates/display a summary of charges.
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 */
public class PatientDriverApp {

    // Reads all patient fields from the keyboard and returns a new Patient.
    public static Patient inputPatient(Scanner input) {
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter middle name: ");
        String middleName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter street address: ");
        String street = input.nextLine();

        System.out.print("Enter city: ");
        String city = input.nextLine();

        System.out.print("Enter state: ");
        String state = input.nextLine();

        System.out.print("Enter zip: ");
        String zip = input.nextLine();

        System.out.print("Enter phone number (###-###-####): ");
        String phone = input.nextLine();

        System.out.print("Enter emergency contact name: ");
        String emergencyName = input.nextLine();

        System.out.print("Enter emergency contact phone (###-###-####): ");
        String emergencyPhone = input.nextLine();

        return new Patient(firstName, middleName, lastName, street, city, state, zip,
                phone, emergencyName, emergencyPhone);
    }

    // Creates the first procedure using the no-arg constructor, then sets every field.
    public static Procedure createProcedure1() {
        Procedure procedure = new Procedure();
        procedure.setProcedureName("Physical Exam");
        procedure.setDate("07/20/2026");
        procedure.setPractitionerName("Dr. Irvine");
        procedure.setCharges(250.00);
        return procedure;
    }

    // Creates the second procedure using the (name, date) constructor, then sets the rest.
    public static Procedure createProcedure2() {
        Procedure procedure = new Procedure("X-ray", "07/20/2026");
        procedure.setPractitionerName("Dr. Jamison");
        procedure.setCharges(550.43);
        return procedure;
    }

    // Creates the third procedure using the constructor that sets every field at once.
    public static Procedure createProcedure3() {
        return new Procedure("Blood Test", "07/20/2026", "Dr. Smith", 1400.75);
    }

    // Displays the patient's information along with phone validity checks.
    public static void displayPatient(Patient patient) {
        System.out.println(patient.toString());
        System.out.println("Phone Valid: " + patient.isValidPhoneNumber());
        System.out.println("Emergency Phone Valid: " + patient.isValidEmergencyPhoneNumber());
    }

    // Displays a single procedure's information.
    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure.toString());
    }

    // Displays all three procedures in an aligned table.
    public static void displayProcedureTable(Procedure p1, Procedure p2, Procedure p3) {
        System.out.printf("%-20s%-13s%-20s%-16s%-8s%n", "Procedure", "Date", "Practitioner", "Charge", "Category");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-20s%-13s%-20s%-16s%-8s%n", p1.getProcedureName(), p1.getDate(),
                p1.getPractitionerName(), p1.getFormattedCharge(), p1.getChargeCategory());
        System.out.printf("%-20s%-13s%-20s%-16s%-8s%n", p2.getProcedureName(), p2.getDate(),
                p2.getPractitionerName(), p2.getFormattedCharge(), p2.getChargeCategory());
        System.out.printf("%-20s%-13s%-20s%-16s%-8s%n", p3.getProcedureName(), p3.getDate(),
                p3.getPractitionerName(), p3.getFormattedCharge(), p3.getChargeCategory());
    }

    // Returns the sum of all three procedures' charges.
    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getCharges() + p2.getCharges() + p3.getCharges();
    }

    // Returns the average charge across all three procedures.
    public static double calculateAverageCharge(Procedure p1, Procedure p2, Procedure p3) {
        return calculateTotalCharges(p1, p2, p3) / 3.0;
    }

    // Returns whichever of the three procedures has the highest charge.
    public static Procedure findHighestChargeProcedure(Procedure p1, Procedure p2, Procedure p3) {
        Procedure highest = p1;
        if (p2.getCharges() > highest.getCharges()) {
            highest = p2;
        }
        if (p3.getCharges() > highest.getCharges()) {
            highest = p3;
        }
        return highest;
    }

    // Returns how many of the three procedures are considered expensive.
    public static int countExpensiveProcedures(Procedure p1, Procedure p2, Procedure p3) {
        int count = 0;
        if (p1.isExpensiveProcedure()) {
            count++;
        }
        if (p2.isExpensiveProcedure()) {
            count++;
        }
        if (p3.isExpensiveProcedure()) {
            count++;
        }
        return count;
    }

    // Displays the total charges, average charge, highest-charge procedure, and expensive count.
    public static void displaySummary(Procedure p1, Procedure p2, Procedure p3) {
        double total = calculateTotalCharges(p1, p2, p3);
        double average = calculateAverageCharge(p1, p2, p3);
        Procedure highest = findHighestChargeProcedure(p1, p2, p3);
        int expensiveCount = countExpensiveProcedures(p1, p2, p3);

        System.out.printf("Total Charges: $%,.2f%n", total);
        System.out.printf("Average Charge: $%,.2f%n", average);
        System.out.println("Highest Charge Procedure: " + highest.getProcedureName());
        System.out.println("Number of Expensive Procedures: " + expensiveCount);
    }

    public static void main(String[] args) {

        // TODO: replace with your own name and the date you are submitting
        String studentName = "Aser Wondemu";
        String submissionDate = "09/21/26";

        Scanner input = new Scanner(System.in);

        Patient patient = inputPatient(input);
        System.out.println();
        displayPatient(patient);
        System.out.println();

        Procedure p1 = createProcedure1();
        Procedure p2 = createProcedure2();
        Procedure p3 = createProcedure3();

        displayProcedureTable(p1, p2, p3);
        System.out.println();

        displaySummary(p1, p2, p3);
        System.out.println();

        System.out.println("The program was developed by a Student: " + studentName + " " + submissionDate);

        input.close();
    }
}
