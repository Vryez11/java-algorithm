package src.baekjoon.level.thirteenth;

import java.io.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Baekjoon101 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<String> pq = new PriorityQueue<>(new StringComparator());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            if (!set.contains(temp)) {
                pq.add(temp);
                set.add(temp);
            }
        }

        while (!pq.isEmpty()) {
            bw.write(pq.poll() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return Integer.compare(o1.length(), o2.length());
            }
        }
    }
}
