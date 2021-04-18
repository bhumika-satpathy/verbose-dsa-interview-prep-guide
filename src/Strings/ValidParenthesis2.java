package Strings;

// Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
public class ValidParenthesis2 {
    boolean isValid(String s, int i, int j){
        for(int m = i; m <= (i + j)/2; m++){
            int n = j - m + i;
            if(s.charAt(m) != s.charAt(n))
                return false;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        for(int i = 0; i < s.length()/2; i++){
            int j = s.length() - i - 1;

            if(s.charAt(i) != s.charAt(j))
                return (isValid(s, i + 1, j) || isValid(s, i, j - 1));
        }
        return true;
    }
}
