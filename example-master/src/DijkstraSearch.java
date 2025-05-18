import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    public DijkstraSearch(WeightedGraph<V> graph) {
        super(graph);
    }

    public DijkstraSearch(WeightedGraph<V> graph, V startValue) {
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
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(
                Comparator.comparing(distances::get)
        );
        pq.add(start);
        while (!pq.isEmpty()) {
            Vertex<V> u = pq.poll();
            for (Map.Entry<Vertex<V>, Double> e : u.getAdjacentWithWeights().entrySet()) {
                Vertex<V> v = e.getKey();
                double w    = e.getValue();
                double alt  = distances.get(u) + w;
                if (alt < distances.get(v)) {
                    distances.put(v, alt);
                    predecessors.put(v, u);
                    pq.remove(v);
                    pq.add(v);
                }
            }
        }
    }
}
