package src.baekjoon.doit.graphSection.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem57 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        List<Node>[] A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            A[start].add(new Node(end, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        br.close();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        costs[startCity] = 0;
        pq.add(new Node(startCity, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > costs[now.target]) continue;

            for (Node next : A[now.target]) {
                if (costs[next.target] > costs[now.target] + next.cost) {
                    costs[next.target] = costs[now.target] + next.cost;
                    pq.add(new Node(next.target, costs[next.target]));
                }
                System.out.println(pq);
            }
        }

        System.out.println(costs[endCity]);
    }

    static class Node implements Comparable<Node> {
        private int target;
        private int cost;

        public Node(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }

        @Override
        public String toString() {
            return "(" +
                    "target=" + target +
                    ", cost=" + cost +
                    ')';
        }
    }
}
