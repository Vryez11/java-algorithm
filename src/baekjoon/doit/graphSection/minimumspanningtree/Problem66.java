package src.baekjoon.doit.graphSection.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem66 {

    private static PriorityQueue<Edge> pq;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            char[] len = input.toCharArray();
            for (int j = 0; j < len.length; j++) {
                int value;
                if (len[j] == '0') continue;
                if (len[j] >= 'a' && len[j] <= 'z') {
                    value = len[j] - 'a' + 1;
                } else {
                    value = len[j] - 'A' + 27;
                }
                pq.add(new Edge(i, j, value));
            }
        }
        int useLen = 0;
        int sumLen = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            int start = now.s;
            int end = now.e;
            int value = now.v;

            if (find(start) != find(end)) {
                union(start, end);
                useLen++;
            } else {
                sumLen += value;
            }
        }
        if (useLen == N - 1) System.out.println(sumLen);
        else System.out.println(-1);
    }

    private static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            parents[j] = i;
        }
    }
    private static int find(int x) {
        if (x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    private static class Edge implements Comparable<Edge> {
        private int s;
        private int e;
        private int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }
}
