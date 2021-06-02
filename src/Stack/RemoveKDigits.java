package Stack;

import java.util.Stack;

// Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < num.length(); i++){
            while(!stk.isEmpty() && stk.peek() > num.charAt(i) && k > 0){
                stk.pop();
                k = k - 1;
            }
            stk.push(num.charAt(i));
        }

        for(int i = 0; i < k; i++){
            stk.pop();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stk){
            if(leadingZero && digit == '0'){
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
