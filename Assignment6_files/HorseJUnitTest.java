import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HorseJUnitTest {

    private Horse horse;

    @BeforeEach
    void setUp() {
        horse = new Horse("Spirit", 4, "Mustang", "Brown");
    }

    @Test
    void testGetAge() {
        assertEquals(4, horse.getAge());
    }

    @Test
    void testNotEqualsWithDifferentAge() {
        Horse different = new Horse("Spirit", 5, "Mustang", "Brown");
        assertNotEquals(horse, different);
    }

    @Test
    void testToStringContainsAllFields() {
        String toStringOutput = horse.toString();
        assertTrue(toStringOutput.contains("Spirit"));
        assertTrue(toStringOutput.contains("4"));
        assertTrue(toStringOutput.contains("Mustang"));
        assertTrue(toStringOutput.contains("Brown"));
    }
}
