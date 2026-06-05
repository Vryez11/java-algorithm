package src.leetcode.leetcode75.array_string.day5morning;

public class Solution1 {

    // Reverse Words in a String
    public String reverseWords(String s) {

        String noTrimeString = s.trim();
        String[] words = noTrimeString.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--){
            if (words[i].isEmpty()) continue;

            sb.append(words[i]).append(" ");
        }

        return sb.toString().trim();
    }
}
