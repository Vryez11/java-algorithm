package src.leetcode.leetcode75.prefixsum.day23;

public class Solution {

    // Find the Highest Altitude
    public int largestAltitude(int[] gain) {

        int[] S = new int[gain.length + 1];
        S[0] = 0;

        int res = 0;
        for (int i = 0; i < gain.length; i++) {
            S[i + 1] = gain[i] + S[i];
            res = Math.max(res, S[i + 1]);
        }

        return res;
    }
}
