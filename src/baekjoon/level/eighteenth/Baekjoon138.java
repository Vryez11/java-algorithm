package src.baekjoon.level.eighteenth;

import java.io.*;
import java.util.*;

public class Baekjoon138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        List<String> words = new ArrayList<>(wordMap.keySet());

        words.sort((o1, o2) -> {
            int freq1 = wordMap.get(o1);
            int freq2 = wordMap.get(o2);
            if (freq1 != freq2) return freq2 - freq1;
            if (o1.length() != o2.length()) return o2.length() - o1.length();
            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
