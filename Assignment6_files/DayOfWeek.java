/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: Enumeration of the days of the week. Each day has a ticket discount: 10% on weekdays and no discount on weekends.
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
 * Days of the week, each with the ticket discount for that day.
 */
public enum DayOfWeek {
    MONDAY(0.10),
    TUESDAY(0.10),
    WEDNESDAY(0.10),
    THURSDAY(0.10),
    FRIDAY(0.10),
    SATURDAY(0.0),
    SUNDAY(0.0);

    private final double discount;

    /**
     * Creates a day with its discount.
     *
     * @param discount the discount as a decimal (0.10 = 10%)
     */
    DayOfWeek(double discount) {
        this.discount = discount;
    }

    /**
     * @return the discount for this day as a decimal
     */
    public double getDiscount() {
        return discount;
    }
}
