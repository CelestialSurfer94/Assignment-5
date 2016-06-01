/**
 * Created by Kalvin on 5/21/2016.
 */
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Random r = new Random();
        Collection<Vertex> vertices = new ArrayList<Vertex>();
        Collection<Edge> edges = new ArrayList<Edge>();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Edge ab = new Edge(a, b, 2);
        Edge ac = new Edge(a, d, 1);
        Edge ad = new Edge(a, e, 1);
        Edge bc = new Edge(b, c, 1);
        Edge be = new Edge(b, e, 2);
        Edge cd = new Edge(b, f, 5);
        Edge de = new Edge(d, e, 9);
        Edge ce = new Edge(e, f, 10);
        Edge cf = new Edge(c, f, 10);
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        edges.add(ab);
        edges.add(ac);
        edges.add(ad);
        edges.add(bc);
        edges.add(be);
        edges.add(cd);
        edges.add(ce);
        edges.add(cf);
        edges.add(de);



        MyGraph g = new MyGraph(vertices, edges);
        Path p = g.shortestPath(a,f);
        System.out.println(p.vertices);
        if(p.cost == Integer.MAX_VALUE){
            System.out.println("Path not reachable, cost therefore infinity");
        }else {
            System.out.println(p.cost);
        }
    }
}