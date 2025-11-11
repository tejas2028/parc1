import java.util.*;

public class EventProcessingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> eventQueue = new LinkedList<>();
        int choice;

        do {
            System.out.println("\n--- REAL-TIME EVENT PROCESSING SYSTEM ---");
            System.out.println("1. Add an Event");
            System.out.println("2. Process Next Event");
            System.out.println("3. Display Pending Events");
            System.out.println("4. Cancel an Event");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear input buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter event name to add: ");
                    String event = sc.nextLine();
                    eventQueue.add(event);
                    System.out.println("Event \"" + event + "\" added to queue.");
                    break;

                case 2:
                    if (!eventQueue.isEmpty()) {
                        String processed = eventQueue.poll(); // removes first (oldest) event
                        System.out.println("Processed event: " + processed);
                    } else {
                        System.out.println("No events to process!");
                    }
                    break;

                case 3:
                    if (eventQueue.isEmpty()) {
                        System.out.println("No pending events.");
                    } else {
                        System.out.println("Pending Events: " + eventQueue);
                    }
                    break;

                case 4:
                    if (eventQueue.isEmpty()) {
                        System.out.println("No events to cancel!");
                    } else {
                        System.out.print("Enter event name to cancel: ");
                        String cancelEvent = sc.nextLine();
                        if (eventQueue.remove(cancelEvent)) {
                            System.out.println("Event \"" + cancelEvent + "\" canceled successfully.");
                        } else {
                            System.out.println("Event not found or already processed!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
