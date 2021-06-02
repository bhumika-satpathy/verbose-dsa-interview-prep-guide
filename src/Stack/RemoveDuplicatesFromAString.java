package Stack;

import java.util.Stack;

public class RemoveDuplicatesFromAString {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();

        for(char ch: s.toCharArray()){
            if(stk.isEmpty() || stk.peek() != ch){
                stk.push(ch);
            } else {
                while(!stk.isEmpty() && stk.peek() == ch){
                    stk.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: stk){
            sb.append(ch);
        }
        return sb.toString();
    }
}
