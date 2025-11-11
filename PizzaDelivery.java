import java.util.*;

class Graph {
    private int vertices;
    private int[][] adjMatrix; // adjacency matrix to store travel times

    public Graph(int v) {
        vertices = v;
        adjMatrix = new int[v][v];
    }

    // Add connection between locations with travel time
    public void addEdge(int src, int dest, int time) {
        adjMatrix[src][dest] = time;
        adjMatrix[dest][src] = time; // undirected graph
    }

    // Dijkstra's algorithm
    public void dijkstra(int start) {
        int[] distance = new int[vertices];  // shortest distance from source
        boolean[] visited = new boolean[vertices];  // visited locations

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int u = findMinDistance(distance, visited);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0 &&
                    distance[u] + adjMatrix[u][v] < distance[v]) {
                    distance[v] = distance[u] + adjMatrix[u][v];
                }
            }
        }

        display(distance, start);
    }

    // Find the vertex with the minimum distance
    private int findMinDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && distance[v] < min) {
                min = distance[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Display results
    private void display(int[] distance, int start) {
        System.out.println("\nMinimum time from location " + (char)(start + 'A') + " to others:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To " + (char)(i + 'A') + " -> " + distance[i] + " mins");
        }
    }
}

public class PizzaDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of locations: ");
        int n = sc.nextInt();
        Graph g = new Graph(n);

        System.out.print("Enter number of routes: ");
        int e = sc.nextInt();

        System.out.println("Enter routes (src dest time) as numbers (e.g. 0 1 10 means A-B takes 10 mins):");
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int time = sc.nextInt();
            g.addEdge(src, dest, time);
        }

        System.out.print("Enter starting location (0 for A, 1 for B, etc.): ");
        int start = sc.nextInt();

        g.dijkstra(start);
        sc.close();
    }
}
