/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Represents a single rental property with a name, city,
 * monthly rent amount, and owner.
 * Due: 10/19/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Aser Wondemu
 */

/**
 * A single rental property.
 *
 * @author Aser Wondemu
 */
public class Property {

    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;

    /**
     * Default constructor. Sets the text fields to empty strings and rent to 0.
     */
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
    }

    /**
     * Parameterized constructor. Sets every field.
     *
     * @param propertyName name of the property
     * @param city city the property is in
     * @param rentAmount monthly rent
     * @param owner owner's name
     */
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
    }

    /**
     * Copy constructor. Creates a new Property with the same field values
     * as another Property.
     *
     * @param other the Property to copy
     */
    public Property(Property other) {
        this.propertyName = other.propertyName;
        this.city = other.city;
        this.rentAmount = other.rentAmount;
        this.owner = other.owner;
    }

    /**
     * @return the property name
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * @param propertyName the new property name
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the monthly rent amount
     */
    public double getRentAmount() {
        return rentAmount;
    }

    /**
     * @param rentAmount the new monthly rent amount
     */
    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    /**
     * @return the owner's name
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the new owner's name
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Returns the property as one line, for example:
     * "Sunset Villa, Rockville, Rent: $1500.00, Owner: Alice Smith"
     *
     * @return the formatted property information
     */
    @Override
    public String toString() {
        return propertyName + ", " + city + ", Rent: $" + String.format("%.2f", rentAmount)
                + ", Owner: " + owner;
    }
}
