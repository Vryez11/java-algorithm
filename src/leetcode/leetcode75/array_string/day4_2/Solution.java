package src.leetcode.leetcode75.array_string.day4_2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    // Revers Vowels of a String
    public String reverseVowels(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (isVowel(ch)) stack.push(ch);
        }

        for (int i = 0; i < chars.length; i++) {
            if (!isVowel(chars[i])) continue;

            Character nowCh = stack.pop();
            chars[i] = nowCh;
        }

        return String.valueOf(chars);
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
