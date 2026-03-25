import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Initialize train consist
        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train consist initialized.");

        // Add passenger bogies
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("Passenger bogies added.");

        // Display updated consist
        System.out.println("Total bogie count: " + trainConsist.size());

        System.out.println("Train Consist:");
        for (String bogie : trainConsist) {
            System.out.println(bogie);
        }
    }
}