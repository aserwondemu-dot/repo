import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DogJUnitTest {

    private Dog dog;

    @BeforeEach
    void setUp() {
        dog = new Dog("Buddy", 5, "Labrador", "Brown");
    }

    @Test
    void testGetAge() {
        assertEquals(5, dog.getAge());
    }

    @Test
    void testEqualsSameFields() {
        Dog anotherDog = new Dog("Buddy", 5, "Labrador", "Brown");
        assertEquals(dog, anotherDog);
    }

}
