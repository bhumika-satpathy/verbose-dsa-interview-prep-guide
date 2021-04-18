import java.util.*;

public class GetNumberOfStringsMatchingThePrefix {

    // Compares the string with the prefix string and gives its status wrt the dictionary
    static int comparator(String str, String prefix){
        if(str.length() < prefix.length())
            return -1;
        int count = 0, i = 0;
       for(i = 0; i < prefix.length(); i++){
           if(prefix.charAt(i) == str.charAt(i))
               count++;
           else {
               break;
           }
       }
       // If count matches the prefix's length then its the correct match, else compare the strings based on their first unmatched character
       return count == prefix.length() ? 0 : Character.compare(Character.toLowerCase(str.charAt(i)), Character.toLowerCase(prefix.charAt(i)));
    }

    // Gets the list of strings that matches the given prefix
    static List<String> getSetOfStrings(List<String> setOfStrings, String prefix){

        // If there are no strings available
        if(setOfStrings.size() == 0)
            return null;

        int left = 0, right = setOfStrings.size() - 1;
        int res = 0;

        while(left <= right){
            int middle = (left + right)/2;
            String middleString = setOfStrings.get(middle);
            if(comparator(middleString, prefix) > 0){
                right = middle - 1;
            } else if(comparator(middleString, prefix) < 0){
                left = middle + 1;
            } else if(comparator(middleString, prefix) == 0){
                res = middle;
                break;
            }
        }

        // This step is needed to ensure that the words right after the current match are not missed
        while(res < setOfStrings.size() && comparator(setOfStrings.get(res), prefix) == 0)
            res++;

        return setOfStrings.subList(left, res);
    }

    public static void main(String[] args){
        // Assumed (like discussed) that the set of setOfStrings given are assumed to be sorted
        List<String> setOfStrings = new ArrayList<>();
        setOfStrings.add("amazing");
        setOfStrings.add("amazon");
        setOfStrings.add("amateur");
        setOfStrings.add("microsoft");
        setOfStrings.add("microhard");
        setOfStrings.add("visa");

        String prefix = "micro";

        List<String> res = getSetOfStrings(setOfStrings, prefix);
        System.out.println(res);
    }
}