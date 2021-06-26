package BitManipulation;

// Let's first check if xx is a power of two: x > 0 and x & (x - 1) == 0. Now one could be sure that x = 2^ax=2
//a
// . Though xx is a power of four only if aa is even.
//
//Next step is to consider both cases a = 2ka=2k and a = 2k + 1a=2k+1, and to compute xx modulo after division by three:
//
//(2^{2k} \mod 3) = (4^k \mod 3) = ((3 + 1)^k \mod 3) = 1(2
//2k
// mod3)=(4k mod3)=((3+1)k mod3)=1
//
//((2^{2k + 1}) \mod 3) = ((2 \times 4^k) \mod 3) = ((2 \times(3 + 1)^k) \mod 3) = 2((2 . 2k+1)mod3)=((2×4k)mod3)=((2×(3+1)k )mod3)=2
// If xx is a power of two and x % 3 == 1, then xx is a power of four.
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3) == 1;
    }
}
