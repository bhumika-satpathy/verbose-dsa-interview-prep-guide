package Graphs;

import java.util.Iterator;
import java.util.List;

// Detect cycle in a directed graph
// Time complex: O(v + e) where v and e are vertices and edges respectively
// Space complex: O(v)
public class DetectCycleInADirected {

    class Graph {
        int vertices;
        List<Integer>[] adjList;

        Graph(int v){
            vertices = v;
            adjList = new List[v];
        }

        void addEdge(int v, int w){
            adjList[v].add(w);
        }

        boolean isCyclicUtil(boolean[] visited, int start, boolean[] recursionStk){

            if(recursionStk[start])
                return true;

            // Acyclic graph
            if(visited[start])
                return false;

            visited[start] = true;
            recursionStk[start] = true;

            Iterator<Integer> it = adjList[start].listIterator();
            while(it.hasNext()){
                int x = it.next();
                if(isCyclicUtil(visited, x, recursionStk))
                    return true;
            }
            recursionStk[start] = false;
            return false;
        }

        boolean isCyclic(){
            boolean[] visited = new boolean[vertices];
            boolean[] recursionSTack = new boolean[vertices];

            for(int i = 0; i < vertices; i++){
                visited[i] = false;
                recursionSTack[i] = false;
            }

            for(int i = 0; i < vertices; i++)
                if(isCyclicUtil(visited, i, recursionSTack))
                    return true;
            return false;
        }
    }

}
