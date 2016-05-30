/**
 * Created by Kalvin on 5/21/2016.
 */
import java.util.*;
public class Test {
    public static void main(String[] args) {
        Set <Edge> edges = new HashSet<Edge>();
        List<Vertex> vertices = new ArrayList<Vertex>();
        Queue<Vertex> queue = new PriorityQueue<>();

        vertices.add(new Vertex("A"));
        vertices.add(new Vertex("B"));
        vertices.add(new Vertex("C"));
        vertices.add(new Vertex("D"));

        //vertices.get(3).setDistance(1);


       // queue.addAll(vertices);
        // System.out.println(queue.remove());


        Edge edge2 = new Edge(vertices.get(0), vertices.get(1),3);
        Edge edge3 = new Edge(vertices.get(2), vertices.get(3),10);
        Edge edge4 = new Edge(vertices.get(1), vertices.get(3), 2);
        Edge edge5 = new Edge(vertices.get(0), vertices.get(3), 7);
        Edge edge6 = new Edge(vertices.get(0), vertices.get(2), 1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        edges.add(edge6);


        MyGraph test = new MyGraph(vertices, edges);
        test.shortestPath(vertices.get(0), vertices.get(3));
    }
}
