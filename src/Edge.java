public class Edge {
    private int from;
    private int to;
    private int capacity;
    private int flow;
    private Edge reverse;

    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    public int residualCapacity() {
        return capacity - flow;
    }

    public void addFlow(int flowAmount) {
        this.flow += flowAmount;
        this.reverse.flow -= flowAmount;
    }

    public void setReverse(Edge reverse) {
        this.reverse = reverse;
    }

    public int getFrom() { return from; }
    public int getTo() { return to; }
    public int getCapacity() { return capacity; }
    public int getFlow() { return flow; }

    @Override
    public String toString() {
        return from + " → " + to + " | Flow: " + flow + "/" + capacity;
    }
}
