import java.util.Scanner;

public class Validation {

    private final Scanner scanner;

    public Validation() {
        scanner = new Scanner(System.in);
    }

    public int[] validateInput() {
        boolean valid = false;
        int[] garbageAmounts = null;
        while (!valid) {
            System.out.print("Enter the amount of garbage at each station (kg): ");
            String input = scanner.nextLine().trim();
            String[] strArr = input.split("\\s+");
            garbageAmounts = new int[strArr.length];
            valid = true;
            for (int i = 0; i < strArr.length; i++) {
                try {
                    int num = Integer.parseInt(strArr[i]);
                    if (num <= 0) {
                        System.out.println("Invalid input: " + num + ", input must be greater than 0.");
                        valid = false;
                        break;
                    }
                    garbageAmounts[i] = num;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + strArr[i] + ", input must be an integer.");
                    valid = false;
                    break;
                }
            }
        }
        return garbageAmounts;
    }
}
