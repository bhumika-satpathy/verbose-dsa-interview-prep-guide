package BitManipulation;

// Given an integer n, return true if it is a power of two. Otherwise, return false.
//
//An integer n is a power of two, if there exists an integer x such that n == 2x.
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) {
            return false;
        }
        long x = (long)(n);
        return (x & -x) == x;
    }
}
