import java.util.Random;
import java.util.Scanner;

public class QuickSort {

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

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void sort(int[] arr, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }
        int pivot = arr[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {

            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(arr, leftPointer, rightPointer);

        }
        swap(arr, leftPointer, highIndex);

        sort(arr, lowIndex, leftPointer - 1);
        sort(arr, leftPointer + 1, highIndex);
    }

    public static void main(String[] args) {

        int arrLength = getUserNumber("Enter number of array: ");
        int arr[] = new int[arrLength];
        randomArrGenerate(arr, 10);
        printArray(arr, "Unsorted array: ");
        sort(arr, 0, arr.length - 1);
        printArray(arr, "\nSorted array: ");
    }
}