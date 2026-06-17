package src.leetcode.leetcode75.slidingwindow.day17;

public class Solution {

    // Maximum Number of Vowels in a Substring of Given Length
    public int maxVowels(String s, int k) {

        int left = 0;
        int right = k - 1;
        int tempVowelsCount = 0;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (isVowel(sChars[i])) {
                tempVowelsCount++;
            }
        }
        int maxVowelsCount = tempVowelsCount;

        while (left < s.length() - k) {
            if (isVowel(sChars[left])) {
                tempVowelsCount--;
            }

            left++;
            right++;
            
            if (isVowel(sChars[right])) {
                tempVowelsCount++;
            }

            maxVowelsCount = Math.max(maxVowelsCount, tempVowelsCount);
        }

        return maxVowelsCount;
    }

    private boolean isVowel(char ch) {
        return switch (ch) {
            case 'a', 'i', 'e', 'o', 'u' -> true;
            default -> false;
        };
    }
}
