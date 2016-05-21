/**
 * Representation of a directed graph edge.
 */
<<<<<<< HEAD
<<<<<<< HEAD

// this is the kalvin branch.
public class Edge {
	private final Vertex from,to;
	private final int weight;
=======
=======

//this is the master.
>>>>>>> 080b6e1cc5a886259abceda66e4e5b5a017da2b3
public class Edge {
	private final Vertex from,to;
	private final int w;
>>>>>>> ce448b7792f8a6731e5928d6f83c4bf1add134c4

	/**
	 * Construct a new edge
	 * @param from start vertex
	 * @param to end vertex
	 * @param w weight of this edge
	 */

<<<<<<< HEAD
	public Edge(Vertex from, Vertex to, int weight) {
=======
    //TESTING TESTING TESTING
	public Edge(Vertex from, Vertex to, int w) {
>>>>>>> ce448b7792f8a6731e5928d6f83c4bf1add134c4
		if(from == null || to == null)
			throw new IllegalArgumentException("null");
		this.from = from;
		this.to = to;
<<<<<<< HEAD
		this.weight = weight;
=======
		this.w = w;
>>>>>>> ce448b7792f8a6731e5928d6f83c4bf1add134c4
	}

	/**
	 * Get the source vertex
	 * @return the Vertex that is the source of the edge
	 */
	public Vertex getSource() {
		return from;
	}

	/**
	 * Get the destination vertex
	 * @return the Vertex that is the destination of the edge
	 */
	public Vertex getDestination() {
		return to;
	}

	/**
	 * Get the edge weight (a.k.a. cost)
	 * @return the weight of the edge
	 */
	public int getWeight() {
<<<<<<< HEAD
		return weight;
=======
		return w;
>>>>>>> ce448b7792f8a6731e5928d6f83c4bf1add134c4
	}

	/**
	 * A string representation of this object
	 * @return A string of the form <from, to, weight>
	 */
	public String toString() {
<<<<<<< HEAD
		return "<"+from+", "+to+", "+weight+">";
=======
		return "<"+from+", "+to+", "+w+">";
>>>>>>> ce448b7792f8a6731e5928d6f83c4bf1add134c4
	}

	//auto-generated: hashes on all fields
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
<<<<<<< HEAD
		result = prime * result + weight;
=======
		result = prime * result + w;
>>>>>>> ce448b7792f8a6731e5928d6f83c4bf1add134c4
		return result;
	}

	//auto-generated: compares all fields
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Edge other = (Edge) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
<<<<<<< HEAD
		return weight==other.weight;
=======
		return w==other.w;
>>>>>>> ce448b7792f8a6731e5928d6f83c4bf1add134c4
	}
}
