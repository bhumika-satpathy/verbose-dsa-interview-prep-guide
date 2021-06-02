package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
//
//Implement the FreqStack class:
//
//FreqStack() constructs an empty frequency stack.
//void push(int val) pushes an integer val onto the top of the stack.
//int pop() removes and returns the most frequent element in the stack.
//If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
//
public class MaximumFrequencyStack {
    HashMap<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> frequenciesHavingElements;
    int maxFreq;
    public MaximumFrequencyStack() {
        freq = new HashMap<>();
        frequenciesHavingElements = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        if(maxFreq < f){
            maxFreq = f;
        }
        frequenciesHavingElements.computeIfAbsent(f, z-> new Stack()).push(val);
    }

    public int pop() {
        int x = frequenciesHavingElements.get(maxFreq).pop();
        freq.put(x, freq.get(x) - 1);

        if(frequenciesHavingElements.get(maxFreq).size() == 0){
            maxFreq--;
        }
        return x;
    }
}
