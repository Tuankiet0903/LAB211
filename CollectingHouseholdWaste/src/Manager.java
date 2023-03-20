import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Manager {
    int[] rand = new int[12];

    public final int MAX_CAPACITY = 10000; // kg
    public final double LOAD_TIME = 8; // minutes
    public final double DUMP_TIME = 30; // minutes
    public final double LABOR_COST = 120000; // VND/hour
    public final double DUMP_COST = 57000; // VND/truck
    NumberFormat formatter1 = new DecimalFormat("#,###,###");

    public double calculateCost(int[] garbageAmounts) {
        double totalTime = 0;
        int totalGarbage = 0;
        int tripsToDump = 0;

        for (int i = 0; i < garbageAmounts.length; i++) {
            // If there is not enough space in the truck, dump the garbage
            if (totalGarbage + garbageAmounts[i] > MAX_CAPACITY) {
                tripsToDump++;
                totalTime += DUMP_TIME;
                totalGarbage = 0;
            }

            // Load the garbage onto the truck
            totalGarbage += garbageAmounts[i];
            totalTime += LOAD_TIME;
        }

        // If there is any remaining garbage, dump it
        if (totalGarbage > 0) {
            tripsToDump++;
            totalTime += DUMP_TIME;
        }

        double dumpCost = tripsToDump * DUMP_COST;
        double laborAndTransportCost = (totalTime / 60) * LABOR_COST;
        double totalCost = laborAndTransportCost + dumpCost;

        return totalCost;

    }

    public void format(double totalCost) {
        String formattedNumber1 = formatter1.format(totalCost);
        System.out.println("The total cost is " + formattedNumber1 + " VND");

    }
}
