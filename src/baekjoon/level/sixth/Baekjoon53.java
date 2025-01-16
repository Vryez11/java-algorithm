package src.baekjoon.level.sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon53 {

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        count = 0;

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            isSequence(words[i]);
        }

        System.out.println(count);
        br.close();
    }

    private static void isSequence(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = word.indexOf(c); j < word.lastIndexOf(c); j++) {
                char cc = word.charAt(j);
                if (cc != c) return;
            }
        }
        count++;
    }
}
