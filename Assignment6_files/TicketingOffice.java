/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: The Ticketing Office building at the circus. Implements Building.
 * Due: 11/23/2026
 * Platform/Compiler: Eclipse
 *
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any other source, and I have
 * not given my code to another student.
 *
 * Print your name here: Aser Wondemu
 */

/**
 * The Ticketing Office building of the circus.
 */
public class TicketingOffice implements Building {
    private String color;
    private double length;
    private double width;
    private String buildingType;

    /**
     * Creates the building. The building type starts as "Ticketing Office".
     *
     * @param color the building's color
     * @param length the building's length
     * @param width the building's width
     */
    public TicketingOffice(String color, double length, double width) {
        this.color = color;
        this.length = length;
        this.width = width;
        this.buildingType = "Ticketing Office";
    }

    /**
     * Sets the length and width of the building.
     *
     * @param length the new length
     * @param width the new width
     */
    @Override
    public void setSize(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * @return the building's length
     */
    @Override
    public double getLength() {
        return length;
    }

    /**
     * @return the building's width
     */
    @Override
    public double getWidth() {
        return width;
    }

    /**
     * @param color the new color
     */
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the building's color
     */
    @Override
    public String getColor() {
        return color;
    }

    /**
     * @param type the new building type
     */
    @Override
    public void setBuildingType(String type) {
        this.buildingType = type;
    }

    /**
     * @return the building type
     */
    @Override
    public String getBuildingType() {
        return buildingType;
    }

    /**
     * @return the building type, color, and size
     */
    @Override
    public String toString() {
        return String.format("%s [Color: %s, Length: %.2f, Width: %.2f]",
                buildingType, color, length, width);
    }
}
