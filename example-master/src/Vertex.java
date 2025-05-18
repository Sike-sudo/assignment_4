import java.util.*;

public class Vertex<V> {
    private final V data;
    private final Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public void addAdjacentVertex(Vertex<V> dest, double weight) {
        adjacentVertices.put(dest, weight);
    }

    public Set<Vertex<V>> getAdjacentVertices() {
        return adjacentVertices.keySet();
    }

    public Map<Vertex<V>, Double> getAdjacentWithWeights() {
        return adjacentVertices;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vertex)) return false;
        Vertex<?> other = (Vertex<?>) obj;
        return Objects.equals(data, other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
