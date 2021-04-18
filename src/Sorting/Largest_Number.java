package Sorting;

import java.util.Arrays;

public class Largest_Number {
    public String largestNumber(int[] nums) {
        String[] numsAsStrs = new String[nums.length];

        for(int i = 0; i < nums.length; i++){
            numsAsStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsAsStrs, (a, b) -> (b + a).compareTo(a + b));

        if(numsAsStrs[0].equals("0"))
            return "0";

        String res = "";
        for(int i = 0; i < nums.length; i++)
            res += numsAsStrs[i];

        return res;
    }
}
