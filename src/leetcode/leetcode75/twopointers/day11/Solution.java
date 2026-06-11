package src.leetcode.leetcode75.twopointers.day11;

public class Solution {

    // Container With Most Water
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, h * width);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
