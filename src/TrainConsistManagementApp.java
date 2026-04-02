import java.util.regex.*;

public class TrainConsistManagementApp {

    // Method to validate Train ID
    public static boolean isValidTrainId(String trainId) {
        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Matcher matcher = trainPattern.matcher(trainId);
        return matcher.matches();
    }

    // Method to validate Cargo Code
    public static boolean isValidCargoCode(String cargoCode) {
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");
        Matcher matcher = cargoPattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   UC11 - Validate Train ID & Cargo Code");
        System.out.println("=====================================\n");

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        boolean isTrainValid = isValidTrainId(trainId);
        boolean isCargoValid = isValidCargoCode(cargoCode);

        if (isTrainValid) {
            System.out.println("Train ID is valid");
        } else {
            System.out.println("Train ID is invalid");
        }

        if (isCargoValid) {
            System.out.println("Cargo Code is valid");
        } else {
            System.out.println("Cargo Code is invalid");
        }

        System.out.println("\nUC11 validation completed...");
    }
}