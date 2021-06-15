package Greedy;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }

        Arrays.sort(freq);
        int idleTime = (freq[25] - 1) * n;

        for(int i = 24; i >= 0 && idleTime > 0; i--) {
            idleTime -= Math.min(freq[i], (freq[25] - 1));
        }

        // IdleTime in this case denotes the number of extra slots that are to be created.
        idleTime = Math.max(0, idleTime);

        return idleTime + tasks.length;
    }
}
