import java.util.*;

class HashTable {
    private final int SIZE = 10; // fixed hash table size
    private LinkedList<Entry>[] table;

    // Entry class to store key-value pairs
    static class Entry {
        int key;
        String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function using division method
    private int hashFunction(int key) {
        return key % SIZE;
    }

    // 1️⃣ Insert key-value pair
    public void insert(int key, String value) {
        int index = hashFunction(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                entry.value = value; // update if key already exists
                return;
            }
        }
        table[index].add(new Entry(key, value));
        System.out.println("Inserted (" + key + ", " + value + ") at index " + index);
    }

    // 2️⃣ Search for a key
    public String search(int key) {
        int index = hashFunction(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    // 3️⃣ Delete a key-value pair
    public void delete(int key) {
        int index = hashFunction(key);
        Iterator<Entry> it = table[index].iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            if (entry.key == key) {
                it.remove();
                System.out.println("Deleted key " + key + " from index " + index);
                return;
            }
        }
        System.out.println("Key " + key + " not found!");
    }

    // Display the hash table
    public void display() {
        System.out.println("\n--- Hash Table Contents ---");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Index " + i + ": ");
            for (Entry entry : table[i]) {
                System.out.print(" -> (" + entry.key + ", " + entry.value + ")");
            }
            System.out.println();
        }
    }
}

public class HashTableDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTable ht = new HashTable();
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
                    sc.nextLine();
                    System.out.print("Enter value (string): ");
                    String value = sc.nextLine();
                    ht.insert(key, value);
                    break;

                case 2:
                    System.out.print("Enter key to search: ");
                    int skey = sc.nextInt();
                    String result = ht.search(skey);
                    if (result != null)
                        System.out.println("Key found! Value = " + result);
                    else
                        System.out.println("Key not found!");
                    break;

                case 3:
                    System.out.print("Enter key to delete: ");
                    int dkey = sc.nextInt();
                    ht.delete(dkey);
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
