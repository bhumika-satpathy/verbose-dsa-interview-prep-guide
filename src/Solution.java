import java.util.*;

public class Solution {

        public static int maximumRemovals(String s, String p, int[] removable) {
            int[][] dp = new int[s.length() + 1][p.length() + 1];

            for(int i = 0; i <= s.length(); i++) {
                for(int j = 0; j <= p.length(); j++) {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 0;
                    } else if(s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            List<Integer> indices = new ArrayList<>();
            int i = s.length(), j = p.length();

            while(i > 0 && j > 0) {
                if(s.charAt(i - 1) == p.charAt(j - 1)) {
                    indices.add(i);
                    i--;
                    j--;
                } else if(dp[i - 1][j] == dp[i][j - 1]) {
                    indices.add(i);
                    i--;
                } else if(dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }

            int ans = 0;
            for(int num: removable) {
                if(indices.contains(num)) {
                    continue;
                }
                ans++;
            }
            return ans;
        }

        public static void main(String[] args) {
            int x = maximumRemovals("abcacb", "ab", new int[] {3,1,0});
            System.out.print(x);
        }



}