package src.leetcode.leetcode75.slidingwindow.day15;

public class Solution {

    // Maximum Average Subarray 1
    public double findMaxAverage(int[] nums, int k) {

        double avg = 0;
        double maxAvg = 0;
        for (int i = 0; i < k; i++) {
            avg += nums[i];
        }
        avg /= k;
        maxAvg = avg;

        for (int i = 0; i < nums.length - k; i++) {
            avg += ((double) nums[i + k] - nums[i]) / k;
            maxAvg = Math.max(maxAvg, avg);
        }

        return maxAvg;
    }
}
