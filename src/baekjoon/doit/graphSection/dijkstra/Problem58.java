package src.baekjoon.doit.graphSection.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem58 {

    private static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
        }

        // 각 노드에서 K번째 최단 경로를 저장하는 우선순위 큐 배열
        PriorityQueue<Integer>[] dist = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = new PriorityQueue<>(k, Collections.reverseOrder());
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        dist[1].offer(0);

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int now = current.target;
            int cost = current.value;

            for (Edge edge : graph[now]) {
                int next = edge.target;
                int nextCost = cost + edge.value;

                if (dist[next].size() < k) {
                    dist[next].offer(nextCost);
                    pq.offer(new Edge(next, nextCost));
                } else if (dist[next].peek() > nextCost) {
                    dist[next].poll();
                    dist[next].offer(nextCost);
                    pq.offer(new Edge(next, nextCost));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i].size() < k) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i].peek());
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        private int target;
        private int value;

        public Edge(int target, int value) {
            this.target = target;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
