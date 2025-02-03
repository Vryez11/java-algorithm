package src.programmers.lv2;

import java.util.PriorityQueue;

public class Problem36 {

   private PriorityQueue<String> pq;
   private String[] words = {"A", "E", "I", "O", "U"};

    // 모음사전
    public int solution(String word) {
        pq = new PriorityQueue<>();
        int count = 0;

        for (String alpha : words) {
            addQueue(alpha, 0);
        }

        while (!pq.isEmpty()) {
            count++;
            if (word.equals(pq.poll()))
                return count;
        }
        return -1;
    }

    private void addQueue(String word, int depth) {
        if (depth == 5) return;

        pq.add(word);
        for (int i = 0; i < words.length; i++) {
            addQueue(word + words[i], depth + 1);
        }
    }
}
