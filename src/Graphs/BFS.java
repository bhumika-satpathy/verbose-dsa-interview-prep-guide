package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BFS of a graph
// Time complex: O(v + e) where v and e are vertices and edges respectively
// Space complex: O(v)
public class BFS {

    class Graph {
        int vertices;
        List<Integer>[] adjList;

        Graph(int v){
            vertices = v;
            adjList = new List[v];
        }

        // Add w to the edge v
        void addEdge(int v, int w){
            adjList[v].add(w);
        }

        // Calculate BFS of a given source s
        void bfs(int s){
            boolean[] visited = new boolean[vertices];
            visited[s] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(s);

            while(!q.isEmpty()){
                int x = q.poll();
                System.out.print(x + " ");
                Iterator<Integer> i = adjList[x].listIterator();

                while(i.hasNext()){
                    int y = i.next();
                    if(!visited[y]){
                        q.add(y);
                        visited[y] = true;
                    }
                }
            }
        }
    }
}
