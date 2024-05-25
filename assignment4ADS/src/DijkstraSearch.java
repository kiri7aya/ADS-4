import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distTo;
    private final PriorityQueue<Vertex<V>> pq;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(graph.getVertex(source));
        distTo = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparingDouble(distTo::get));
        distTo.put(this.source, 0.0);
        pq.add(this.source);
        dijkstra(graph);
    }

    private void dijkstra(WeightedGraph<V> graph) {
        while (!pq.isEmpty()) {
            Vertex<V> v = pq.poll();
            for (Map.Entry<Vertex<V>, Double> entry : v.getAdjacentVertices().entrySet()) {
                Vertex<V> w = entry.getKey();
                double weight = entry.getValue();
                double newDist = distTo.get(v) + weight;
                if (newDist < distTo.getOrDefault(w, Double.MAX_VALUE)) {
                    distTo.put(w, newDist);
                    edgeTo.put(w, v);
                    pq.add(w);
                    marked.add(w);
                }
            }
        }
    }
}