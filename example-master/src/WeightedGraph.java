import java.util.*;

public class WeightedGraph<V> {
    private final Map<V, Vertex<V>> vertices = new HashMap<>();
    private final boolean directed;

    public WeightedGraph() {
        this(false);
    }

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public Vertex<V> addVertex(V value) {
        vertices.putIfAbsent(value, new Vertex<>(value));
        return vertices.get(value);
    }

    public void addEdge(V from, V to, double weight) {
        Vertex<V> vFrom = vertices.computeIfAbsent(from, Vertex::new);
        Vertex<V> vTo   = vertices.computeIfAbsent(to,   Vertex::new);
        vFrom.addAdjacentVertex(vTo, weight);
        if (!directed) {
            vTo.addAdjacentVertex(vFrom, weight);
        }
    }

    public Vertex<V> getVertex(V value) {
        return vertices.get(value);
    }

    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }
}
