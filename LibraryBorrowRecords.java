import java.util.*;

public class LibraryBorrowRecords {
    public static void main(String[] args) {
        // Sample data: book name → borrow count
        HashMap<String, Integer> borrowRecords = new HashMap<>();
        borrowRecords.put("Book A", 5);
        borrowRecords.put("Book B", 0);
        borrowRecords.put("Book C", 2);
        borrowRecords.put("Book D", 8);
        borrowRecords.put("Book E", 2);
        borrowRecords.put("Book F", 0);

        // 1️⃣ Compute Average
        double average = computeAverage(borrowRecords);
        System.out.println("Average number of books borrowed: " + average);

        // 2️⃣ Find Highest and Lowest
        String highest = findHighest(borrowRecords);
        String lowest = findLowest(borrowRecords);
        System.out.println("Book with highest borrow: " + highest);
        System.out.println("Book with lowest borrow: " + lowest);

        // 3️⃣ Count Zero Borrow
        int zeroCount = countZeroBorrow(borrowRecords);
        System.out.println("Number of members/books with 0 borrow: " + zeroCount);

        // 4️⃣ Most Frequent Borrow Count (Mode)
        int mode = findMode(borrowRecords);
        System.out.println("Most frequent borrow count (mode): " + mode);
    }

    // Compute average borrow
    public static double computeAverage(HashMap<String, Integer> records) {
        int sum = 0;
        for (int val : records.values()) {
            sum += val;
        }
        return (double) sum / records.size();
    }

    // Find book with highest borrow count
    public static String findHighest(HashMap<String, Integer> records) {
        String highestBook = "";
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : records.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                highestBook = entry.getKey();
            }
        }
        return highestBook;
    }

    // Find book with lowest borrow count
    public static String findLowest(HashMap<String, Integer> records) {
        String lowestBook = "";
        int min = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : records.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                lowestBook = entry.getKey();
            }
        }
        return lowestBook;
    }

    // Count members/books with zero borrow
    public static int countZeroBorrow(HashMap<String, Integer> records) {
        int count = 0;
        for (int val : records.values()) {
            if (val == 0)
                count++;
        }
        return count;
    }

    // Find the most frequent borrow count (Mode)
    public static int findMode(HashMap<String, Integer> records) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int val : records.values()) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }

        int mode = -1, maxFreq = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mode = entry.getKey();
            }
        }
        return mode;
    }
}
