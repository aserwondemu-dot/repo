/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: JUnit tests for the Circus class: adding, displaying, selection sorts, and search.
 * Due: 11/23/2026
 * Platform/Compiler: Eclipse
 *
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any other source, and I have
 * not given my code to another student.
 *
 * Print your name here: Aser Wondemu
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Student JUnit tests for Circus.
 */
public class CircusJUnitTestStudent {

    private Circus circus;
    private ByteArrayOutputStream out;
    private PrintStream original;

    /** Creates a circus with three animals and captures printed output. */
    @BeforeEach
    public void setUp() {
        circus = new Circus();
        circus.addAnimal(new Lion("Zara", 9, "Panthera leo", "Tan"));
        circus.addAnimal(new Dog("Ace", 4, "Poodle", "White"));
        circus.addAnimal(new Bird("Milo", 1, "Finch", "Red"));
        original = System.out;
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    /** Restores System.out after each test. */
    @AfterEach
    public void tearDown() {
        System.setOut(original);
    }

    /** A new circus has empty lists. */
    @Test
    public void testNewCircusIsEmpty() {
        Circus empty = new Circus();
        assertEquals(0, empty.getAnimals().size());
        assertEquals(0, empty.getPersons().size());
        assertEquals(0, empty.getBuildings().size());
    }

    /** addAnimal, addPerson, and addBuilding store the objects. */
    @Test
    public void testAddMethods() {
        circus.addPerson(new Clerk("Ana Diaz", 40, 15, "Cashier"));
        circus.addBuilding(new Arena("Blue", 100, 50));
        assertEquals(3, circus.getAnimals().size());
        assertEquals(1, circus.getPersons().size());
        assertEquals(1, circus.getBuildings().size());
        assertEquals("Ana Diaz", circus.getPersons().get(0).getName());
    }

    /** sortAnimalsByAge puts the youngest first. */
    @Test
    public void testSortAnimalsByAge() {
        circus.sortAnimalsByAge();
        List<Animal> animals = circus.getAnimals();
        assertEquals("Milo", animals.get(0).getName());
        assertEquals("Ace", animals.get(1).getName());
        assertEquals("Zara", animals.get(2).getName());
    }

    /** sortAnimalsByName puts the names in A-Z order. */
    @Test
    public void testSortAnimalsByName() {
        circus.sortAnimalsByName();
        List<Animal> animals = circus.getAnimals();
        assertEquals("Ace", animals.get(0).getName());
        assertEquals("Milo", animals.get(1).getName());
        assertEquals("Zara", animals.get(2).getName());
    }

    /** Sorting an empty circus does not crash. */
    @Test
    public void testSortEmptyCircus() {
        Circus empty = new Circus();
        empty.sortAnimalsByAge();
        empty.sortAnimalsByName();
        assertEquals(0, empty.getAnimals().size());
    }

    /** searchAnimalByName finds an animal, ignoring case. */
    @Test
    public void testSearchFound() {
        Animal found = circus.searchAnimalByName("milo");
        assertNotNull(found);
        assertEquals("Milo", found.getName());
        assertTrue(out.toString().contains("Animal found"));
    }

    /** searchAnimalByName returns null when the name is not there. */
    @Test
    public void testSearchNotFound() {
        assertNull(circus.searchAnimalByName("Nemo"));
        assertTrue(out.toString().contains("Animal not found"));
    }

    /** The display methods print each object's toString. */
    @Test
    public void testDisplayMethods() {
        circus.addPerson(new Acrobatic("Leo Park", 22, 3, "Juggler"));
        circus.addBuilding(new TicketingOffice("Red", 20, 10));
        circus.displayAllAnimals();
        circus.displayAllPersons();
        circus.displayAllBuildings();
        String printed = out.toString();
        assertTrue(printed.contains("Lion [Name: Zara"));
        assertTrue(printed.contains("Job: Juggler"));
        assertTrue(printed.contains("Ticketing Office [Color: Red"));
    }
}
