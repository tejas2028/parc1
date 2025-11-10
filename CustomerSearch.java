import java.util.*;

public class CustomerSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of customer IDs
        System.out.print("Enter number of customer account IDs: ");
        int n = sc.nextInt();

        int[] customerIDs = new int[n];

        // Input customer IDs
        System.out.println("Enter the customer account IDs:");
        for (int i = 0; i < n; i++) {
            customerIDs[i] = sc.nextInt();
        }

        System.out.print("Enter account ID to search: ");
        int key = sc.nextInt();

        // 1️⃣ Linear Search
        boolean foundLinear = linearSearch(customerIDs, key);
        if (foundLinear)
            System.out.println("Linear Search: Customer ID found.");
        else
            System.out.println("Linear Search: Customer ID not found.");

        // 2️⃣ Binary Search
        Arrays.sort(customerIDs); // Binary search needs sorted list
        boolean foundBinary = binarySearch(customerIDs, key);

        if (foundBinary)
            System.out.println("Binary Search: Customer ID found.");
        else
            System.out.println("Binary Search: Customer ID not found.");

        sc.close();
    }

    // Linear Search
    public static boolean linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return true;
        }
        return false;
    }

    // Binary Search (Iterative)
    public static boolean binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return true;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
