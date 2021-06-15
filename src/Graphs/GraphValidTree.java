package Graphs;

import java.util.*;

// You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
//
//Return true if the edges of the given graph make up a valid tree, and false otherwise.
// A tree is an acyclic and connected graph.
// Approach: Check if its cyclic and disconnected and return answer accordingly
// https://leetcode.com/problems/graph-valid-tree/
public class GraphValidTree {
    List<Integer>[] adjList;

    boolean isCycle(boolean[] visited, int v, int parent) {
        visited[v] = true;

        List<Integer> children = adjList[v];
        for(int child: children) {
            if(!visited[child]) {
                if(isCycle(visited, child, v)) {
                    return true;
                }
            } else if(child != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        adjList = new List[n];

        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        // This variable checks if the graph is connected or disconnected
        // If its disconnected, its not a tree
        boolean onceVisited = false;

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(onceVisited) {
                    return false;
                }
                if(!onceVisited) {
                    onceVisited = true;
                    if(isCycle(visited, i, -1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
