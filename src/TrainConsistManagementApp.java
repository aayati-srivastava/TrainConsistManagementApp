import java.util.*;

public class TrainConsistManagementApp {

    // Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .toList();
    }

    // Measure loop time
    public static long measureLoopTime(List<Bogie> bogies, int threshold) {
        long start = System.nanoTime();
        filterUsingLoop(bogies, threshold);
        long end = System.nanoTime();
        return end - start;
    }

    // Measure stream time
    public static long measureStreamTime(List<Bogie> bogies, int threshold) {
        long start = System.nanoTime();
        filterUsingStream(bogies, threshold);
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   UC13 - Performance Comparison");
        System.out.println("=====================================\n");

        List<Bogie> bogies = new ArrayList<>();

        // Large dataset
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", (int)(Math.random() * 100)));
        }

        long loopTime = measureLoopTime(bogies, 60);
        long streamTime = measureStreamTime(bogies, 60);

        System.out.println("Loop Time (ns): " + loopTime);
        System.out.println("Stream Time (ns): " + streamTime);

        System.out.println("\nUC13 execution completed...");
    }
}