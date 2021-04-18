package DP.LCS;


// Return if a string is a subsequence of the other
public class SequencePatternMatching {

    boolean Solution(String a, String b){
        LCS lcs = new LCS();
        int len = lcs.topDownDp(a, b);

        return len == (a.length() <= b.length() ? a.length() : b.length());
    }

}
