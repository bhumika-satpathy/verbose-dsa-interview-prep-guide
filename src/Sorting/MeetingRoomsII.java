package Sorting;

import java.util.Arrays;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int i = 0, j = 0;

        while(i < intervals.length){
            if(starts[i] < ends[j]){
                rooms++;
                i++;
            } else {
                j++;
                i++;
            }
        }

        return rooms;
    }
}
