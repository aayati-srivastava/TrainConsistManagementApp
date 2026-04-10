import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   UC20 - Exception Handling in Search");
        System.out.println("=====================================\n");

        String[] bogieIds = {};

        String searchId = "BG101";

        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Bogie Found: " + searchId);
        } else {
            System.out.println("Bogie Not Found");
        }

        System.out.println("UC20 completed...");
    }
}
