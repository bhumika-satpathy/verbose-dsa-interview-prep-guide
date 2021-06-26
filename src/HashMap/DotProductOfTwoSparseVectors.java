package HashMap;

import java.util.HashMap;

// Given two sparse vectors, compute their dot product.
//
//Implement class SparseVector:
//
//SparseVector(nums) Initializes the object with the vector nums
//dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
//A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.
//
//Follow up: What if only one of the vectors is sparse?
// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/

public class DotProductOfTwoSparseVectors {
    HashMap<Integer, Integer> map;
    SparseVector(int[] nums) {
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for(int index: vec.map.keySet()) {
            if(this.map.containsKey(index)) {
                res += this.map.get(index) * vec.map.get(index);
            }
        }
        return res;
    }
}
