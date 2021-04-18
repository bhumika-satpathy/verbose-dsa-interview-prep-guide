package Graphs;

// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
//A province is a group of directly or indirectly connected cities and no other cities outside of the group.
//You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
//Return the total number of provinces.
import java.util.LinkedList;
import java.util.Queue;

public class NumberofProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                q.add(i);
                while(!q.isEmpty()){
                    int s = q.poll();
                    visited[s] = 1;
                    for(int j = 0; j < n; j++){
                        if(isConnected[s][j] == 1 && visited[j] == 0)
                            q.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }
}
