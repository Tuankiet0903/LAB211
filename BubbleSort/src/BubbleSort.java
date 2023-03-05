import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] numbers = new int[10];
        int a;
        do {
            System.out.println("input number of array: ");
            a = sc.nextInt();
        } while (a < 0);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(a) + 1;
        }

        System.out.println("Before:");
        printArray(numbers);

        // Sorting algorithm here
        boolean Swapped = true;

        while (Swapped) {
            Swapped = false;

            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    Swapped = true;
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
        }

        System.out.println("\nAfter:");
        printArray(numbers);
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}