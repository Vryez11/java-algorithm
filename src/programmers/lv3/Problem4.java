package src.programmers.lv3;

import java.util.PriorityQueue;

public class Problem4 {

    // 단어 변환
    public int solution(String begin, String target, String[] words) {

        boolean isWord = false;
        for (String word : words) {
            if (word.equals(target)) {
                isWord = true;
                break;
            }
        }

        if (!isWord) return 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        boolean[] visited = new boolean[words.length];

        pq.add(new Node(begin, 0));
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            System.out.println(now);

            String nowWord = now.word;
            int nowCount = now.count;

            if (nowWord.equals(target)) {
                return nowCount;
            }

            for(int i = 0; i < words.length; i++) {
                if (!visited[i]) {
                    int diff = 0;
                    for (int j = 0; j < target.length(); j++) {
                        if (nowWord.charAt(j) != words[i].charAt(j)) {
                            diff++;
                        }
                    }

                    if (diff == 1) {
                        pq.add(new Node(words[i], nowCount + 1));
                        visited[i] = true;
                    }
                }
            }
        }

        return 0;
    }

    class Node {
        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return word + " " + count;
        }
    }
}
