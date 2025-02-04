package src.baekjoon.doit.graphSection.bellmanford;

import java.io.*;
import java.util.*;

public class Problem60 {

    static class Edge {
        int start, end, cost;

        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    private static final long INF = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, -c); // 비용은 음수로 저장
        }

        long[] earnings = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            earnings[i] = Long.parseLong(st.nextToken());
        }
        br.close();

        long[] costs = new long[N];
        Arrays.fill(costs, INF);
        costs[start] = earnings[start];

        // 벨만-포드 알고리즘
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                if (costs[edge.start] != INF) {
                    if (costs[edge.end] < costs[edge.start] + earnings[edge.end] + edge.cost) {
                        costs[edge.end] = costs[edge.start] + earnings[edge.end] + edge.cost;
                    }
                }
            }
        }

        // 음수 사이클 탐지 및 도달 가능 여부 확인
        boolean[] reachable = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (Edge edge : edges) {
                if (costs[edge.start] != INF && costs[edge.end] < costs[edge.start] + earnings[edge.end] + edge.cost) {
                    costs[edge.end] = costs[edge.start] + earnings[edge.end] + edge.cost;
                    reachable[edge.end] = true; // 음수 사이클로 도달 가능한 도시 표시
                }
            }
        }

        // BFS로 음수 사이클이 도착 도시에 영향을 미치는지 확인
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (reachable[i]) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;
            for (Edge edge : edges) {
                if (edge.start == current && !visited[edge.end]) {
                    queue.add(edge.end);
                }
            }
        }

        // 결과 출력
        if (visited[end]) {
            System.out.println("Gee");
        } else if (costs[end] == INF) {
            System.out.println("gg");
        } else {
            System.out.println(costs[end]);
        }
    }
}
