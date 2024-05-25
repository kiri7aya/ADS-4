import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(graph.getVertex(source));
        bfs(graph);
    }

    private void bfs(WeightedGraph<V> graph) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        marked.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.poll();

            for (Vertex<V> w : v.getAdjacentVertices().keySet()) {
                if (!marked.contains(w)) {
                    edgeTo.put(w, v);
                    marked.add(w);
                    queue.add(w);
                }
            }
        }
    }
}