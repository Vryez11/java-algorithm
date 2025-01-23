package src.baekjoon.doit.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem56 {

    private static List<dNode>[] A;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        A = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
        }
        result = new int[V + 1];
        Arrays.fill(result, Integer.MAX_VALUE);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A[u].add(new dNode(v, w));
        }
        br.close();

        PriorityQueue<dNode> pq = new PriorityQueue<>();
        result[K] = 0;
        pq.add(new dNode(K, 0));
        while (!pq.isEmpty()) {
            dNode now = pq.poll();
            if (now.value > result[now.target]) continue;

            for (dNode next : A[now.target]) {
                if (result[next.target] > result[now.target] + next.value) {
                    result[next.target] = result[now.target] + next.value;
                    pq.add(new dNode(next.target, result[next.target]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(result[i]);
            }
        }
    }

    static class dNode implements Comparable<dNode> {
        private int target;
        private int value;

        public dNode(int target, int value) {
            this.target = target;
            this.value = value;
        }

        @Override
        public int compareTo(dNode o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
