import java.util.*;

public class EdmondsKarp {

    public static int maxFlow(FlowNetwork net, int source, int sink) {
        int flow = 0;
        int iteration = 1;
        int pathsFound = 0;

        while (true) {
            System.out.println("\n=====================");
            System.out.println("Iteration " + iteration++);

            int[] parent = new int[net.n];
            Arrays.fill(parent, -1);
            Edge[] pathEdge = new Edge[net.n];

            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            parent[source] = source;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (Edge e : net.getEdges(current)) {
                    int next = e.getTo();
                    if (parent[next] == -1 && e.residualCapacity() > 0) {
                        parent[next] = current;
                        pathEdge[next] = e;
                        queue.add(next);
                    }
                }
            }

            if (parent[sink] == -1) {
                System.out.println("No more augmenting paths found. Exiting.");
                break;
            }

            // Path found
            pathsFound++;

            // Find bottleneck
            int bottleneck = Integer.MAX_VALUE;
            int v = sink;
            while (v != source) {
                bottleneck = Math.min(bottleneck, pathEdge[v].residualCapacity());
                v = parent[v];
            }

            System.out.println("Path Found! Bottleneck Capacity: " + bottleneck);

            // Push flow
            v = sink;
            while (v != source) {
                pathEdge[v].addFlow(bottleneck);
                v = parent[v];
            }

            flow += bottleneck;
            System.out.println(" Flow pushed: " + bottleneck + " units. Total Flow Now: " + flow);
        }

        System.out.println("\n=====================");
        System.out.println("Total Paths Found: " + pathsFound);
        return flow;
    }
}
