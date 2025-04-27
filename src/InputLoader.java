import java.io.*;

public class InputLoader {

    public static FlowNetwork loadNetworkFromInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FlowNetwork network = null;

        while (network == null) {
            try {
                System.out.println("\nPlease place your input file inside the 'input' folder.");
                System.out.print("Enter input file name (with extension like 'graph1.txt'): ");
                String filename = reader.readLine();

                BufferedReader br = new BufferedReader(new FileReader("input/" + filename));
                int n = Integer.parseInt(br.readLine().trim());

                network = new FlowNetwork(n);

                String line;
                while ((line = br.readLine()) != null && !line.isEmpty()) {
                    String[] parts = line.trim().split("\\s+");
                    int from = Integer.parseInt(parts[0]);
                    int to = Integer.parseInt(parts[1]);
                    int capacity = Integer.parseInt(parts[2]);
                    network.addEdge(from, to, capacity);
                }
                br.close();
                System.out.println("✅ File loaded successfully!");

            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
                System.out.println("Please try again with a valid file.");
            }
        }

        return network;
    }
}
