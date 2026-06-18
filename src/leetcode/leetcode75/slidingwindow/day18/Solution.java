package src.leetcode.leetcode75.slidingwindow.day18;

public class Solution {

    // Max Consecutive Ones 3
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
