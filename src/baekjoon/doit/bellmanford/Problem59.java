package src.baekjoon.doit.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem59 {

    private static Edge[] edges;
    private static long[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edges = new Edge[M + 1];
        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(A, B, C);
        }
        br.close();

        dist[1] = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (dist[edge.startCity] != INF && dist[edge.endCity] > dist[edge.startCity] + edge.value) {
                    dist[edge.endCity] = dist[edge.startCity] + edge.value;
                }
            }
        }
        boolean mCycle = false;
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if (dist[edge.startCity] != INF && dist[edge.endCity] > dist[edge.startCity] + edge.value) {
                mCycle = true;
            }
        }
        if (!mCycle) {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(dist[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
    }
    private static class Edge {
        private int startCity;
        private int endCity;
        private int value;

        public Edge(int startCity, int endCity, int value) {
            this.startCity = startCity;
            this.endCity = endCity;
            this.value = value;
        }
    }
}
