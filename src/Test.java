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
        Vertex f = new Vertex("F");
        Edge ab = new Edge(a, b, 2);
        Edge ad = new Edge(a, d, 1);
        Edge ae = new Edge(a, e, 3);
        Edge bc = new Edge(b, c, 1);
        Edge be = new Edge(b, e, 0);
        Edge bf = new Edge(b, f, 5);
        Edge ef = new Edge(e, f, 10);
        Edge cf = new Edge(c, f, 10);
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        edges.add(ab);
        edges.add(ae);
        edges.add(ad);
        edges.add(bc);
        edges.add(be);
        edges.add(bf);
        edges.add(ef);
        edges.add(cf);


        MyGraph g = new MyGraph(vertices, edges);
        g.shortestPath(a, e);

    }
}