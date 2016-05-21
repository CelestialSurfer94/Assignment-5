import java.util.*;

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 */
public class MyGraph implements Graph {
	private static final int HASH_CONST = 4973;
	private Edge[] hashTable;
	private Map<Vertex, Set<Edge>> pairings;
	// you will need some private fields to represent the graph
	// you are also likely to want some private helper methods

	//TODO YOUR CODE HERE

	/**
	 * Creates a MyGraph object with the given collection of vertices
	 * and the given collection of edges.
	 * @param v a collection of the vertices in this graph
	 * @param e a collection of the edges in this graph
	 */
	public MyGraph(Collection<Vertex> v, Collection<Edge> e) {
		pairings = new HashMap<Vertex, Set<Edge>>();
		for (Vertex vert : v) {
			pairings.put(v, null);
		}
		hashTable = new Edge[HASH_CONST];
		for (Edge edg : e) {
			boolean duplicateWithWrongWeight = pairings.containsKey(edg.from) &&
					pairings.get(edg.from).contains(edg);
			if ((!pairings.containsKey(edg.from) || !pairings.containsKey(edg.to))
					|| (edg.weight < 0) || ) {
				throw new IllegalOperationException();
			}
			hashTable[edg.hashCode()] = edg;
			Vertex vert = e.from;
			if (pairings.get(vert) == null) {
				pairings.get(vert) = new HashSet<Edge>();
			}
			pairings.get(vert).add(edg);
		}

	}

	/** 
	 * Return the collection of vertices of this graph
	 * @return the vertices as a collection (which is anything iterable)
	 */
	public Collection<Vertex> vertices() {
		//TODO YOUR CODE HERE
	}

	/** 
	 * Return the collection of edges of this graph
	 * @return the edges as a collection (which is anything iterable)
	 */
	public Collection<Edge> edges() {
		//TODO YOUR CODE HERE
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

		//TODO YOUR CODE HERE
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

		//TODO YOUR CODE HERE
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
	}

}
