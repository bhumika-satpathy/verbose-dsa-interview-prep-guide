package Greedy;

public class Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr_total = 0, cnt = 1, curr_id = 0;
        int i = 0;

        for(i = 0; i < gas.length && cnt <= gas.length;){
            if(curr_id >= gas.length && cnt <= gas.length && curr_total >= 0)
                curr_id = curr_id - gas.length;
            curr_total += gas[curr_id] - cost[curr_id];
            if(curr_total < 0){
                curr_total = 0;
                cnt = 1;
                i++;
                curr_id = i;
                continue;
            }
            cnt++;
            curr_id++;
        }
        return i < gas.length ? i : -1;
    }
}
