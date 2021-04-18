package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack<>();
        List<Integer> ind = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(')
                stk.push(i);
            else if(ch == ')') {
                if(!stk.isEmpty())
                    stk.pop();
                else {
                    ind.add(i);
                }
            }
        }
        while(!stk.isEmpty())
            ind.add(stk.pop());
        String res = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ind.contains(i))
                continue;
            else res += ch;
        }

        return res;
    }
}
