package BitManipulation;

// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.
// https://leetcode.com/problems/single-number/
// Concept
//
//If we take XOR of zero and some bit, it will return that bit
//a \oplus 0 = aa⊕0=a
//If we take XOR of two same bits, it will return 0
//a \oplus a = 0a⊕a=0
//a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b
//So we can XOR all bits together to find the unique number.
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
