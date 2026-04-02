import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            TrainConsistManagementApp.PassengerBogie b =
                    new TrainConsistManagementApp.PassengerBogie("Sleeper", 50);
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("Sleeper", -10)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("AC", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("First Class", -1)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        TrainConsistManagementApp.PassengerBogie b =
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);

        assertEquals("Sleeper", b.type);
        assertEquals(72, b.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);
            new TrainConsistManagementApp.PassengerBogie("AC", 60);
            new TrainConsistManagementApp.PassengerBogie("First Class", 30);
        });
    }
}