import java.util.*;

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 * @author Evan Gordon
 * @author Kalvin Suting
 */
public class MyGraph implements Graph {
    private static final int HASH_CONST = 9000000; // Size of adj list.
    private Map<Vertex, Set<Edge>> adjMap; // Mapping of Vertices to their corresponding Edges.
    private Vertex[] vertexHash; // Hash table of all Vertices in graph.

    public MyGraph(Collection<Vertex> vertices, Collection<Edge> edges) {
        adjMap = new HashMap<Vertex, Set<Edge>>();
        vertexHash = new Vertex[HASH_CONST];

        // Hash each vertex parameter and add to adjMap.
        for (Vertex v : vertices) {
            vertexHash[v.hashCode()] = v;
            adjMap.put(vertexHash[v.hashCode()], new HashSet<Edge>());
        }

        // Check each possible edge for exceptions.
        for (Edge possibleEdge : edges) {
            Vertex from = vertexHash[possibleEdge.getSource().hashCode()];
            Vertex to = vertexHash[possibleEdge.getDestination().hashCode()];

            // Ensure destination and source vertices are in graph and weight is not negative.
            if (to == null || from == null || possibleEdge.getWeight() < 0) {
                throw new IllegalArgumentException("Invalid edge detected.");
            }

            // Ensure edge is not redundant with same weight.
            for (Edge graphEdge : adjMap.get(from)) {
                boolean sameSource = graphEdge.getSource().equals(possibleEdge.getSource());
                boolean sameDestination = graphEdge.getDestination().equals(possibleEdge.getDestination());
                boolean differentWeight = graphEdge.getWeight() != possibleEdge.getWeight();

                if (sameSource && sameDestination && differentWeight) {
                    throw new IllegalArgumentException("Redundant edge detected.");
                }
            }

            // Edge passed all checks; add to adjMap.
            adjMap.get(from).add(possibleEdge);
        }
    }

    /**
     * Return the collection of vertices of this graph
     * @return the vertices as a collection (which is anything iterable)
     */
    public Collection<Vertex> vertices() {
        return adjMap.keySet();
    }

    /**
     * Return the collection of edges of this graph
     * @return the edges as a collection (which is anything iterable)
     */
    public Collection<Edge> edges() {
        Set<Edge> edges = new HashSet<Edge>();
        for (Set<Edge> s : adjMap.values()) {
            edges.addAll(s);
        }
        return edges;
    }

    /**
     * Return a collection of vertices adjacent to a given vertex v.
     *   i.e., the set of all vertices w where edges v -> w exist in the graph.
     * Return an empty collection if there are no adjacent vertices.
     * @param v one of the vertices in the graph
     * @return an iterable collection of vertices adjacent to v in the graph
     * @throws IllegalArgumentException if v does not exist.
     */
    public Collection<Vertex> adjacentVertices(Vertex v) {
        if(vertexHash[v.hashCode()] == null){
            throw new IllegalArgumentException();
        }
        Set<Vertex> adjVert = new HashSet<Vertex>();
        Iterator<Edge> itr = adjMap.get(vertexHash[v.hashCode()]).iterator(); //set of edges for vertex v.
        while(itr.hasNext()) {
            Edge curEdge = itr.next();
            adjVert.add(vertexHash[curEdge.getDestination().hashCode()]); // adds the destination nodes from vertex v, through currentSource edge.
        }
        return adjVert;
    }

    /**
     *
     * @param a the vertex that this method will find edges for.
     * @return returns the edges out of vertex a.
     */
    public Set<Edge> vertexEdges(Vertex a){
        return adjMap.get(vertexHash[a.hashCode()]);
    }

    /**
     * Test whether vertex b is adjacent to vertex a (i.e. a -> b) in a directed graph.
     * Assumes that we do not have negative cost edges in the graph.
     * @param a one vertex
     * @param b another vertex
     * @return cost of edge if there is a directed edge from a to b in the graph,
     * return -1 otherwise.
     * @throws IllegalArgumentException if a or b do not exist.
     */
    public int edgeCost(Vertex a, Vertex b) {
        if(vertexHash[a.hashCode()] == null || vertexHash[b.hashCode()] == null){
            throw new IllegalArgumentException("Vertices must be in the graph.");
        }
        Vertex from = vertexHash[a.hashCode()];
        Vertex to = vertexHash[b.hashCode()];

        // Search each edge for desired destination.
        for (Edge e : adjMap.get(from)) {
            if (e.getSource().equals(to)) {
                return e.getWeight();
            }
        }

        // Desired destination not adjacent to desired source.
        return -1;
    }

    /**
     * Returns the shortest path from a to b in the graph, or null if there is
     * no such path.  Assumes all edge weights are non-negative.
     * Uses Dijkstra's algorithm.
     * @param a the starting vertex
     * @param b the destination vertex
     * @return a Path where the vertices indicate the path from a to b in order
     *   and contains a (first) and b (last) and the cost is the cost of
     *   the path. Returns null if b is not reachable from a.
     * @throws IllegalArgumentException if a or b does not exist.
     */
    public Path shortestPath(Vertex a, Vertex b) {
        if (vertexHash[a.hashCode()] == null || vertexHash[b.hashCode()] == null) {
            throw new IllegalArgumentException("Node does not exist.");
        }

    }

}