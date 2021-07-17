package Stack;

import java.util.Stack;

// Given a rows * columns matrix mat of ones and zeros, return how many submatrices have all ones.
// https://leetcode.com/problems/count-submatrices-with-all-ones/
// https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720280/Java-histogram-count
/*
    Approach: Traverse the
*/
public class CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] h = new int[n];
        Stack<int[]> stk = new Stack<>();
        int res = 0;

        for(int i = 0; i < m; i++) {
            stk = new Stack<>();
            for(int j = 0; j < n; j++) {
                h[j] = mat[i][j] == 0 ? 0 : h[j] + 1;

                int sum = 0;
                while(!stk.isEmpty() && h[stk.peek()[0]] >= h[j]) {
                    stk.pop();
                }
                sum = stk.isEmpty() ? h[j] * (j + 1) : h[j] * (j - stk.peek()[0]) + stk.peek()[1];
                stk.push(new int[] {j, sum});
                res += sum;
            }
        }
        return res;
    }
}
