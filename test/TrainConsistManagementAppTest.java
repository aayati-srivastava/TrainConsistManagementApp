import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // Helper method to create sample bogies
    private List<TrainConsistManagementApp.Bogie> createBogies() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 90));

        return bogies;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainConsistManagementApp.Bogie> result =
                createBogies().stream()
                        .filter(b -> b.capacity > 60)
                        .toList();

        for (TrainConsistManagementApp.Bogie b : result) {
            assertTrue(b.capacity > 60);
        }
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 60));

        List<TrainConsistManagementApp.Bogie> result =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .toList();

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("AC", 40));

        List<TrainConsistManagementApp.Bogie> result =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .toList();

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> result =
                createBogies().stream()
                        .filter(b -> b.capacity > 60)
                        .toList();

        assertEquals(2, result.size()); // Sleeper(72), General(90)
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 20));

        List<TrainConsistManagementApp.Bogie> result =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .toList();

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 80));

        List<TrainConsistManagementApp.Bogie> result =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .toList();

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        List<TrainConsistManagementApp.Bogie> result =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .toList();

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = createBogies();

        List<TrainConsistManagementApp.Bogie> result =
                bogies.stream()
                        .filter(b -> b.capacity > 60)
                        .toList();

        assertEquals(4, bogies.size()); // original list unchanged
    }
}