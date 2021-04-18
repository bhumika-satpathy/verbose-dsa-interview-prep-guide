package Graphs;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Stack;

// Implementation of topological sorting
// Time complex: O(v + e) where v and e are vertices and edges respectively
// Space complex: O(v)
// Only applicable to DAG (Directed Acyclic Graphs)
public class TopologicalSorting {

    class Graph {
        int vertices;
        List<Integer>[] adjList;

        Graph(int v){
            vertices = v;
            adjList = new List[vertices];
        }

        void addEdge(int v, int w){
            adjList[v].add(w);
        }

        void topologicalSort(){
            Stack<Integer> stack = new Stack<>();
            Boolean[] visited = new Boolean[vertices];

            for(int i = 0; i < vertices; i++)
                if(!visited[i])
                    topologicalSortUtil(visited, stack, i);

            while(!stack.isEmpty())
                System.out.print(stack.pop() + " ");
        }

        void topologicalSortUtil(Boolean[] visited, Stack<Integer> stack, int v){

            visited[v] = true;
            List<Integer> children = adjList[v];

            for(Integer c: children){
                if(!visited[c])
                    topologicalSortUtil(visited, stack, c);
            }

            stack.add(new Integer(v));
        }
    }

}
