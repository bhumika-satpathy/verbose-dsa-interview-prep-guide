package Sorting;
import java.util.*;

public class Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> sol = new ArrayList<>();
        sol.add(new int[] {intervals[0][0], intervals[0][1]});
        int k = 0;

        for(int i = 1; i < intervals.length; i++){
            if(sol.get(k)[1] >= intervals[i][0]){
                int end = Math.max(sol.get(k)[1], intervals[i][1]);
                sol.set(k, new int[] {sol.get(k)[0], end});
            } else {
                sol.add(new int[] {intervals[i][0], intervals[i][1]});
                k++;
            }
        }

        return sol.toArray(new int[sol.size()][]);
    }
}
