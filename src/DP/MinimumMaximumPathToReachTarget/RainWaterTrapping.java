package DP.MinimumMaximumPathToReachTarget;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */

public class RainWaterTrapping {
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];

        maxL[0] = height[0];
        maxR[height.length - 1] = height[height.length - 1];

        for(int i = 1; i < height.length; i++){
            maxL[i] = Math.max(maxL[i - 1], height[i]);
        }

        for(int i = height.length - 2; i >= 0; i--){
            maxR[i] = Math.max(maxR[i + 1], height[i]);
        }

        int total = 0;
        for(int i = 0; i < height.length; i++){
            total += Math.min(maxL[i], maxR[i]) - height[i] > 0 ? Math.min(maxL[i], maxR[i]) - height[i] : 0;
        }

        return total;
    }
}
