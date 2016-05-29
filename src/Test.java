/**
 * Created by Kalvin on 5/21/2016.
 */
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Random r = new Random();
        List<Vertex> vertices = new ArrayList<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Edge ab = new Edge(a, b, 2);
        Edge ac = new Edge(a, c, 3);
        Edge ad = new Edge(a, d, 5);
        Edge bc = new Edge(b, c, 2);
        Edge be = new Edge(b, e, 5);
        Edge cd = new Edge(c, d, 1);
        Edge ce = new Edge(c, e, 4);
        Edge de = new Edge(d, e, 2);
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        edges.add(ab);
        edges.add(ac);
        edges.add(ad);
        edges.add(bc);
        edges.add(be);
        edges.add(cd);
        edges.add(ce);
        edges.add(de);


        MyGraph g = new MyGraph(vertices, edges);
        g.shortestPath(a, e);

    }
}
