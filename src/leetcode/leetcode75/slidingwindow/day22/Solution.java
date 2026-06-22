package src.leetcode.leetcode75.slidingwindow.day22;

public class Solution {

    // Longest Subarray of 1's After Deleting One Element
    public int longestSubarray(int[] nums) {

        int zero = 0, left = 0, max = 0;

        for (int right = 0; right < nums.length; right++){
            if (nums[right] == 0) zero++;

            while (zero > 1) if (nums[left++] == 0) zero--;

            max = Math.max(max, right - left + 1);
        }

        return --max;
    }
}
