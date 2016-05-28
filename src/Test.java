/**
 * Created by Kalvin on 5/21/2016.
 */
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Random r = new Random();
        List<Vertex> vertices = new ArrayList<Vertex>();
        Set<Edge> edges = new HashSet<Edge>();

        for (int i = 0; i < 5; i++) {
            vertices.add(new Vertex("" + ((char) i + 65)));
        }

        for (int i = 0; i < 5; i++) {
            edges.add(new Edge(vertices.get(r.nextInt(5)), vertices.get(r.nextInt(5)), r.nextInt(20)));
        }


        MyGraph g = new MyGraph(vertices, edges);

    }
}
