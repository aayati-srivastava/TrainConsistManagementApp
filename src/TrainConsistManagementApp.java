import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   UC18 - Linear Search Bogie ID");
        System.out.println("=====================================\n");

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        String searchId = "BG309";

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }

        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("\n\nBogie Found: " + searchId);
        } else {
            System.out.println("\n\nBogie Not Found");
        }

        System.out.println("\nUC18 completed...");
    }
}
