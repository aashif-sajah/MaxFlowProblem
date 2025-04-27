import java.util.*;

public class FlowNetwork {
    int n;
    ArrayList<Edge>[] graph;

    public FlowNetwork(int n) {
        this.n = n;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to, int capacity) {
        Edge forward = new Edge(from, to, capacity);
        Edge backward = new Edge(to, from, 0);

        forward.setReverse(backward);
        backward.setReverse(forward);

        graph[from].add(forward);
        graph[to].add(backward);
    }

    public List<Edge> getEdges(int node) {
        return graph[node];
    }
}
