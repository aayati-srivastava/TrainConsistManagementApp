import java.util.*;

public class TrainConsistManagementApp {

    // ✅ Custom Exception
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ✅ Passenger Bogie Class
    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   UC14 - Custom Exception Handling");
        System.out.println("=====================================\n");

        try {
            // Valid Bogie
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Bogie created: " + b1.type + " -> " + b1.capacity);

            // Invalid Bogie (will throw exception)
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);
            System.out.println("Bogie created: " + b2.type + " -> " + b2.capacity);

        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\nUC14 execution completed...");
    }
}