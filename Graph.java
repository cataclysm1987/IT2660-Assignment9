import java.io.*;
import java.util.*;

class Graph
{
    private int V;  
    private LinkedList<Integer> adj[]; 
    private boolean found;
 
    // Constructor
    Graph(int v)
    {
        found = false;
        Random r = new Random();
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i){
            adj[i] = new LinkedList<Integer>();
            int val = r.nextInt(100000 - 1) + 1;
            adj[i].add(val);
        }
        for (int i = 0; i < v; i++){
            for (int j = 0; j < 5; j++){
                int randindex = r.nextInt(999);
                try {
                    this.addEdge(i, randindex);
                } catch (Exception ex){
                    System.out.println("Cannot insert at index: " + i + " for value: " + randindex);
                }
                
                
            }
        }
            
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
 
    // prints BFS traversal from a given source s
    void BFS(int search)
    {
        int s = 0;
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        boolean bfsfound = false;
        while (queue.size() != 0 && bfsfound == false)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            
            
            int val = adj[s].getFirst();
            if (val == search){

                System.out.println("Value: " + search + " found at vertex: " + s );
                bfsfound = true;
            } else {

                LinkedList<Integer> adjints = adj[s];
                adjints.removeFirst();
                Iterator<Integer> i = adjints.listIterator();
                while (i.hasNext())
                {
                
                int n = i.next();
                if (!visited[n])
                    {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            
        }
        System.out.println("Value: " + search + " was not found in graph using Breadth First Search.");
    }

    void DFSUtil(int v, int search, boolean visited[])
    {
        visited[v] = true;
 

        LinkedList<Integer> adjints = adj[v];
        int val = adjints.getFirst();
        if (val == search){
            System.out.println("");
            System.out.println("Value: " + val + " found at vertex: " + v + " using depth first search.");
        } else {
            adjints.removeFirst();
            Iterator<Integer> i = adjints.listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, search, visited);
            }
        }
        
    }
 
    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int search)
    {
        found = false;
        int v = 0;
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, search, visited);
        if (found == false){
            System.out.println("Value: " + search + " was not found in graph using Depth First Search.");
        }
    }
}