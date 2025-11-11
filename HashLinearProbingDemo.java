import java.util.*;

class HashTableLinearProbing {
    private final int SIZE = 10;
    private int[] table;
    private final int EMPTY = -1;     // Empty slot
    private final int DELETED = -2;   // Deleted marker

    public HashTableLinearProbing() {
        table = new int[SIZE];
        Arrays.fill(table, EMPTY);
    }

    // Division method
    private int hashFunction(int key) {
        return key % SIZE;
    }

    // 1️⃣ Insert key
    public void insert(int key) {
        int index = hashFunction(key);
        int startIndex = index;

        while (table[index] != EMPTY && table[index] != DELETED) {
            index = (index + 1) % SIZE;
            if (index == startIndex) {
                System.out.println("Hash table is full! Cannot insert.");
                return;
            }
        }
        table[index] = key;
        System.out.println("Inserted key " + key + " at index " + index);
    }

    // 2️⃣ Search key
    public boolean search(int key) {
        int index = hashFunction(key);
        int startIndex = index;

        while (table[index] != EMPTY) {
            if (table[index] == key)
                return true;
            index = (index + 1) % SIZE;
            if (index == startIndex)
                break;
        }
        return false;
    }

    // 3️⃣ Delete key
    public void delete(int key) {
        int index = hashFunction(key);
        int startIndex = index;

        while (table[index] != EMPTY) {
            if (table[index] == key) {
                table[index] = DELETED;
                System.out.println("Deleted key " + key + " from index " + index);
                return;
            }
            index = (index + 1) % SIZE;
            if (index == startIndex)
                break;
        }
        System.out.println("Key " + key + " not found!");
    }

    // 4️⃣ Display table
    public void display() {
        System.out.println("\n--- Hash Table Contents ---");
        for (int i = 0; i < SIZE; i++) {
            if (table[i] == EMPTY)
                System.out.println("Index " + i + ": [Empty]");
            else if (table[i] == DELETED)
                System.out.println("Index " + i + ": [Deleted]");
            else
                System.out.println("Index " + i + ": " + table[i]);
        }
    }
}

public class HashLinearProbingDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTableLinearProbing ht = new HashTableLinearProbing();
        int choice;

        do {
            System.out.println("\n--- HASH TABLE MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display Table");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key (integer): ");
                    int key = sc.nextInt();
                    ht.insert(key);
                    break;
                case 2:
                    System.out.print("Enter key to search: ");
                    int sKey = sc.nextInt();
                    if (ht.search(sKey))
                        System.out.println("Key " + sKey + " found in table!");
                    else
                        System.out.println("Key " + sKey + " not found!");
                    break;
                case 3:
                    System.out.print("Enter key to delete: ");
                    int dKey = sc.nextInt();
                    ht.delete(dKey);
                    break;
                case 4:
                    ht.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
