package src.leetcode.leetcode75.array_string.day4night;

public class Solution1 {

    // Revers Vowels of a String
    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (!isVowel(arr[l])) {
                l++;
            } else if (!isVowel(arr[r])) {
                r--;
            } else {
                char temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
                l++;
                r--;
            }
        }

        return String.valueOf(arr);
    }

    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);

        return ch == 'a'
                || ch == 'e'
                || ch == 'i'
                || ch == 'o'
                || ch == 'u';
    }
}
