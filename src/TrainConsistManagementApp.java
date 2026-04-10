import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   UC17 - Sort Bogie Names");
        System.out.println("=====================================\n");

        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogies:");
        System.out.println(Arrays.toString(bogies));

        Arrays.sort(bogies);

        System.out.println("\nSorted Bogies:");
        System.out.println(Arrays.toString(bogies));

        System.out.println("\nUC17 completed...");
    }
}
