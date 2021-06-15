package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// Approach: Try finding out if the graph is cyclic while accumulating numbers inside the stack
public class CourseScheduleII {
    List<Integer>[] adjList;

    boolean dfs(boolean[] visited, int v, Stack<Integer> stk, boolean[] recurStack) {
        // Meaning: The graph is cyclic in nature
        if(recurStack[v]) {
            return true;
        }
        // Means the vertex is already traversed and that the graph is acyclic in nature and hence return false
        if(visited[v]) {
            return false;
        }
        visited[v] = true;
        recurStack[v] = true;

        List<Integer> children = adjList[v];
        boolean res = false;
        for(int child: children) {
            res = dfs(visited, child, stk, recurStack);
            if(res) {
                return true;
            }
        }
        // Remove element from the recursion stack if the vertex is traversed already
        recurStack[v] = false;
        stk.push(v);

        return res;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> stk = new Stack<>();

        adjList = new List[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++) {
            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recurStack = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                boolean res = dfs(visited, i, stk, recurStack);
                if(res) {
                    return new int[0];
                }
            }
        }

        int[] ans = new int[stk.size()];
        int i = 0;
        while(!stk.isEmpty()) {
            ans[i++] = stk.pop();
        }

        return ans;
    }
}
