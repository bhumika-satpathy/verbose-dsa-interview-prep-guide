package Stack;
import java.util.Stack;

/*
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made.
It is guaranteed that the answer is unique.
 */


public class RemoveAllAdjacentDuplicatesInAString {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> cnt = new Stack<>();

        for(int i = 0; i < sb.length(); i++){
            if(i == 0 || sb.charAt(i) != sb.charAt(i - 1))
                cnt.push(1);
            else {
                int inc = cnt.pop() + 1;
                if(inc == k){
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
                else cnt.push(inc);
            }
        }

        return sb.toString();
    }
}
