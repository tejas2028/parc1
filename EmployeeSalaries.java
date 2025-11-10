import java.util.*;

public class EmployeeSalaries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        double[] salaries = new double[n];

        System.out.println("Enter salaries of employees:");
        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextDouble();
        }

        // Create copies so both algorithms use same data
        double[] selectionSorted = Arrays.copyOf(salaries, n);
        double[] bubbleSorted = Arrays.copyOf(salaries, n);

        // 1️⃣ Selection Sort
        selectionSort(selectionSorted);
        System.out.println("\nSalaries after Selection Sort (Ascending):");
        printArray(selectionSorted);

        // 2️⃣ Bubble Sort
        bubbleSort(bubbleSorted);
        System.out.println("\nSalaries after Bubble Sort (Ascending):");
        printArray(bubbleSorted);

        // 3️⃣ Display top 5 highest salaries
        System.out.println("\nTop 5 Highest Salaries:");
        displayTopFive(selectionSorted);

        sc.close();
    }

    // Selection Sort Algorithm
    public static void selectionSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            // swap
            double temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Bubble Sort Algorithm
    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Print array
    public static void printArray(double[] arr) {
        for (double val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Display top 5 highest salaries
    public static void displayTopFive(double[] arr) {
        int count = Math.min(5, arr.length);
        System.out.println("Highest " + count + " salaries are:");
        for (int i = arr.length - 1; i >= arr.length - count; i--) {
            System.out.println(arr[i]);
        }
    }
}
