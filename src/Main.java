public class Main {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("  Welcome to Max Flow Problem Solver!");
        System.out.println("=======================================");

        FlowNetwork network = InputLoader.loadNetworkFromInput();

        int source = 0;
        int sink = network.n - 1;

        long startTime = System.nanoTime();
        int maxFlow = EdmondsKarp.maxFlow(network, source, sink);
        long endTime = System.nanoTime();

        System.out.println("\nFinal Maximum Flow: " + maxFlow);
        System.out.println("Time Taken: " + ((endTime - startTime) / 1e6) + " ms");

        System.out.println("\n🔁 Final Edge Flows:");
        for (int i = 0; i < network.n; i++) {
            for (Edge e : network.getEdges(i)) {
                if (e.getCapacity() > 0) {
                    System.out.println(e);
                }
            }
        }

        System.out.println("\nThank you for using MaxFlowProblem Solver!");
    }
}
