package src.baekjoon.doit.dijkstra;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem58Ref {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int N, M, K;
        int[][] W = new int[1001][1001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] dist = new PriorityQueue[N + 1];
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };
        for (int i = 0; i < N + 1; i++) {
            dist[i] = new PriorityQueue<>(K, cp);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            W[a][b] = c;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1].add(0);
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (int i = 1; i <= N; i++) {
                if (W[now.node][i] != 0) {
                    if (dist[i].size() < K) {
                        dist[i].add(now.cost + W[now.node][i]);
                        pq.add(new Node(i, now.cost + W[now.node][i]));
                    } else if (dist[i].peek() > now.cost + W[now.node][i]) {
                        dist[i].poll();
                        dist[i].add(now.cost + W[now.node][i]);
                        pq.add(new Node(i, now.cost + W[now.node][i]));
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i].size() == K) {
                bw.write(dist[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost < o.cost ? -1: 1;
        }
    }
}
