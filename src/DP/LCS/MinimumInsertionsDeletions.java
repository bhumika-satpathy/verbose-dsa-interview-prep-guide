package DP.LCS;

// Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert the minimum number of characters from/in str1 to transform it into str2.
// It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
public class MinimumInsertionsDeletions {

    static void Solution(){
        String str1 = "heap", str2 = "pea";
        LCS lcs = new LCS();

        int len = lcs.memoizedSolution(str1, str2, str1.length(), str2.length());
        int deletions = str1.length() >= str2.length() ? str1.length() - len : str2.length() - len;
        int insertions = str1.length() >= str2.length() ? str2.length() - len : str1.length() - len;

        System.out.print(insertions + " " + deletions + " " + len);
    }

    public static void main(String[] args){
        Solution();
    }

}