package Graphs;

import java.util.Iterator;
import java.util.List;

// Detect cycle in an undirected graph
// Time complex: O(v + e) where v and e are vertices and edges respectively
// Space complex: O(v)
public class DetectCycleInUndirected {

    class Graph {
        List<Integer>[] adjList;
        int vertices;

        Graph(int v){
            vertices = v;
            adjList = new List[v];
        }

        void addEdge(int v, int w){
            adjList[v].add(w);
        }

        boolean isCyclicUtil(boolean[] visited, int parent, int start){
            visited[start] = true;

            Iterator<Integer> it = adjList[start].listIterator();

            while(it.hasNext()){
                int x = it.next();
                if(!visited[x]){
                    if(isCyclicUtil(visited, start, x))
                        return true;
                } else if(x != parent)
                    return true;
            }
            return false;
        }

        boolean isCyclic(){
            boolean[] visited = new boolean[vertices];

            for(int i = 0; i < vertices; i++)
                if(!visited[i]){
                    if(isCyclicUtil(visited, -1, i))
                        return true;
                }
            return false;
        }
    }

}
