package Graphs;

import java.util.Iterator;
import java.util.List;
// Time complex: O(v + e) where v and e are vertices and edges respectively
// Space complex: O(v)
public class DFS {

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

        void dfs(boolean[] visited, int s){
            System.out.print(s + " ");
            visited[s] = true;

            Iterator<Integer> i = adjList[s].listIterator();
            while(i.hasNext()){
                int x = i.next();
                if(!visited[x])
                    dfs(visited, x);
            }
        }
    }

}
