package Heap;

import java.util.PriorityQueue;

// Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
//The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
//You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
public class KClosestPointsNearTheOrigin {

    int[][] kClosestPoints(int[][] points, int k, int size){
        PriorityQueue<int[]> pQ = new PriorityQueue<int[]>((p1, p2) -> p2[1]*p2[1] + p2[0]*p2[0] - p1[1]*p1[1] - p1[0]*p1[0]);

        for(int[]p : points){
            pQ.offer(p);
            if(pQ.size() > k)
                pQ.poll();
        }

        int[][] res = new int[k][2];
        while(k > 0){
            res[--k] = pQ.poll();
        }
        return res;
    }

}
