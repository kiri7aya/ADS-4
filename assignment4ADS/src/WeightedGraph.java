import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;
    private boolean directed;

    public WeightedGraph(boolean directed) {
        this.vertices = new HashMap<>();
        this.directed = directed;
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public void addVertex(V data) {
        vertices.put(data, new Vertex<>(data));
    }

    public void addEdge(V source, V destination, double weight) {
        if (!vertices.containsKey(source)) {
            addVertex(source);
        }
        if (!vertices.containsKey(destination)) {
            addVertex(destination);
        }
        vertices.get(source).addAdjacentVertex(vertices.get(destination), weight);
        if (!directed) {
            vertices.get(destination).addAdjacentVertex(vertices.get(source), weight);
        }
    }
}