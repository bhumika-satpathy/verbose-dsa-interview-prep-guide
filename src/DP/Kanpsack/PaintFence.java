package DP.Kanpsack;

import java.util.HashMap;

// You are painting a fence of n posts with k different colors. You must paint the posts following these rules:
//
//    Every post must be painted exactly one color.
//    There cannot be three or more consecutive posts with the same color.
//
//Given the two integers n and k, return the number of ways you can paint the fence.
// https://leetcode.com/problems/paint-fence/


// More like this:
//        70. Climbing Stairs (Easy)
//
//        198. House Robber (Medium)
//
//        256. Paint House (Medium)
//
//        509. Fibonacci Number (Easy)
//
//        746. Min Cost Climbing Stairs (Easy)
//
//        931. Minimum Falling Path Sum (Medium)
public class PaintFence {
    HashMap<Integer, Integer> memoize = new HashMap<>();
    public int numWays(int n, int k) {
        if(n == 1) {
            return k;
        }
        if(n == 2) {
            return k * k;
        }

        memoo(n, k);
        return memoize.get(n);
    }

    public int memoo(int n, int k) {
        if(n == 1) {
            return k;
        }
        if(n == 2) {
            return k * k;
        }

        if(memoize.containsKey(n)) {
            return memoize.get(n);
        }
        memoize.put(n, (k - 1) * (memoo(n - 1, k) + memoo(n - 2, k)));
        return memoize.get(n);
    }

    // ------------------- Using Tabulation ----------------------------------------------------------------------------
    public int numWays2(int n, int k) {
        // Base cases for the problem to avoid index out of bound issues
        if (n == 1) return k;
        if (n == 2) return k * k;

        int totalWays[] = new int[n + 1];
        totalWays[1] = k;
        totalWays[2] = k * k;

        for (int i = 3; i <= n; i++) {
            totalWays[i] = (k - 1) * (totalWays[i - 1] + totalWays[i - 2]);
        }

        return totalWays[n];
    }

    // --------------- Using constant space ----------------------------------------------------------------------------
    public int numWays3(int n, int k) {
        if (n == 1) return k;

        int twoPostsBack = k;
        int onePostBack = k * k;

        for (int i = 3; i <= n; i++) {
            int curr = (k - 1) * (onePostBack + twoPostsBack);
            twoPostsBack = onePostBack;
            onePostBack = curr;
        }

        return onePostBack;
    }
}
