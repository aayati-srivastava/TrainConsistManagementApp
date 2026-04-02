import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementAppTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    List<Bogie> filterBogies(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThan60() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("General", 90)
        );

        List<Bogie> result = filterBogies(bogies);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualTo60() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("AC Chair", 60)
        );

        List<Bogie> result = filterBogies(bogies);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_CapacityLessThan60() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("First Class", 40),
                new Bogie("AC Chair", 56)
        );

        List<Bogie> result = filterBogies(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleMatchingBogies() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("General", 90),
                new Bogie("Sleeper", 70)
        );

        List<Bogie> result = filterBogies(bogies);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoMatchingBogies() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("First Class", 24),
                new Bogie("AC Chair", 50)
        );

        List<Bogie> result = filterBogies(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_EmptyList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = filterBogies(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        filterBogies(bogies);

        assertEquals(2, bogies.size());
    }
}