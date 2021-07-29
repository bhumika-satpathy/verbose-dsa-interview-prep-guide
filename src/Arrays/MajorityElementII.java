package Arrays;

import java.util.*;

// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//
//Follow-up: Could you solve the problem in linear time and in O(1) space?
// https://leetcode.com/problems/majority-element-ii/submissions/
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        Integer cand1 = null, cand2 = null;
        int cnt1 = 0, cnt2 = 0;

        for(int n: nums) {
            if(cand1 != null && cand1 == n) {
                cnt1++;
            } else if(cand2 != null && cand2 == n) {
                cnt2++;
            } else if(cnt1 == 0) {
                cand1 = n;
                cnt1++;
            } else if(cnt2 == 0) {
                cand2 = n;
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> res = new ArrayList<>();

        cnt1 = 0; cnt2 = 0;

        for(int n: nums) {
            if(cand1 != null && cand1 == n) {
                cnt1++;
            }
            if(cand2 != null && cand2 == n) {
                cnt2++;
            }
        }

        int n = nums.length;
        if(cnt1 > n / 3) {
            res.add(cand1);
        }
        if(cnt2 > n / 3) {
            res.add(cand2);
        }

        return res;
    }
}
