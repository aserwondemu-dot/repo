import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AcrobaticJUnitTest {

    @Test
    public void testConstructorAndInheritedGetters() {
        // Create an instance of Acrobatic
        Acrobatic acrobatic = new Acrobatic("Mike Bell", 30, 8, "Trapeze Artist");

        // Test inherited fields and getters
        //Student Code
    }

    @Test
    public void testToString() {
        Acrobatic acrobatic = new Acrobatic("Alice Brown", 35, 12, "Fire Breather");
        // Expected output 
        String expected = "Name: Alice Brown\nAge: 35\nYears Worked: 12\nJob: Fire Breather";
        assertEquals(expected, acrobatic.toString());
    }

}
