package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
public class LetterCombinationsOfAPhoneNumber {
    List<String> combs = new ArrayList<>();
    Map<Character, String> numToChar = Map.of(
            '2', "abc",'3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return combs;
        findCombs(digits, 0, new StringBuilder());
        return combs;
    }

    void findCombs(String digits, int index, StringBuilder path){
        if(path.length() == digits.length()){
            combs.add(path.toString());
            return;
        }

        String possibleChars = numToChar.get(digits.charAt(index));
        for(char ch: possibleChars.toCharArray()){
            path.append(ch);
            findCombs(digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
