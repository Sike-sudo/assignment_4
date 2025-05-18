public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge("Almaty", "Nur-Sultan", 1200);
        graph.addEdge("Almaty", "Shymkent", 900);
        graph.addEdge("Nur-Sultan", "Karaganda", 200);
        graph.addEdge("Shymkent", "Taraz", 300);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        System.out.println("BFS path from Almaty to Taraz: " + bfs.pathTo("Taraz"));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "Almaty");
        System.out.println("Shortest path from Almaty to Karaganda: " + dijkstra.pathTo("Karaganda"));
    }
}
