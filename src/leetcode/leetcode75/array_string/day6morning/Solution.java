package src.leetcode.leetcode75.array_string.day6morning;

public class Solution {

    // Product of Array Except Self
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        int[] dpHead = new int[nums.length];
        int[] dpTail = new int[nums.length];
        dpHead[0] = nums[0];
        dpTail[dpTail.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < result.length; i++) {

            dpHead[i] = dpHead[i - 1] * nums[i];
            dpTail[dpTail.length - 1 - i] = dpTail[dpTail.length - i] * nums[dpTail.length - 1 - i];
        }

        for (int i = 0; i < result.length; i++) {

            if (i == 0) {
                result[i] = dpTail[i + 1];
                continue;
            }

            if (i == result.length - 1) {
                result[i] = dpHead[i - 1];
                continue;
            }

            result[i] = dpHead[i - 1] * dpTail[i + 1];
        }

        return result;
    }
}
