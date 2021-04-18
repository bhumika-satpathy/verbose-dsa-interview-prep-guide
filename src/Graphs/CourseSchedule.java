package Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.
public class CourseSchedule {
    List<Integer>[] adjList;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean ans = false;
        boolean[] visited = new boolean[numCourses];
        adjList = new List[numCourses];
        for(int i = 0; i < numCourses; i++)
            adjList[i] = new ArrayList<>();

        for(int i = 0; i < prerequisites.length; i++){
            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        boolean[] recursionStk = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(isCyclic(visited, i, recursionStk))
                    return false;
            }
        }
        return true;
    }

    boolean isCyclic(boolean[] visited, int start, boolean[] recursionStk){
        if(recursionStk[start])
            return true;
        if(visited[start])
            return false;

        recursionStk[start] = true;
        visited[start] = true;

        Iterator<Integer> it = adjList[start].listIterator();

        while(it.hasNext()){
            int x = it.next();

            if(isCyclic(visited, x, recursionStk))
                return true;
        }
        recursionStk[start] = false;
        return false;
    }
}
