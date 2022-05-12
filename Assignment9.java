import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Assignment9 {

    public static void main(final String[] args) throws IOException {
        System.out.println("Hello world - this is assignment 9 in Java!");
        System.out.println("Let's create a graph with 1000 nodes.");
        Graph g = new Graph(1000);
        System.out.println("Please input an integer to search for in the graph.");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();
        System.out.println("Following is Breadth First Search (starting from vertex 0)");
        g.BFS(num);
        System.out.println("Following is Depth First Search (starting from vertex 0)");
        g.DFS(num);
        System.out.println("");
        System.out.println("That's all. Thanks for joining me!");
    }
}