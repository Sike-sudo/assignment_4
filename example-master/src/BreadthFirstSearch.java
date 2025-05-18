import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    public BreadthFirstSearch(WeightedGraph<V> graph, V startValue) {
        super(graph);
        search(startValue);
    }

    @Override
    protected void initialize(Vertex<V> start) {
        for (Vertex<V> v : graph.getVertices()) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);
    }

    @Override
    protected void execute(Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex<V> u = queue.poll();
            for (Vertex<V> nbr : u.getAdjacentVertices()) {
                if (distances.get(nbr).equals(Double.POSITIVE_INFINITY)) {
                    distances.put(nbr, distances.get(u) + 1);
                    predecessors.put(nbr, u);
                    queue.add(nbr);
                }
            }
        }
    }
}
