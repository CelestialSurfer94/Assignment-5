import java.util.*;

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 */
public class MyGraph implements Graph {
    private static final int HASH_CONST = 4973; // Size of adj list
    private Map<Vertex, Set<Edge>> adjMap;
    private Vertex[] vertexHash;

    public MyGraph(Collection<Vertex> vertices, Collection<Edge> edges) {
        adjMap = new HashMap<Vertex, Set<Edge>>();
        vertexHash = new Vertex[HASH_CONST];

        // Hash each vertex parameter and add to adjMap
        for (Vertex v : vertices) {
            adjMap.put(v, new HashSet<Edge>());
            vertexHash[v.hashCode()] = v;
        }

        // Check each possible edge for exceptions
        for (Edge possibleEdge : edges) {
            Vertex from = possibleEdge.getSource();
            Vertex to = possibleEdge.getDestination();

            // Ensure destination and source vertices are in graph and weight is not negative
            if (vertexHash[from.hashCode()] == null || vertexHash[to.hashCode()] == null ||
                    possibleEdge.getWeight() < 0) {
                throw new IllegalArgumentException("Please check your parameters");
            }

            // Ensure edge is not redundant with same weight.
            for (Edge graphEdge : adjMap.get(from)) {
                boolean sameSource = graphEdge.getSource().equals(possibleEdge.getSource());
                boolean sameDestination = graphEdge.getDestination().equals(possibleEdge.getDestination());
                boolean differentWeight = graphEdge.getWeight() != possibleEdge.getWeight();

                if (sameSource && sameDestination && differentWeight) {
                    throw new IllegalArgumentException("Redundant edge detected");
                }
            }

            // Edge passed all checks; add to adjMap
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
    public Collection<Vertex> adjacentVertices(Vertex v) { //potential problem here. What about edges coming back into a node?
        if(vertexHash[v.hashCode()] == null){
            throw new IllegalArgumentException();
        }
        Set<Vertex> adjVert = new HashSet<Vertex>();
        Iterator<Edge> itr = adjMap.get(v).iterator(); //set of edges for vertex v.
        while(itr.hasNext()) {
            Edge curEdge = itr.next();
            adjVert.add(curEdge.getDestination()); // adds the destination nodes from vertex v, through current edge.
        }
        return adjVert;
    }

    public Set<Edge> vertexEdges(Vertex a){ //returns the set of edges for a given vertex.
        return adjMap.get(a);
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
        if(vertexHash[a.hashCode()] == null || vertexHash[b.hashCode()] == null){ // the vertices do not exist.
            throw new IllegalArgumentException("Vertices must be in the graph.");
        }
        Set<Edge> edges = vertexEdges(a); //all of the edges for the vertex.
        Iterator<Edge> itr = edges.iterator();
        while(itr.hasNext()){
            Edge curEdge = itr.next();
            if(curEdge.getDestination() == b){ //if the destination is equal to b, found the correct edge return weight.
                return curEdge.getWeight();
            }
        }
        return -1; //edge from a to b does not exist.
    }

    /**
     * Returns the shortest path from a to b in the graph, or null if there is
     * no such path.  Assumes all edge weights are nonnegative.
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
            throw new IllegalArgumentException();
        }
        Vertex current = a;
        current.setDistance(0);
        Queue<Vertex> queue = new PriorityQueue<Vertex>();
        queue.addAll(vertices());
        while (!queue.isEmpty()) {
            Vertex minAdjac = closestUnknownNeighbor(current); //returns the lowest cost vertex, changes the distance of that node, marks it as known.
            current = queue.remove();
        }

        return null;
    }

    private Vertex closestUnknownNeighbor(Vertex v) {
        int lowestCost = Integer.MAX_VALUE;
        Vertex closestUnknownNeighbor = null;
        for (Vertex neighbor : adjacentVertices(v)) { //iterates through the adjacent vertices, MARKING EVERY NODE DISTANCE ALONG THE WAY! EVEN IF UNKNOWN.
            int currentCost = edgeCost(v,neighbor) + v.getDistance(); //edge cost + the existing distance.
            if(currentCost < neighbor.getDistance()){ // current cost < the neighbors current cost, change neighbor BUT DONT MAKE CLOSEST UNKNOWN.
                neighbor.setDistance(currentCost);
            }

            if(currentCost < lowestCost){ //finds the lowest of the adjacent. returns that shit.
                closestUnknownNeighbor = neighbor;
                lowestCost = neighbor.getDistance();
            }
        }
        return closestUnknownNeighbor;
    }
}