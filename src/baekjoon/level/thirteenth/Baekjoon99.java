package src.baekjoon.level.thirteenth;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon99 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Index> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Index(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while (!pq.isEmpty()) {
            Index i = pq.poll();
            bw.write(i.x + " " + i.y + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Index implements Comparable<Index> {
        int x;
        int y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Index o) {
            if (this.x == o.x) {
                return Integer.compare(this.y, o.y);
            } else {
                return Integer.compare(this.x, o.x);
            }
        }
    }
}
