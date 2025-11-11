import java.util.*;

public class GraphTraversal {
    private int vertices;                   // Number of vertices
    private int[][] adjMatrix;              // For DFS
    private LinkedList<Integer>[] adjList;  // For BFS

    // Constructor
    public GraphTraversal(int v) {
        vertices = v;
        adjMatrix = new int[v][v];
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add edge (for both matrix and list)
    public void addEdge(int src, int dest) {
        // For adjacency matrix (undirected)
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;

        // For adjacency list (undirected)
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    // 1️⃣ DFS using adjacency matrix
    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal (Adjacency Matrix): ");
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print((char) (v + 'A') + " "); // Convert 0→A, 1→B, etc.

        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[v][i] == 1 && !visited[i]) {
                dfsRecursive(i, visited);
            }
        }
    }

    // 2️⃣ BFS using adjacency list
    public void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal (Adjacency List): ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print((char) (node + 'A') + " ");

            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Display adjacency matrix
    public void displayMatrix() {
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Display adjacency list
    public void displayList() {
        System.out.println("\nAdjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print((char) (i + 'A') + " -> ");
            for (int neighbor : adjList[i]) {
                System.out.print((char) (neighbor + 'A') + " ");
            }
            System.out.println();
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of locations (nodes): ");
        int n = sc.nextInt();
        GraphTraversal g = new GraphTraversal(n);

        System.out.print("Enter number of routes (edges): ");
        int e = sc.nextInt();

        System.out.println("Enter connections (e.g., 0 1 for A-B):");
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            g.addEdge(src, dest);
        }

        g.displayMatrix();
        g.displayList();

        System.out.print("\nEnter starting location (0 for A, 1 for B, etc.): ");
        int start = sc.nextInt();

        g.DFS(start);
        g.BFS(start);

        sc.close();
    }
}
