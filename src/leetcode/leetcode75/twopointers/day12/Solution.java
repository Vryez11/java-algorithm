package src.leetcode.leetcode75.twopointers.day12;

import java.util.Arrays;

public class Solution {

    // Max Number of K-Sum Pairs
    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);

        int ans = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left] + nums[right] == k) {
                ans++;
                left++;
                right--;
                continue;
            }

            while (left < right && (nums[left] + nums[right]) < k) {
                left++;
            }
            while (left < right && (nums[left] + nums[right]) > k) {
                right--;
            }
        }

        return ans;
    }
}
