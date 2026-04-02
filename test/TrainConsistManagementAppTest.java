import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // ===== TRAIN ID TEST CASES =====

    @Test
    void testValidTrainId() {
        assertTrue(TrainConsistManagementApp.isValidTrainId("TRN-1234"));
    }

    @Test
    void testInvalidTrainId_WrongPrefix() {
        assertFalse(TrainConsistManagementApp.isValidTrainId("ABC-1234"));
    }

    @Test
    void testInvalidTrainId_LessDigits() {
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRN-123"));
    }

    @Test
    void testInvalidTrainId_MoreDigits() {
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRN-12345"));
    }

    @Test
    void testInvalidTrainId_AlphabetsInsteadDigits() {
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRN-ABCD"));
    }

    // ===== CARGO CODE TEST CASES =====

    @Test
    void testValidCargoCode() {
        assertTrue(TrainConsistManagementApp.isValidCargoCode("PET-AB"));
    }

    @Test
    void testInvalidCargoCode_WrongPrefix() {
        assertFalse(TrainConsistManagementApp.isValidCargoCode("OIL-AB"));
    }

    @Test
    void testInvalidCargoCode_LowercaseLetters() {
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-ab"));
    }

    @Test
    void testInvalidCargoCode_MoreLetters() {
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-ABC"));
    }

    @Test
    void testInvalidCargoCode_NumbersInsteadLetters() {
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-12"));
    }
}