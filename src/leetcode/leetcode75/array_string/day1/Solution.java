package src.leetcode.leetcode75.array_string.day1;

public class Solution {

    // Merge Strings Alternately
    public String mergeAlternately(String word1, String word2) {

        int minLen = Math.min(word1.length(), word2.length());
        int maxLen = Math.max(word1.length(), word2.length());
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            sb.append(chars1[i]).append(chars2[i]);
        }

        for (int i = minLen; i < maxLen; i++) {
            if (word1.length() > i) {
                sb.append(chars1[i]);
            } else {
                sb.append(chars2[i]);
            }
        }

        return sb.toString();
    }
}
