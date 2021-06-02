package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
public class LetterCombinationsOfAPhoneNumber {
    // Map which stores letters and their respective letter combination
    Map<Character, String> numberAndTheirChars = Map.of(
            '2', "abc",'3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    // Resultant array which would store different combinations
    List<String> combinations = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // Base condition
        if(digits.length() == 0){
            return combinations;
        }

        int initialPoint = 0;
        backtrack(initialPoint, new StringBuilder(), digits);

        return combinations;
    }

    public void backtrack(int index, StringBuilder path, String digits){
        // If the path built till now is equivalent in length to that of the no of digits in the phone number,
        // then that means that the combination is made of desired size and
        // next move should be to backtrack and form other combinations
        if(path.length() == digits.length()){
            combinations.add(path.toString());
            return;
        }

        String letters = numberAndTheirChars.get(digits.charAt(index));
        for(char letter: letters.toCharArray()){
            path.append(letter);
            backtrack(index + 1, path, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
