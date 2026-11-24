import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LionJUnitTest {

    private Lion lion;

    @BeforeEach
    void setUp() {
        lion = new Lion("Simba", 6, "Panthera leo", "Golden");
    }

    @Test
    void testGetName() {
        assertEquals("Simba", lion.getName());
    }

    @Test
    void testEqualsWithSameAttributes() {
        Lion sameLion = new Lion("Simba", 6, "Panthera leo", "Golden");
        assertEquals(lion, sameLion);
    }

}
