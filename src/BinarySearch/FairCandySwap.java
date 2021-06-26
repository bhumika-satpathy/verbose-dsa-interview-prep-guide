package BinarySearch;

import java.util.HashSet;
import java.util.Set;

// Alice and Bob have candy bars of different sizes: aliceSizes[i] is the size of the i-th bar of candy that Alice has, and bobSizes[j] is the size of the j-th bar of candy that Bob has.
//
//Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
//
//Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
//
//If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
// https://leetcode.com/problems/fair-candy-swap/
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int a = 0, b = 0;
        for(int num: A) {
            a += num;
        }
        for(int num: B) {
            b += num;
        }

        int delta = (b - a)/2;
        Set<Integer> set = new HashSet<>();
        for(int num: B) {
            set.add(num);
        }

        for(int num: A) {
            if(set.contains(num + delta)) {
                return new int[] {num, num + delta};
            }
        }
        return null;
    }
}
