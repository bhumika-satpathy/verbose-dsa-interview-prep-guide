package Math;

// Count the number of prime numbers less than a non-negative number, n.
// https://leetcode.com/problems/count-primes/
public class CountPrimes {
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }

        boolean[] numbers = new boolean[n];

        for(int i = 2; i < Math.sqrt(n); i++) {
            if(numbers[i] == false) {
                for(int comp = i * i; comp < n; comp += i) {
                    numbers[comp] = true;
                }
            }
        }

        int noOfPrimes = 0;

        for(int i = 2; i < n; i++) {
            if(numbers[i] == false) {
                noOfPrimes++;
            }
        }

        return noOfPrimes;
    }
}
