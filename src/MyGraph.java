import java.util.*;

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 */
public class MyGraph implements Graph {
    private static final int HASH_CONST = 4973; // Size of adj list
    private Vertex[] vertices;
    private Map<Vertex, Set<Edge>> adjList;


    public MyGraph(Collection<Vertex> vertexes, Collection<Edge> edges) {
        Iterator<Vertex> vertexIterator = vertexes.iterator();
        while(vertexIterator.hasNext()) { // iterates through vertices, adds each vertex to hashTable
            Vertex curVertex = vertexIterator.next();
            vertices[curVertex.hashCode()] = curVertex; //***have to leave local variable here.***
        }

        Iterator<Edge> edgeIterator = edges.iterator();
        while(edgeIterator.hasNext()){  //iterates through and adds valid edges to the adjacency list.
            Edge curEdge = edgeIterator.next();
            int sourceVal  = curEdge.getSource().hashCode(); // hashcode of the source vertex we are looking at.
            int destinationVal = curEdge.getDestination().hashCode();//hashCode of the dest. val.
            if (curEdge.getWeight() < 0 ||vertices[sourceVal] == null //checks weights, and whether the vertex exists.
                    || vertices[destinationVal] == null){
                throw new IllegalStateException("Weight must be >= 0 and vertices must exist in graph.");
            }

            if(adjList.get(vertices[sourceVal]) == null){ // source vertex needs new set.
                adjList.put(curEdge.getSource(),new HashSet<Edge>()); //initializes the set for source vertex.
            }
            if(adjList.get(vertices[destinationVal]) ==  null){ //dest. vertex needs new set.
                adjList.put(curEdge.getDestination(),new HashSet<Edge>());//initializes the set for the destination vertex.
            }

            Iterator<Edge> setIterator = adjList.get(curEdge).iterator();
            while(setIterator.hasNext()){
                Edge test  = setIterator.next();
                if(test.getDestination() == curEdge.getDestination() && test.getSource() ==
                        curEdge.getSource() && test.getWeight() != curEdge.getWeight()){
                    throw new IllegalStateException("Edges must be unique.");
                }
            }
            adjList.get(curEdge.getSource()).add(curEdge); //adds the edge to the set of edges for source vertex.
            adjList.get(curEdge.getDestination()).add(curEdge); //adds the edge to the set of edges for the dest. vertex.
        }
    }

    /**
     * Return the collection of vertices of this graph
     * @return the vertices as a collection (which is anything iterable)
     */
    public Collection<Vertex> vertices() {
        return adjList.keySet();
    }

    /**
     * Return the collection of edges of this graph
     * @return the edges as a collection (which is anything iterable)
     */
    public Collection<Edge> edges() {
        return null;
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
        if(vertices[v.hashCode()] == null){
            throw new IllegalArgumentException();
        }
        Set adjVert = new HashSet<>();
        Iterator<Edge> itr = adjList.get(v).iterator(); //set of edges for vertex v.
        while(itr.hasNext()){
            Edge curEdge = itr.next();
            adjVert.add(curEdge.getDestination()); // adds the destination nodes from vertex v, through current edge.
        }
        return adjVert;
    }

    public Set<Edge> vertexEdges(Vertex a){ //returns the set of edges for a given vertex.
        return adjList.get(a);
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
        if(vertices[a.hashCode()] == null || vertices[b.hashCode()] == null){ // the vertices do not exist.
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

        //TODO YOUR CODE HERE (you might comment this out this method while doing Part 1)
        return null;
    }

}