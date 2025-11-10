import java.util.*;

public class TextEditorUndoRedo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> undoStack = new Stack<>();
        Stack<String> redoStack = new Stack<>();

        String document = ""; // initial empty document
        int choice;

        do {
            System.out.println("\n--- TEXT EDITOR ---");
            System.out.println("1. Make a Change");
            System.out.println("2. Undo Action");
            System.out.println("3. Redo Action");
            System.out.println("4. Display Document State");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear input buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter new text to add: ");
                    String newText = sc.nextLine();
                    undoStack.push(document); // store previous state before change
                    document = document + newText;
                    redoStack.clear(); // clear redo stack after new change
                    System.out.println("Change saved.");
                    break;

                case 2:
                    if (!undoStack.isEmpty()) {
                        redoStack.push(document); // save current for redo
                        document = undoStack.pop(); // restore previous state
                        System.out.println("Undo performed.");
                    } else {
                        System.out.println("Nothing to undo!");
                    }
                    break;

                case 3:
                    if (!redoStack.isEmpty()) {
                        undoStack.push(document); // save current before redo
                        document = redoStack.pop(); // reapply undone state
                        System.out.println("Redo performed.");
                    } else {
                        System.out.println("Nothing to redo!");
                    }
                    break;

                case 4:
                    System.out.println("Current Document: \"" + document + "\"");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}

