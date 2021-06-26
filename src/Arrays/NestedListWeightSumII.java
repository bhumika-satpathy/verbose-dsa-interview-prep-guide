package Arrays;

import java.util.*;

// You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
//
//The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth. Let maxDepth be the maximum depth of any integer.
//
//The weight of an integer is maxDepth - (the depth of the integer) + 1.
//
//Return the sum of each integer in nestedList multiplied by its weight.
// https://leetcode.com/problems/nested-list-weight-sum-ii/


// Note: Check Nested weight sum first(which is down below) and then the second part
public class NestedListWeightSumII {
    public interface NestedInteger {
//      // Constructor initializes an empty nested list.
//              public NestedInteger();
//
//              // Constructor initializes a single integer.
//              public NestedInteger(int value);

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // Set this NestedInteger to hold a single integer.
              public void setInteger(int value);

              // Set this NestedInteger to hold a nested list and adds a nested integer to it.
              public void add(NestedInteger ni);

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int sum = 0;
        return helper(nestedList, sum);
    }

    public int helper(List<NestedInteger> list, int sum) {
        int total = sum;
        List<NestedInteger> tmp = new ArrayList<>();

        for(NestedInteger ni: list) {
            if(ni.isInteger()) {
                total += ni.getInteger();
            } else {
                tmp.addAll(ni.getList());
            }
        }

        if(!tmp.isEmpty()) {
            total += helper(tmp, total);
        }

        return total;
    }




//    -------------------------- Nested Weight Sum 1 --------------------------------------------------
    // You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
//
//The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
//
//Return the sum of each integer in nestedList multiplied by its depth.
//
// https://leetcode.com/problems/nested-list-weight-sum/
public int depthSum(List<NestedInteger> nestedList) {
    int weight = 0, level = 1;
    List<NestedInteger> tmp = new ArrayList<>();

    while(!nestedList.isEmpty()) {
        tmp = new ArrayList<>();
        for(NestedInteger ni: nestedList) {
            if(ni.isInteger()) {
                weight += (level * ni.getInteger());
            } else {
                tmp.addAll(ni.getList());
            }
        }
        nestedList = tmp;
        level++;
    }

    return weight;
}
}
