/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Procedure class. Stores information about a single medical
 * procedure (name, date, practitioner, and charges) and provides methods
 * to classify and format the charge amount.
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 */
public class Procedure {

    private String procedureName;
    private String date;
    private String practitionerName;
    private double charges;

    // No-argument constructor. Sets text fields to empty strings and charges to 0.
    public Procedure() {
        this.procedureName = "";
        this.date = "";
        this.practitionerName = "";
        this.charges = 0.0;
    }

    // Constructor that initializes only the procedure name and date.
    public Procedure(String procedureName, String date) {
        this.procedureName = procedureName;
        this.date = date;
        this.practitionerName = "";
        this.charges = 0.0;
    }

    // Constructor that initializes every attribute of the procedure.
    public Procedure(String procedureName, String date, String practitionerName, double charges) {
        this.procedureName = procedureName;
        this.date = date;
        this.practitionerName = practitionerName;
        this.charges = charges;
    }

    // Accessors and mutators for every field.
    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPractitionerName() {
        return practitionerName;
    }

    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    // Returns all procedure information as a formatted string.
    @Override
    public String toString() {
        return "Procedure Information\n"
                + "----------------------\n"
                + "Name: " + procedureName + "\n"
                + "Date: " + date + "\n"
                + "Practitioner: " + practitionerName + "\n"
                + "Charge: " + getFormattedCharge() + "\n"
                + "Category: " + getChargeCategory();
    }

    // Returns true if the charges are 1000.00 or more.
    public boolean isExpensiveProcedure() {
        return charges >= 1000.00;
    }

    // Reduces the charges by the given percent. Only accepts 0-100; otherwise does nothing.
    public void applyDiscount(double percent) {
        if (percent >= 0 && percent <= 100) {
            charges = charges - (charges * percent / 100.0);
        }
    }

    // Returns "Low" (< 500), "Medium" (500 to 999.99), or "High" (>= 1000).
    public String getChargeCategory() {
        if (charges >= 1000.00) {
            return "High";
        } else if (charges >= 500.00) {
            return "Medium";
        } else {
            return "Low";
        }
    }

    // Returns true if the given name matches this procedure's practitioner (case-insensitive).
    public boolean isPerformedBy(String practitionerName) {
        return this.practitionerName.equalsIgnoreCase(practitionerName);
    }

    // Returns the charge formatted with a dollar sign, thousands commas, and two decimals.
    public String getFormattedCharge() {
        return String.format("$%,.2f", charges);
    }
}
