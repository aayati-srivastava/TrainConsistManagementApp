import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // Helper dataset
    private List<TrainConsistManagementApp.Bogie> createBogies() {
        List<TrainConsistManagementApp.Bogie> list = new ArrayList<>();

        list.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));
        list.add(new TrainConsistManagementApp.Bogie("AC", 50));
        list.add(new TrainConsistManagementApp.Bogie("Sleeper", 80));
        list.add(new TrainConsistManagementApp.Bogie("AC", 40));

        return list;
    }

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterUsingLoop(createBogies(), 60);

        for (TrainConsistManagementApp.Bogie b : result) {
            assertTrue(b.capacity > 60);
        }
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterUsingStream(createBogies(), 60);

        for (TrainConsistManagementApp.Bogie b : result) {
            assertTrue(b.capacity > 60);
        }
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagementApp.Bogie> bogies = createBogies();

        List<TrainConsistManagementApp.Bogie> loopResult =
                TrainConsistManagementApp.filterUsingLoop(bogies, 60);

        List<TrainConsistManagementApp.Bogie> streamResult =
                TrainConsistManagementApp.filterUsingStream(bogies, 60);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistManagementApp.Bogie> bogies = createBogies();

        long loopTime = TrainConsistManagementApp.measureLoopTime(bogies, 60);
        long streamTime = TrainConsistManagementApp.measureStreamTime(bogies, 60);

        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", i));
        }

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterUsingStream(bogies, 60);

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}