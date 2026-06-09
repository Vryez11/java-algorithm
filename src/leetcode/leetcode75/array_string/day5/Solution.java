package src.leetcode.leetcode75.array_string.day5;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    // Reverse Words in a String
    public String reverseWords(String s) {

        String noTrimeString = s.trim();
        String[] words = noTrimeString.split(" ");
        Deque<String> stack = new ArrayDeque<>();
        for (String word : words) {
            if (word.isEmpty()) continue;

            stack.push(word.trim());
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString().trim();
    }
}
