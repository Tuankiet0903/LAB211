
import java.util.Random;
import java.util.Scanner;

public class LinearSearch {

    private static Scanner sc = new Scanner(System.in);

    private static void randomArrGenerate(int arr[], int maxValue) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(maxValue) + 1;
        }
    }

    private static void printArray(int arr[], String msg) {
        System.out.print(msg);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int getUserNumber(String msg) {
        System.out.print(msg + " ");
        return sc.nextInt();
    }

    private static int search(int[] arr, int index) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == index)
                return i;
        }
        return -1;

    }

    public static void main(String[] args) {

        int arrLength = getUserNumber("Enter number of array: ");
        int searchNumber = getUserNumber("Enter search values: ");
        int arr[] = new int[arrLength];
        randomArrGenerate(arr, 10);
        printArray(arr, "The array: ");
        int result = search(arr, searchNumber);
        if (result == -1) {
            System.out.println("\nNot found!");
        } else
            System.out.println("\nFound" + searchNumber + " at index: " + result);

    }
}
