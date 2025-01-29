package src.baekjoon.doit.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem64 {

    private static PriorityQueue<Edge> edgeGraph;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int edgeCount = 0;
        int distMin = 0;

        edgeGraph = new PriorityQueue<>();
        parents = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edgeGraph.add(new Edge(A, B, C));
        }
        br.close();

        while (edgeCount < V - 1) {
            Edge edge = edgeGraph.poll();
            int node1 = edge.node1;
            int node2 = edge.node2;
            int value = edge.value;

            if (find(node1) != find(node2)) {
                union(node1, node2);
                edgeCount++;
                distMin += value;
            }
        }
        System.out.println(distMin);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parents[b] = a;
        }
    }
    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }
    private static class Edge implements Comparable<Edge>{
        private int node1;
        private int node2;
        private int value;

        public Edge(int node1, int node2, int value) {
            this.node1 = node1;
            this.node2 = node2;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }
}
