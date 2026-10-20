/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: A management company that holds a fixed-size array of
 * Property objects (aggregation). It can add properties, count them,
 * and calculate the total rent.
 * Due: 10/19/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Aser Wondemu
 */

/**
 * A company that manages up to MAX_PROPERTIES properties.
 *
 * @author Aser Wondemu
 */
public class ManagementCompany {

    /** The most properties a company can hold. */
    public static final int MAX_PROPERTIES = 5;

    private String name;
    private String taxId;
    private Property[] properties;
    private int propertyCount;

    /**
     * Parameterized constructor. Creates a company with an empty property array.
     *
     * @param name company name
     * @param taxId company tax ID
     */
    public ManagementCompany(String name, String taxId) {
        this.name = name;
        this.taxId = taxId;
        this.properties = new Property[MAX_PROPERTIES];
        this.propertyCount = 0;
    }

    /**
     * Copy constructor. Makes a deep copy: every Property in the other
     * company is copied into a brand new Property object.
     *
     * @param other the company to copy
     */
    public ManagementCompany(ManagementCompany other) {
        this.name = other.name;
        this.taxId = other.taxId;
        this.properties = new Property[MAX_PROPERTIES];
        this.propertyCount = other.propertyCount;
        for (int i = 0; i < other.propertyCount; i++) {
            this.properties[i] = new Property(other.properties[i]);
        }
    }

    /**
     * Adds a copy of the given property to the next open spot in the array.
     *
     * @param p the property to add
     * @return the index where it was added, -1 if the array is full,
     *         or -2 if the property is null
     */
    public int addProperty(Property p) {
        if (p == null) {
            return -2;
        }
        if (propertyCount >= MAX_PROPERTIES) {
            return -1;
        }
        properties[propertyCount] = new Property(p);
        propertyCount++;
        return propertyCount - 1;
    }

    /**
     * Adds up the rent of every property in the company.
     *
     * @return the total monthly rent
     */
    public double totalRent() {
        double total = 0.0;
        for (int i = 0; i < propertyCount; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    /**
     * @return how many properties the company currently has
     */
    public int getPropertyCount() {
        return propertyCount;
    }

    /**
     * Returns the property at an index, or null if the index is not in use.
     *
     * @param index position in the array
     * @return the property at that index, or null
     */
    public Property getProperty(int index) {
        if (index < 0 || index >= propertyCount) {
            return null;
        }
        return properties[index];
    }

    /**
     * @return the company name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the company tax ID
     */
    public String getTaxId() {
        return taxId;
    }

    /**
     * Summarizes the company, each of its properties, and the total rent.
     *
     * @return the formatted company information
     */
    @Override
    public String toString() {
        String result = "Management Company: " + name + " (Tax ID: " + taxId + ")\n";
        result += "Properties:\n";
        if (propertyCount == 0) {
            result += "(none)\n";
        }
        for (int i = 0; i < propertyCount; i++) {
            result += i + ": " + properties[i].toString() + "\n";
        }
        result += "Total Rent: $" + String.format("%.2f", totalRent());
        return result;
    }
}
