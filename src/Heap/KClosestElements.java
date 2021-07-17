package Heap;

import java.util.*;

// Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
//
//An integer a is closer to x than an integer b if:
//
//|a - x| < |b - x|, or
//|a - x| == |b - x| and a < b
// https://leetcode.com/problems/find-k-closest-elements/
public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> Math.abs(n1 - x) == Math.abs(n2 - x) ? n2.compareTo(n1) : Math.abs(n2 - x) - Math.abs(n1 - x));

        for(int num: arr) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int num: pq) {
            res.add(num);
        }
        Collections.sort(res);
        return res;
    }
}
