/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for ManagementCompany: adding properties,
 * full array, total rent, and deep copy.
 * Due: 10/19/2026
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Aser Wondemu
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Student JUnit tests for ManagementCompany.
 */
public class ManagementCompanyJUnitTestStudent {

    private ManagementCompany company;

    /**
     * Creates an empty company before each test.
     */
    @BeforeEach
    public void setUp() {
        company = new ManagementCompany("Metro Homes", "987-65-4321");
    }

    /** A new company starts empty. */
    @Test
    public void testNewCompanyIsEmpty() {
        assertEquals(0, company.getPropertyCount());
        assertEquals(0.0, company.totalRent(), 0.001);
        assertEquals("Metro Homes", company.getName());
        assertEquals("987-65-4321", company.getTaxId());
    }

    /** Adding properties returns their indexes and increases the count. */
    @Test
    public void testAddProperty() {
        assertEquals(0, company.addProperty(new Property("Unit A", "Germantown", 1100.0, "Kim")));
        assertEquals(1, company.addProperty(new Property("Unit B", "Germantown", 1350.0, "Lou")));
        assertEquals(2, company.getPropertyCount());
    }

    /** Total rent is the sum of all rents. */
    @Test
    public void testTotalRent() {
        company.addProperty(new Property("Unit A", "Germantown", 1100.0, "Kim"));
        company.addProperty(new Property("Unit B", "Germantown", 1350.0, "Lou"));
        company.addProperty(new Property("Unit C", "Olney", 900.25, "Max"));
        assertEquals(3350.25, company.totalRent(), 0.001);
    }

    /** Adding to a full company returns -1 and does not change the count. */
    @Test
    public void testAddWhenFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTIES; i++) {
            company.addProperty(new Property("Lot " + i, "Laurel", 500.0, "Owner " + i));
        }
        assertEquals(-1, company.addProperty(new Property("Too Many", "Laurel", 500.0, "Nope")));
        assertEquals(ManagementCompany.MAX_PROPERTIES, company.getPropertyCount());
    }

    /** Adding null returns -2. */
    @Test
    public void testAddNull() {
        assertEquals(-2, company.addProperty(null));
        assertEquals(0, company.getPropertyCount());
    }

    /** The company stores a copy, so changing the original object later has no effect. */
    @Test
    public void testAddStoresCopy() {
        Property original = new Property("Unit A", "Germantown", 1100.0, "Kim");
        company.addProperty(original);
        original.setRentAmount(5000.0);
        assertEquals(1100.0, company.totalRent(), 0.001);
    }

    /** Copy constructor makes a deep copy of every property. */
    @Test
    public void testDeepCopyConstructor() {
        company.addProperty(new Property("Unit A", "Germantown", 1100.0, "Kim"));
        ManagementCompany copy = new ManagementCompany(company);
        assertEquals(company.getPropertyCount(), copy.getPropertyCount());
        assertNotSame(company.getProperty(0), copy.getProperty(0));
        copy.getProperty(0).setRentAmount(1.0);
        assertEquals(1100.0, company.totalRent(), 0.001);
    }

    /** toString lists the company and its properties. */
    @Test
    public void testToString() {
        company.addProperty(new Property("Unit A", "Germantown", 1100.0, "Kim"));
        String expected = "Management Company: Metro Homes (Tax ID: 987-65-4321)\n"
                + "Properties:\n"
                + "0: Unit A, Germantown, Rent: $1100.00, Owner: Kim\n"
                + "Total Rent: $1100.00";
        assertEquals(expected, company.toString());
    }
}
