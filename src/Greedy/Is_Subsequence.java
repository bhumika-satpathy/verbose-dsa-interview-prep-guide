package Greedy;

public class Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        int l = 0, r = 0;
        int lBound = s.length(), rBound = t.length();

        while(l < lBound && r < rBound){
            if(s.charAt(l) == t.charAt(r))
                l++;
            r++;
        }
        return l == lBound;
    }
}
