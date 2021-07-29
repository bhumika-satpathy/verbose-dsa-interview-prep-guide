package Arrays;

// You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].
//
//You have an array arr of length length with all zeros, and you have some operation to apply on arr. In the ith operation, you should increment all the elements arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.
//
//Return arr after applying all the updates.
// Time: O(n + k)
// Video ref: https://www.youtube.com/watch?v=-SDHYqxI-Hc
public class RangeAddition {
    public int[] getModifiedArray(int n, int[][] updates) {
        int[] ans = new int[n];

        for(int i = 0; i < updates.length; i++) {
            ans[updates[i][0]] += updates[i][2];

            if(updates[i][1] + 1 < n) {
                ans[updates[i][1] + 1] -= updates[i][2];
            }
        }

        for(int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }

        return ans;
    }
}
