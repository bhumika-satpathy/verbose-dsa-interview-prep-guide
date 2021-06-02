package Stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

// Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();
        HashSet<Character> seen = new HashSet<>();

        HashMap<Character, Integer> lastSeenAt = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            lastSeenAt.put(s.charAt(i), i);
        }

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!seen.contains(ch)){
                while(!stk.isEmpty() && ch < stk.peek() && lastSeenAt.get(stk.peek()) > i){
                    seen.remove(stk.pop());
                }
                seen.add(ch);
                stk.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
