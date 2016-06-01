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

        Edge ab = new Edge(a, b, 5);
        Edge ae = new Edge(a, e, 1000);
        Edge bd = new Edge(b, d, 0);
        Edge de = new Edge(d, e, 54);
        Edge ec = new Edge(e, c, 12);
        Edge cf = new Edge(c, f, 35);
        Edge ea = new Edge(e, a, 512);
        Edge fa = new Edge(f, a, 10);
        edges.add(ab);
        edges.add(ae);
        edges.add(bd);
        edges.add(de);
        edges.add(ec);
        edges.add(cf);
        edges.add(ea);
        edges.add(fa);
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);


        Scanner console = new Scanner(System.in);

        MyGraph g = new MyGraph(vertices, edges);
        while (true) {
            System.out.println("Enter from vertex (A - F)");
            Vertex from = new Vertex(console.next());
            System.out.println("Enter to vertex (A - F)");
            Vertex to = new Vertex(console.next());
            Path p = g.shortestPath(from, to);
            System.out.println(p.vertices.toString());
            System.out.println(p.cost);
        }



    }
}