package HashMap;

import java.util.HashMap;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0, rem = 0, ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0; i < A.length; i++){
            sum += A[i];
            rem = sum % K;

            // rem = k*n - y;
            if(rem < 0){ // y = kn - y = kn - y + k - k = k(n - 1) - y + k = km + k - y = (km + k - y) % k = k - y = k + rem
                rem = K + rem;
            }

            if(map.containsKey(rem)){
                ans += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            } else {
                map.put(rem, 1);
            }
        }
        return ans;
    }
}
