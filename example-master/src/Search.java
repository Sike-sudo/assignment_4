import java.util.*;

public abstract class Search<V> {
    protected final WeightedGraph<V> graph;
    protected Map<Vertex<V>, Double> distances;
    protected Map<Vertex<V>, Vertex<V>> predecessors;

    public Search(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public void search(V startValue) {
        Vertex<V> start = graph.getVertex(startValue);
        if (start == null) {
            throw new IllegalArgumentException("Vertex not found: " + startValue);
        }
        distances    = new HashMap<>();
        predecessors = new HashMap<>();
        initialize(start);
        execute(start);
    }

    protected abstract void initialize(Vertex<V> start);

    protected abstract void execute(Vertex<V> start);

    public double getDistance(V endValue) {
        Vertex<V> end = graph.getVertex(endValue);
        if (end == null) {
            throw new IllegalArgumentException("Vertex not found: " + endValue);
        }
        return distances.getOrDefault(end, Double.POSITIVE_INFINITY);
    }

    protected List<V> getPath(V endValue) {
        Vertex<V> end = graph.getVertex(endValue);
        if (end == null) {
            throw new IllegalArgumentException("Vertex not found: " + endValue);
        }
        List<V> path = new ArrayList<>();
        if (!distances.containsKey(end) ||
                distances.get(end).equals(Double.POSITIVE_INFINITY)) {
            return path;
        }
        for (Vertex<V> at = end; at != null; at = predecessors.get(at)) {
            path.add(at.getData());
        }
        Collections.reverse(path);
        return path;
    }

    public List<V> pathTo(V endValue) {
        return getPath(endValue);
    }
}
